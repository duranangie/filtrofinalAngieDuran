package com.movie.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.main.models.TipoContenido;

@Repository
public interface TipoContenidoRepository extends JpaRepository<TipoContenido, Integer> {

}