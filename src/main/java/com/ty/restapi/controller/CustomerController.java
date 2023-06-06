package com.ty.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.response.ResponseStructure;
import com.ty.restapi.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer)
	{
		ResponseStructure<?> responseStructure = customerService.insertCustomer(customer);

	{
		//return new ResponseEntity<>(customer, HttpStatus.OK);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	}
	
	@GetMapping(path="/fetchAll")
	public ResponseEntity<?> findAllCustomers(){
		ResponseStructure<?> responseStructure = customerService.findAllCustomers();
		
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping(path="/fetch/{custId}")
	public ResponseEntity<?> findCustById(@PathVariable int custId){
		ResponseStructure<?> responseStructure = customerService.findCustById(custId);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@DeleteMapping(path="/delete/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int cusId){
		ResponseStructure<?> responseStructure = customerService.deleteCustomer(cusId);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus())
	}

//	/*Any HTTP request of type POST*/
//	@PostMapping(path = "/persist")
//	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer)
//	{
//		return new ResponseEntity<>(customer, HttpStatus.OK);
//	}
//	
//	@GetMapping(path = "/fetch")
//	public ResponseEntity<?> getCustomer(@RequestParam int custId)
//	{
//		if(custId>=1)
//		{
//			return new ResponseEntity<>("Valid customer id", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Invalid customer id", HttpStatus.NOT_FOUND);
//	}
//	
//	@DeleteMapping(path = "delete/{custId}")
//	public ResponseEntity<?> deleteCustomer(@PathVariable int custId)
//	{
//		return new ResponseEntity<>("Customer data deleted ", HttpStatus.OK);
//	}
							
}
