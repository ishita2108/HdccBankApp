package com.hdcc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdcc.entity.Account;
import com.hdcc.entity.Customer;
import com.hdcc.exceptions.CustomerNotFoundException;
import com.hdcc.repository.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo customerRepo;
	private AccountService accountService;
	
	@Autowired
	public CustomerService(CustomerRepo customerRepo, AccountService accountService) {
		this.customerRepo = customerRepo;
		this.accountService = accountService;
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);	
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer getCustomer(int id) {
		return customerRepo.findById(id). orElseThrow(()-> new CustomerNotFoundException("Customer with id "+ id + " is not found!!"));
	}
	
	public Customer addAccountToCustomer(int cid, int accid) {
		Customer customer = getCustomer(cid);
		Account account = accountService.getAccount(accid);
		customer.addAccount(account);
		return customer;
		
	}
}