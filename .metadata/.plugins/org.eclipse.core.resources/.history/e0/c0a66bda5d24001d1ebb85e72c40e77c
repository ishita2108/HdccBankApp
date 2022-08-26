package com.hdcc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
	private Date DOB;
	private String panNo;
	private String aadharNo;
	private String passportNo;
	private String kycNo;
	private String photo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Account> accounts = new ArrayList<Account>();

	public void addAccount(Account account) {
		accounts.add(account);
	}

}
