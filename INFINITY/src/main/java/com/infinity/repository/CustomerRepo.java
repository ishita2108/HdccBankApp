package com.infinity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer findByPanNo(String panNo);
}
