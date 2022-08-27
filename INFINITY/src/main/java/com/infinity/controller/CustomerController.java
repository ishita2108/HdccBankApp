package com.infinity.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infinity.dto.CustomerDto;
import com.infinity.entity.Customer;
import com.infinity.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {


	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto){
		Customer customer = customerService.addCustomer(Customer.from(customerDto));
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllAccounts(){
		List<Customer> customers = customerService.getAllCustomers();
		List<CustomerDto> customersDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(customersDto, HttpStatus.OK);	
	}
	
	
	@GetMapping(value ="{id}")
	public ResponseEntity<CustomerDto> getAccount(@PathVariable Integer id){
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);	
	}
	
	@PostMapping(value = "{cid}/accounts/{accid}/add")
	public ResponseEntity<CustomerDto> addAccountToCustomer(@PathVariable  Integer cid, @PathVariable  Integer accid){
		Customer customer = customerService.addAccountToCustomer(cid, accid);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
	}
	
	@PostMapping(value = "image/upload/{cid}")
	public ResponseEntity<CustomerDto> uploadCustomerImage(@RequestParam("image")MultipartFile image,
			@PathVariable Integer cid) throws IOException{
		Customer customer = customerService.uploadCustomerImage(cid, image);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
		}
}
