package com.greatlearning.crmCrud.customerRelationshipManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer;


public interface ICustomerDao {

@Autowired
	public Customer insertCustomerDetails(Customer Customer);

	public boolean deleteCustomerDetails(int CustomerId);
	public Customer updateCustomerDetails(int id, Customer updatedCustomer);

	public Customer findCustomer(int CustomerId);

	public List<Customer> retrieveCustomerDetails();

}
