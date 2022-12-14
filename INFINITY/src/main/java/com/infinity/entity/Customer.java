package com.infinity.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infinity.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@Column(unique = true)
	private String email;
	private String occupation;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dob;
	@Column(unique = true)
	private String panNo;
	@Column(unique = true)
	private String aadharNo;
	@Column(unique = true)
	private String passportNo;
	@Column(unique = true)
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
		//customer.setAccounts(customerDto.getAccountsDto());
		return customer;
	}



}
