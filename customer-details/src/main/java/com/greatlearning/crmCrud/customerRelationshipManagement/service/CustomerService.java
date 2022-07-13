package com.greatlearning.crmCrud.customerRelationshipManagement.service;

import java.util.List;

import com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer;


public interface CustomerService {

	public Customer add(Customer customer);
	public Customer getCustomer(int customerId);
	public Customer updateCustomerDetails(int id, Customer customer);
	public boolean deleteCustomer(int customerId);

	public List<Customer> getAllCustomers();
	//public void update(Object id);

}
