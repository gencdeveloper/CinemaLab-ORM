package com.cinema.repository;

import com.cinema.entity.AccountDetails;
import com.cinema.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountDetails,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    /**Write a derived query to list all accounts with a specific country or state*/
    List<AccountDetails>findAllByCountryOrState(String country, String state);

    /**Write a derived query to list all accounts with age lower than or equal to a specific value*/
    List<AccountDetails> findByAgeLessThanEqual(Integer age);

    /**Write a derived query to list all accounts with a specific role*/
    List<AccountDetails>findAllByRole(UserRole role);

    /**Write a derived query to list all accounts between a range of ages*/
    List<AccountDetails>findAllByAgeBetween(Integer ageStart, Integer ageEnd);

    /**Write a derived query to list all accounts where the beginning of the address contains the keyword*/
    List<AccountDetails>findAllByAddressStartingWith(String keyword);

    /**Write a derived query to sort the list of accounts with age*/
    List<AccountDetails> findAllByOrderByAgeDesc();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM AccountDetails a")
    List<AccountDetails> fetchAllAccount();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM AccountDetails a WHERE a.role = 'ADMIN'")
    List<AccountDetails> fetchAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query(value = "SELECT A FROM AccountDetails a ORDER BY a.age",nativeQuery = true)
    List<AccountDetails> fetchAllOrdeyByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < :inputAge",nativeQuery = true)
    List<AccountDetails> retrieveAllBasedOnAge(@Param("inputAge") Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where lower(name) LIKE lower(concat('%',?1,'%')) or" +
            " address LIKE concat('%',?1,'%')"
            +
            " country LIKE concat('%',?1,'%')"
            +
            " state LIKE concat('%',?1,'%')"
            +
            " address LIKE concat('%',?1,'%')",nativeQuery = true)
    List<AccountDetails> retrieveBySearchCriteria(String pattern);

}
