package com.citybank.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.citybank.entity.AccountHdcc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class AccountHdccDto {
	private int id;
	private String accountNo= UUID.randomUUID().toString();
	private BigDecimal balance;
	//private PlainCustomerDto plainCustomerDto;
	
	
	public static AccountHdccDto from(AccountHdcc account) {
		AccountHdccDto accountHdccDto = new AccountHdccDto();
		accountHdccDto.setId(account.getId());
		accountHdccDto.setAccountNo(account.getAccountNo());
		accountHdccDto.setBalance(account.getBalance());
//		if(Objects.nonNull(account.getCustomer())) {
//			accountDto.setPlainCustomerDto(PlainCustomerDto.from(account.getCustomer()));
//		}
		return accountHdccDto;
		
	}


}
