package com.cinema.repository;

import com.cinema.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {
}
