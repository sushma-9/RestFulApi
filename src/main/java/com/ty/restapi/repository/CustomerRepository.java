package com.ty.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.restapi.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}
