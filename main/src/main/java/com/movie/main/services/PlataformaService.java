package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.InvalidFormatException;
import com.movie.main.exceptions.PlataformaDuplicateException;
import com.movie.main.exceptions.TipoContenidoNotFound;
import com.movie.main.models.Plataforma;
import com.movie.main.models.TipoContenido;
import com.movie.main.repositories.PlataformaRepository;
import com.movie.main.repositories.TipoContenidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PlataformaService {
    @Autowired
    PlataformaRepository plataformaRepository;
    @Autowired
    TipoContenidoRepository tipoContenidoRepository;

    public Map<Object, Object> guardarPlataforma(Plataforma plataforma) {
        try {
            plataformaRepository.save(plataforma);
            return new LinkedHashMap<>() {
                {
                    put("message", "La plataforma ha sido registrada.");
                }
            };
        } catch (Exception e) {
            throw new PlataformaDuplicateException("La plataforma ingresada ya existe.");
        }
    }

    @Transactional
    public Map<Object, Object> agregarTipoContenido(Map<Object, Object> valores) {
        try {
            int tipoId = Integer.parseInt(valores.get("tipo_id").toString());

            int plataformaId = Integer.parseInt(valores.get("plataforma_id").toString());
            TipoContenido tipoContenido = tipoContenidoRepository.findById(tipoId)
                    .orElseThrow(() -> new TipoContenidoNotFound("El tipo de contenido ingresado no existe."));
            Plataforma plataforma = plataformaRepository.findById(plataformaId)
                    .orElseThrow(() -> new TipoContenidoNotFound("La plataforma ingresada no existe."));
            tipoContenido.getPlataformas().add(plataforma);
            plataforma.getTipocontenidos().add(tipoContenido);
            return new LinkedHashMap<>() {
                {
                    put("message", "Se ha agregado el tipo de contenido a la plataforma.");
                }
            };
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Los parametros ingresados no tienen un formato valido.");
        }
    }
}