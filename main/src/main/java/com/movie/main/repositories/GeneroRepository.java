package com.movie.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.main.models.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}