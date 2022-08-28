package com.citybank.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data	
public class CustomerInfinity {
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

	private List<AccountInfinity> accounts = new ArrayList<AccountInfinity>();

	public void addAccount(AccountInfinity account) {
		accounts.add(account);
	}
	

}
