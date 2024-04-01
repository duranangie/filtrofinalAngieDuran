package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.InvalidFormatException;
import com.movie.main.exceptions.UserDuplicateException;
import com.movie.main.models.Contenido;
import com.movie.main.models.Usuario;
import com.movie.main.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void validacionUsuario(String email, String contraseña) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null || !usuario.getContraseña().equalsIgnoreCase(contraseña)) {
            throw new UserDuplicateException("Las credenciales ingresadas no son validas.");
        }
    }

    public Map<Object, Object> registrarUsuario(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            return new LinkedHashMap<>() {
                {
                    put("message", "EL usuario ha sido registrado.");
                }
            };
        } catch (Exception e) {
            throw new UserDuplicateException("El correo ingresado ya esta asociado a otro usuario.");
        }
    }

    public Map<Object, Object> eliminarUsuario(Object id) {
        try {
            int parsedId = Integer.parseInt(id.toString());
            Usuario usuario = usuarioRepository.findById(parsedId)
                    .orElseThrow(() -> new UserDuplicateException("El usuario ingresado no existe."));
            usuarioRepository.deleteById(parsedId);
            return new LinkedHashMap<>() {
                {
                    put("message", "El usuario ha sido eliminado.");
                }
            };
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Los parametros ingresados no tienen un formato valido.");
        }
    }

    public List<Contenido> obtenerContenidos(Object id) {
        try {
            int parsedId = Integer.parseInt(id.toString());
            Usuario usuario = usuarioRepository.findById(parsedId)
                    .orElseThrow(() -> new UserDuplicateException("El usuario ingresado no existe."));
            return usuario.getContenidos();
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Los parametros ingresados no tienen un formato valido.");
        }
    }
}