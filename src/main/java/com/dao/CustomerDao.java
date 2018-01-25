package com.dao;

import com.entity.Customer;

public class CustomerDao {

	public Customer save(Customer customer) {
		System.out.println("DAO -> Customer is saved!");
		return customer;
	}

	public void updateEmail(Customer customer, String email) {
		System.out.println("DAO -> Email is updted!");
	}

}
