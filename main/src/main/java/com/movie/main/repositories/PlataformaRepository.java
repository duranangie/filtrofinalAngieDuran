package com.movie.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.main.models.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {

}