package com.infinity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.entity.Account;
import com.infinity.exceptions.CustomerNotFoundException;
import com.infinity.repository.AccountRepo;

@Service
public class AccountService {
	
	private AccountRepo accountRepo;
	
	@Autowired
	public AccountService(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}
	
	public Account addAccount(Account account) {
		return accountRepo.save(account);	
	}
	
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	public Account getAccount(int id) {
		return accountRepo.findById(id). orElseThrow(()-> new CustomerNotFoundException("Account with id "+ id + " is not found!!"));
	}
	

}
