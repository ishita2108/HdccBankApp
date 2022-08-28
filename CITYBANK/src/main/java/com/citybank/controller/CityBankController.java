package com.citybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.citybank.entity.CityBankRequest;
import com.citybank.entity.CustomerHdcc;
import com.citybank.entity.CustomerInfinity;
import com.citybank.exceptions.CustomerNotFoundException;

@RestController
public class CityBankController {
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(path = "hdcckyc")

	public ResponseEntity checkKycHdcc(@RequestBody CityBankRequest cityBankRequest) {
		CustomerHdcc customerHdcc = restTemplate.getForObject(
				"http://localhost:8090/hdccapp/customers/Pan/" + cityBankRequest.getPanNo(), CustomerHdcc.class);
		if (customerHdcc.getKycNo() != null) {
			String message = "KYC Found";
			return new ResponseEntity<>(message, HttpStatus.FOUND);
		} else {
			throw new CustomerNotFoundException("Not Found");
		}

	}

	@PostMapping(path = "infinitykyc")

	public ResponseEntity checkKycInfinity(@RequestBody CityBankRequest cityBankRequest) {
		CustomerInfinity customerInfinity = restTemplate.getForObject(
				"http://localhost:8082/infinityapp/customers/Pan/" + cityBankRequest.getPanNo(),
				CustomerInfinity.class);
		if (customerInfinity.getKycNo() != null) {
			String message = "KYC Found";
			return new ResponseEntity<>(message, HttpStatus.FOUND);

		} else {
			throw new CustomerNotFoundException("Not Found");

		}
	}

}
