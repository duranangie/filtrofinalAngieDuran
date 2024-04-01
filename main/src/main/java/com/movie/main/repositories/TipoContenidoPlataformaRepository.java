package com.movie.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.main.models.TipoContenidoPlataforma;

@Repository
public interface TipoContenidoPlataformaRepository extends JpaRepository<TipoContenidoPlataforma, Integer> {

}