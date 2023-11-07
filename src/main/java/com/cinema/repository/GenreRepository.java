package com.cinema.repository;

import com.cinema.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
}
