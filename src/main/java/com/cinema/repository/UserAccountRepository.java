package com.cinema.repository;

import com.cinema.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    Optional<UserAccount> findByEmail(String email);

    //Write a derived query to read a user with an username?
    Optional<UserAccount> findByUsername(String username);
    //Write a derived query to list all users that contain a specific name?
   // List<UserAccount> findAllByAccountNameContaining(String name);
    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    //List<UserAccount>findAllByUserAccountNameContainingIgnorCase(String name);
    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findAllByAccountDetails_AgeGreaterThan(Integer age);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query(value = "select * from User_Account where email = ?1",nativeQuery = true)
    List<UserAccount> retrieveUserByEmail(String email);
    //Write a JPQL query that returns a user read by username?
    @Query(value = "select * from User_Account where username= ?1",nativeQuery = true)
    List<UserAccount> retrieveUserByUserName(String username);

    //Write a JPQL query that returns all users?
    @Query(value = "select * from User_Account",nativeQuery = true)
    List<UserAccount> fetchAllUsers();
    //
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select * from user_account u join account_details ad" +
            "on u.account_details_id  = ad.id" +
            "where ad.name ilike concat('%',?1,'%')",nativeQuery = true)
    List<UserAccount> retrieveAllByName(String name);
    //Write a native query that returns all users?
@Query(value = "select * from user_account",nativeQuery = true)
    List<UserAccount> retrieveAll();

    //Write a native query that returns all users in the range of ages?
        @Query(value = "select * from user_account u join account_details ad " +
        "where ad.age between ?1 and ?2 ", nativeQuery = true)
    List<UserAccount> retrieveBetweenAgeRange(Integer age1, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "select * from user_account where email = ?1",nativeQuery = true)
    Optional<UserAccount> retrieveByEmail(String email);

}
