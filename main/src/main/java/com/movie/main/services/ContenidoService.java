package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.ContenidoNotFoundException;
import com.movie.main.exceptions.InvalidNumberFormatException;
import com.movie.main.models.Contenido;
import com.movie.main.models.User;
import com.movie.main.models.dtos.ContenidoDTO;
import com.movie.main.models.dtos.ContenidoPostDTO;
import com.movie.main.repositories.ContenidoRepository;
import com.movie.main.repositories.UserRepository;



@Service
public class ContenidoService {
    // @Autowired
    // ContenidoRepository contenidoRepository;
    // @Autowired
    // UserRepository userRepository;
   

    // public List<ContenidoDTO> getAllContenido() {
    //     return contenidoRepository.findAll().stream().map(Contenido::toDTO).toList();

    // }



    //   public ContenidoDTO getContenidoById(Object id) {
    //     try {
    //         int parsedId = Integer.parseInt(id.toString());
    //         return contenidoRepository.findById(parsedId)
    //                 .map(Contenido::toDTO)
    //                 .orElseThrow(() -> new ContenidoNotFoundException("Contenido con ID " + parsedId + " no existe."));
    //     } catch (NumberFormatException e) {
    //         throw new InvalidNumberFormatException("El parametro ingresado no tiene un formato válido.");
    //     }
    // }


    //   public Map<Object, Object> saveContenido(ContenidoPostDTO contenidoPostDTO) {
    //     Contenido contenido = new Contenido();

    //     contenidoRepository.save(fromDTO(contenido, contenidoPostDTO));

    //     return new LinkedHashMap<>() {{
    //         put("message", "el contenido ha sido registrado.");
    //     }};
    // }


    // public Map<Object, Object> updateContenido(Object id, ContenidoPostDTO contenidoPostDTO) {
    //     try {
    //         int parsedId = Integer.parseInt(id.toString());

    //         Contenido contenidoToUpdate = contenidoRepository.findById(parsedId).orElseThrow(() -> new ContenidoNotFoundException("Contenido con ID " + parsedId + " no existe."));

    //         contenidoRepository.save(fromDTO(contenidoToUpdate, contenidoPostDTO));

    //         return new LinkedHashMap<>() {{
    //             put("message", "La contenido ha sido actualizada.");
    //         }};
    //     } catch (NumberFormatException e) {
    //         throw new InvalidNumberFormatException("El parametro ingresado no tiene un formato válido.");
    //     }
    // }

    // public Map<Object, Object> deleteContenido(Object id) {
    //     try {
    //         int parsedId = Integer.parseInt(id.toString());

    //         Contenido contenido = contenidoRepository.findById(parsedId).orElseThrow(() -> new ContenidoNotFoundException("contenido con ID " + parsedId + " no existe."));

    //         contenidoRepository.deleteById(parsedId);

    //         return new LinkedHashMap<>() {{
    //             put("message", "La factura ha sido eliminada.");
    //         }};
    //     } catch (NumberFormatException e) {
    //         throw new InvalidNumberFormatException("El parametro ingresado no tiene un formato válido.");
    //     }
    // }





    // public Contenido fromDTO(Contenido contenido, ContenidoPostDTO contenidoPostDTO) {
    //     contenido.setNombre(contenidoPostDTO.getNombre());
    //     contenido.setTipo_contenido(contenidoPostDTO.getTipo_contenido());
    //     contenido.setGenero(contenidoPostDTO.getGenero());
    //     contenido.setEstado(contenidoPostDTO.getEstado());
    //     contenido.setPlataforma(contenidoPostDTO.getPlataforma());
    //     contenido.setCalificacion(contenidoPostDTO.getCalificacion());
    //     contenido.setComentario(contenidoPostDTO.getComentario());

    //     Usuario user = userRepository.findById(contenidoPostDTO.getUserId()).
    //             orElseThrow(() -> new ContenidoNotFoundException("usuario con ID " + contenidoPostDTO.getUserId() + " no existe."));

    //     contenido.setUser(user);


    //     return contenido;
    // }
}
