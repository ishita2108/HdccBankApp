package com.citybank.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.citybank.dto.AccountDto;
import com.citybank.dto.CustomerDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.stream.Collectors;
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Data	
@Table(name="Customers")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String permanentAddress;
	private String currentAddress;
	private String contactDetails;
	
	private String email;
	private String occupation;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dob;
	
	private String panNo;

	private String aadharNo;

	private String passportNo;

	private String kycNo;
	private String fileName;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Account> accounts = new ArrayList<Account>();

	public void addAccount(Account account) {
		accounts.add(account);
	}
	public static Customer from(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setPermanentAddress(customerDto.getPermanentAddress());
		customer.setCurrentAddress(customerDto.getCurrentAddress());
		customer.setContactDetails(customerDto.getContactDetails());
		customer.setEmail(customerDto.getEmail());
		customer.setOccupation(customerDto.getOccupation());
		customer.setDob(customerDto.getDob());
		customer.setPanNo(customerDto.getPanNo());
		customer.setAadharNo(customerDto.getAadharNo());
		customer.setPassportNo(customerDto.getPassportNo());
		customer.setKycNo(customerDto.getKycNo());
		customer.setFileName(customerDto.getFileName());
		//customer.setAccounts(customerDto.getAccountsDto().stream().map(Account::from).collect(Collectors.toList()));
		return customer;
	}
//	public static Customer fromC(CityBankResponse cityBankResponse) {
//		Customer customer = new Customer();
//		customer.setName(cityBankResponse.getCustomer().getName());
//		customer.setPermanentAddress(cityBankResponse.getCustomer().getPermanentAddress());
//		customer.setCurrentAddress(cityBankResponse.getCustomer().getCurrentAddress());
//		customer.setContactDetails(cityBankResponse.getCustomer().getContactDetails());
//		customer.setEmail(cityBankResponse.getCustomer().getEmail());
//		customer.setOccupation(cityBankResponse.getCustomer().getOccupation());
//		customer.setDob(cityBankResponse.getCustomer().getDob());
//		customer.setPanNo(cityBankResponse.getCustomer().getPanNo());
//		customer.setAadharNo(cityBankResponse.getCustomer().getAadharNo());
//		customer.setPassportNo(cityBankResponse.getCustomer().getPassportNo());
//		customer.setKycNo(cityBankResponse.getCustomer().getKycNo());
//		customer.setFileName(cityBankResponse.getCustomer().getFileName());
//		customer.setAccounts(cityBankResponse.getCustomer().getAccounts().stream().map(AccountDto::from).collect(Collectors.toList()));
//		return customer;
//	}
}