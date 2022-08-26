package com.hdcc.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.hdcc.dto.CustomerDto;
import com.hdcc.entity.Customer;
import com.hdcc.services.CustomerService;
import com.hdcc.services.FileService;

@RestController
@RequestMapping("/customers")
public class CustomerController {


	private CustomerService customerService;
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@Autowired
	public CustomerController(CustomerService customerService, FileService fileService) {
		this.customerService = customerService;
		this.fileService = fileService;
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody final CustomerDto customerDto){
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
	public ResponseEntity<CustomerDto> getAccount(@PathVariable final Integer id){
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);	
	}
	
	@PostMapping(value = "{cid}/accounts/{accid}/add")
	public ResponseEntity<CustomerDto> addAccountToCustomer(@PathVariable final Integer cid, @PathVariable final Integer accid){
		Customer customer = customerService.addAccountToCustomer(cid, accid);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
	}
	
	@PostMapping(value = "image/upload/{cid}")
	public ResponseEntity<CustomerDto> uploadCustomerImage(@RequestParam("image")MultipartFile image,
			@PathVariable Integer cid) throws IOException{
		Customer customer = customerService.getCustomer(cid);
		String fileName = fileService.uploadImage(path, image);
		customer.setFileName(fileName);
		return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
		}
}
