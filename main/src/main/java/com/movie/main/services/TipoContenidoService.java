package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.InvalidFormatException;
import com.movie.main.exceptions.TipoContenidoDuplicateException;
import com.movie.main.exceptions.TipoContenidoNotFound;
import com.movie.main.models.Plataforma;
import com.movie.main.models.TipoContenido;
import com.movie.main.repositories.PlataformaRepository;
import com.movie.main.repositories.TipoContenidoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoContenidoService {
    @Autowired
    TipoContenidoRepository tipoContenidoRepository;
    @Autowired
    PlataformaRepository plataformaRepository;

    public Map<Object, Object> guardarTipoContenido(TipoContenido tipoContenido) {
        try {
            tipoContenidoRepository.save(tipoContenido);
            return new LinkedHashMap<>() {
                {
                    put("message", "El tipo de contenido ha sido registrado.");
                }
            };
        } catch (Exception e) {
            throw new TipoContenidoDuplicateException("El tipo de contenido ingresado ya existe.");
        }
    }

    @Transactional
    public Map<Object, Object> agregarPlataforma(Map<Object, Object> valores) {
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
                    put("message", "Se ha agregado la plataforma al tipo de contenido.");
                }
            };
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Los parametros ingresados no tienen un formato valido.");
        }
    }
}