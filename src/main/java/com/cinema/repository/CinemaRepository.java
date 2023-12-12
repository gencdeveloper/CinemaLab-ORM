package com.cinema.repository;

import com.cinema.entity.AccountDetails;
import com.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    // ------------------- DERIVED QUERIES ------------------- //



    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema>findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema>findAllByLocation_Country(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name,String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //


    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id= ?1")
    String fetchById(Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join location l" +
            " on c.location_id = l.id where l.country = ?1" ,nativeQuery = true)
    List<Cinema> retrieveAllBasedOnLocationCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "Select*From Cinema where name ilike concat('%',?1,'%') OR " + " sponsored_name ilike concat('%',?1,'%') ",nativeQuery = true)
    List<Cinema> retrieveAllByNameOrSponsoredName(String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * from Cinema order by name" ,nativeQuery = true)
    List<Cinema>sortByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct sponsored_name from cinema", nativeQuery = true)
    List<String> distinctBySponsoredName();
}
