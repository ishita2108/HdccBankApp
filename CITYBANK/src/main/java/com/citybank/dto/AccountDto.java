package com.citybank.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.citybank.entity.Account;
import com.citybank.entity.AccountHdcc;

import lombok.Data;

@Data
public class AccountDto {
	
	private int id;
	private String accountNo= UUID.randomUUID().toString();
	private BigDecimal balance;
	//private PlainCustomerDto plainCustomerDto;
	
	
	public static AccountDto from(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setAccountNo(account.getAccountNo());
		accountDto.setBalance(account.getBalance());
//		if(Objects.nonNull(account.getCustomer())) {
//			accountDto.setPlainCustomerDto(PlainCustomerDto.from(account.getCustomer()));
//		}
		return accountDto;
		
	}
	
	public static AccountDto fromHdcc(AccountHdcc accountHdcc) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(accountHdcc.getId());
		accountDto.setAccountNo(accountHdcc.getAccountNo());
		accountDto.setBalance(accountHdcc.getBalance());
//		if(Objects.nonNull(account.getCustomer())) {
//			accountDto.setPlainCustomerDto(PlainCustomerDto.from(account.getCustomer()));
//		}
		return accountDto;
		
	}
}
