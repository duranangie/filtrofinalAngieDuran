package com.movie.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.main.models.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

}