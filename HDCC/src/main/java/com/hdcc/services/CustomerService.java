package com.hdcc.services;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdcc.entity.Account;
import com.hdcc.entity.Customer;
import com.hdcc.exceptions.AccountIsAlreadyAssignedException;
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
	
	@Transactional
	public Customer addAccountToCustomer(int cid, int accid) {
		Customer customer = getCustomer(cid);
		Account account = accountService.getAccount(accid);
		if(Objects.nonNull(account.getCustomer())) {
			throw new AccountIsAlreadyAssignedException(accid, account.getCustomer().getId());
		}
		customer.addAccount(account);
		return customer;
	}
}
