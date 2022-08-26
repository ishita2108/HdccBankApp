package com.hdcc.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hdcc.entity.Customer;

import lombok.Data;

@Data
public class CustomerDto {
	private int id;
	private String name;
	private String permanentAddress;
	private String currentAddress;
	private String contactDetails;
	private String email;
	private String occupation;
	private Date DOB;
	private String panNo;
	private String aadharNo;
	private String passportNo;
	private String kycNo;
	private List<AccountDto> accountsDto = new ArrayList<>();
	
	public static CustomerDto from(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setPermanentAddress(customer.getPermanentAddress());
		customerDto.setCurrentAddress(customer.getCurrentAddress());
		customerDto.setContactDetails(customer.getContactDetails());
		customerDto.setEmail(customer.getEmail());
		customerDto.setOccupation(customer.getOccupation());
		customerDto.setDOB(customer.getDOB());
		customerDto.setPanNo(customer.getPanNo());
		customerDto.setAadharNo(customer.getAadharNo());
		customerDto.setPassportNo(customer.getPassportNo());
		customerDto.setKycNo(customer.getKycNo());
		customerDto.setAccountsDto(customer.getAccounts().stream().map(AccountDto::from).collect(Collectors.toList()));
		return customerDto;
		
	}
}
