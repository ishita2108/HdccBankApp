package com.citybank.entity;

import java.util.stream.Collectors;

import com.citybank.dto.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityBankResponse {
	private Customer customer;
	private Account account;
	
	
}
