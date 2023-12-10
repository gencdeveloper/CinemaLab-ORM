package com.cinema.repository;

import com.cinema.entity.AccountDetails;
import com.cinema.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {


    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema>findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);
    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);
    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema>findAllByDateTimeAfter(LocalDate dateTime);
    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema>findFirst3ByOrderByMoviePriceDesc();
    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema>findAllByMovie_NameContaining(String MovieName);
    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema>findAllByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT a FROM MovieCinema a where a.dateTime > ?1")
    List<MovieCinema> fetchAllWithHigherThanSpecificDate(LocalDate dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select COUNT(*) from movie_cinema where cinema_id = ?1",nativeQuery = true)
    Integer countByCinemaID(int id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema mc join cinema c" +
            "on mc.cinema_id = c.id join location l on c.location_id = l.id " +
            "where l.name=?1",nativeQuery = true)
    List<MovieCinema> retrieveAllByLocationName(String name);
}
