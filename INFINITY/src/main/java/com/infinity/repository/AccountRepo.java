package com.infinity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

}
