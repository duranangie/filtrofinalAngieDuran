package com.movie.main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.main.models.dtos.ContenidoDTO;

import jakarta.persistence.*;
@Entity
@Table(name = "contenidos")
public class Contenido {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "nombre", nullable = false)
private String nombre;

@ManyToOne
@JoinColumn(name = "tipo_id", nullable = false)
private TipoContenido tipoContenido;

@ManyToOne
@JoinColumn(name = "genero1_id", nullable = false)
private Genero genero1;

@ManyToOne
@JoinColumn(name = "genero2_id")
private Genero genero2;

@Column(name = "estado", nullable = false)
private String estado;

@ManyToOne
@JoinColumn(name = "plataforma_id", nullable = false)
private Plataforma plataforma;

@Column(name = "calificacion", nullable = false)
private double calificacion;

@Column(name = "comentario", nullable = false)
private String comentario;

@ManyToOne
@JoinColumn(name = "usuario_id", nullable = false)
private User usuario;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public TipoContenido getTipoContenido() {
    return tipoContenido;
}

public void setTipoContenido(TipoContenido tipoContenido) {
    this.tipoContenido = tipoContenido;
}

public Genero getGenero1() {
    return genero1;
}

public void setGenero1(Genero genero1) {
    this.genero1 = genero1;
}

public Genero getGenero2() {
    return genero2;
}

public void setGenero2(Genero genero2) {
    this.genero2 = genero2;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public Plataforma getPlataforma() {
    return plataforma;
}

public void setPlataforma(Plataforma plataforma) {
    this.plataforma = plataforma;
}

public double getCalificacion() {
    return calificacion;
}

public void setCalificacion(double calificacion) {
    this.calificacion = calificacion;
}

public String getComentario() {
    return comentario;
}

public void setComentario(String comentario) {
    this.comentario = comentario;
}

public User getUsuario() {
    return usuario;
}

public void setUsuario(User usuario) {
    this.usuario = usuario;
}

}