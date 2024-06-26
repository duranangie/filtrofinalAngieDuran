package com.movie.main.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "usuarios")
public class Usuario {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @JsonIgnore
       private Integer id;
       @Column(name = "nombre", nullable = false)
       @JsonIgnore
       private String nombre;
       @Column(name = "email", nullable = false, unique = true)
       @JsonIgnore
       private String email;
       @Column(name = "contraseña", nullable = false)
       @JsonIgnore
       private String contraseña;
       @Transient
       private String token;
       @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
       private List<Contenido> contenidos;

       public Usuario() {
       }

       public Usuario(String email, String contraseña, String token) {
              this.email = email;
              this.contraseña = contraseña;
              this.token = token;
       }

       public Usuario(String nombre, String email, String contraseña, String token) {
              this.nombre = nombre;
              this.email = email;
              this.contraseña = contraseña;
              this.token = token;
       }

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

       public String getEmail() {
              return email;
       }

       public void setEmail(String email) {
              this.email = email;
       }

       public String getContraseña() {
              return contraseña;
       }

       public void setContraseña(String contraseña) {
              this.contraseña = contraseña;
       }

       public String getToken() {
              return token;
       }

       public void setToken(String token) {
              this.token = token;
       }

       public List<Contenido> getContenidos() {
              return contenidos;
       }

       public void setContenidos(List<Contenido> contenidos) {
              this.contenidos = contenidos;
       }
}