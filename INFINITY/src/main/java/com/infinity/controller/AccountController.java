package com.infinity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.dto.AccountDto;
import com.infinity.entity.Account;
import com.infinity.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		Account account = accountService.addAccount(Account.from(accountDto));
		return new ResponseEntity<>(AccountDto.from(account), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<Account> accounts = accountService.getAllAccounts();
		List<AccountDto> accountsDto = accounts.stream().map(AccountDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(accountsDto, HttpStatus.OK);	
	}
	
	
	@GetMapping(value ="{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable  Integer id){
		Account account = accountService.getAccount(id);
		return new ResponseEntity<>(AccountDto.from(account), HttpStatus.OK);
		
	}
	
	
}
