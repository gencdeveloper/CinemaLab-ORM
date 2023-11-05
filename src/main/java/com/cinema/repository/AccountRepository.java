package com.cinema.repository;

import com.cinema.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDetails,Long> {
}
