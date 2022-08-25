package com.hdcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hdcc.repository.AccountRepo;
import com.hdcc.repository.CustomerRepo;

@SpringBootApplication
public class HdccApplication {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;


	public static void main(String[] args) {
		SpringApplication.run(HdccApplication.class, args);
	}

}
