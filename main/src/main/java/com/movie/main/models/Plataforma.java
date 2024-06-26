package com.movie.main.models;

import java.util.Set;

import jakarta.persistence.*;



    @Entity
    @Table(name = "plataformas")
    public class Plataforma {  
        @Id    
        @GeneratedValue(strategy = GenerationType.IDENTITY)    
        private Integer id;
        @Column(name = "nombre", nullable = false, unique = true)    
        private String nombre;
        @ManyToMany(mappedBy = "plataformas")    
        private Set<TipoContenido> tipocontenidos;
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
        public Set<TipoContenido> getTipocontenidos() {
            return tipocontenidos;
        }
        public void setTipocontenidos(Set<TipoContenido> tipocontenidos) {
            this.tipocontenidos = tipocontenidos;
        }
    }

