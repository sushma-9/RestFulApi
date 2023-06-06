package com.ty.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.exception.CustomerIdNotFoundException;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	//SimpleJpaRepository object
	//-->CRUD operations method implementation
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);//persistence logic
	}
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	public Optional<Customer> findCustById(int custId) {
		// TODO Auto-generated method stub
		Optional<Customer> findById  = customerRepository.findById(custId);
		return findById;
	}
	public Customer deleteCustomer(int custId) {
		Optional<Customer> findById = customerRepository.findById(custId);
		//false
		if(findById.isPresent())
		{
			customerRepository.deleteById(custId);
			return findById.get();
		}
		//generation
		throw new CustomerIdNotFoundException("Customer ID not available");
	}

}
