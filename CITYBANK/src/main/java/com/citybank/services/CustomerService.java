package com.citybank.services;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.citybank.entity.Account;
import com.citybank.entity.Customer;
import com.citybank.exceptions.AccountIsAlreadyAssignedException;
import com.citybank.exceptions.CustomerNotFoundException;
import com.citybank.repository.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo customerRepo;
	private AccountService accountService;
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@Autowired
	public CustomerService(CustomerRepo customerRepo, AccountService accountService,FileService fileService) {
		this.customerRepo = customerRepo;
		this.accountService = accountService;
		this.fileService = fileService;
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
	@Transactional
	public Customer uploadCustomerImage(int cid, MultipartFile image) throws IOException{
		Customer customer = getCustomer(cid);
		String fileName = fileService.uploadImage(path, image);
		customer.setFileName(fileName);
		return customer;	
		}
}
