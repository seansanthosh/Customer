package com.greatlearning.crmCrud.customerRelationshipManagement.service;

import java.util.List;
import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crmCrud.customerRelationshipManagement.dao.ICustomerDao;
import com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer;
@Component
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private ICustomerDao CustomerDao;

	
	public Customer add(Customer Customer) {
		return CustomerDao.insertCustomerDetails(Customer);
	}
	
	public Customer getCustomer(int CustomerId) {
		return CustomerDao.findCustomer(CustomerId);
	}
	public Customer updateCustomerDetails(int id, Customer customer) {
		return CustomerDao.updateCustomerDetails(id,customer);
	}
	
	public boolean deleteCustomer(int CustomerId) {
		
	
		return CustomerDao.deleteCustomerDetails(CustomerId);
	}

	
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return CustomerDao.retrieveCustomerDetails();
	}
																																												//public void update(Object id) {}

}
