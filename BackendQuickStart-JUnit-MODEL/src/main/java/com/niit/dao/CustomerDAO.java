package com.niit.dao;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerDAO 
{
				public boolean addingCustomer(Customer customer);
				public boolean updatingCustomer(Customer customer);
				public Customer gettingCustomer(int customerId);
				public List<Customer> gettingCustomers();
				public boolean deletingCustomer(Customer customer);	
}