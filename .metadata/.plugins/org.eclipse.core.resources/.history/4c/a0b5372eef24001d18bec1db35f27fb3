package com.hdcc.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.hdcc.entity.Account;

import lombok.Data;

@Data
public class AccountDto {
	private int id;
	private String accountNo= UUID.randomUUID().toString();
	private BigDecimal balance;
	
	
	public static AccountDto from(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setAccountNo(account.getAccountNo());
		accountDto.setBalance(account.getBalance());
		return accountDto;
		
	}
	
}
