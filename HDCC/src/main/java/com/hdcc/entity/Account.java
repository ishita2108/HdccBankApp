package com.hdcc.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hdcc.dto.AccountDto;

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
@Entity
@Data
@Table(name="Accounts")
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String accountNo= UUID.randomUUID().toString();
	private BigDecimal balance;
	
	@ManyToOne
	private Customer customer;
	
	public static Account from(AccountDto accountDto) {
		Account account = new Account();
		account.setBalance(accountDto.getBalance());
		return account;
	}
}
