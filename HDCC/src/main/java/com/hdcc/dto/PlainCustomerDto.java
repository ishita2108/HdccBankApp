//package com.hdcc.dto;
//
//import java.util.Date;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.hdcc.entity.Customer;
//
//import lombok.Data;
//
//@Data
//public class PlainCustomerDto {
//	private int id;
//	private String name;
//	private String permanentAddress;
//	private String currentAddress;
//	private String contactDetails;
//	private String email;
//	private String occupation;
//	@JsonFormat(pattern = "yyyy/MM/dd")
//	private Date dob;
//	private String panNo;
//	private String aadharNo;
//	private String passportNo;
//	private String kycNo;
//	
//	public static PlainCustomerDto from(Customer customer) {
//		PlainCustomerDto plainCustomerDto = new PlainCustomerDto();
//		plainCustomerDto.setId(customer.getId());
//		plainCustomerDto.setName(customer.getName());
//		plainCustomerDto.setPermanentAddress(customer.getPermanentAddress());
//		plainCustomerDto.setCurrentAddress(customer.getCurrentAddress());
//		plainCustomerDto.setContactDetails(customer.getContactDetails());
//		plainCustomerDto.setEmail(customer.getEmail());
//		plainCustomerDto.setOccupation(customer.getOccupation());
//		plainCustomerDto.setDob(customer.getDob());
//		plainCustomerDto.setPanNo(customer.getPanNo());
//		plainCustomerDto.setAadharNo(customer.getAadharNo());
//		plainCustomerDto.setPassportNo(customer.getPassportNo());
//		plainCustomerDto.setKycNo(customer.getKycNo());
//		return plainCustomerDto;
//	}
//}
