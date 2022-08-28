package com.citybank.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
public class AccountInfinity {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String accountNo= UUID.randomUUID().toString();
	private BigDecimal balance;
	
	private CustomerInfinity customer;
	
	
}
