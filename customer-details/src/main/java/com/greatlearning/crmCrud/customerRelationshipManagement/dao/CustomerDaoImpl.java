package com.greatlearning.crmCrud.customerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crmCrud.customerRelationshipManagement.*;
import com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer;

@Repository

public class CustomerDaoImpl implements ICustomerDao {
@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	public CustomerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	
	public Customer insertCustomerDetails(Customer Customer) {

		// Transaction txn = session.beginTransaction();
		session.save(Customer);
		System.out.println("Customer info saved." + Customer);
		// txn.commit();
		return Customer;
	}

	

	
	public boolean deleteCustomerDetails(int CustomerId) {
		
		Customer retrievedObject=findCustomer(CustomerId);
		
		session.getTransaction().begin();
		System.out.println("deleting Customer country is: "+retrievedObject.getEmail());
		session.delete(retrievedObject);
		
		session.getTransaction().commit();
		
		if(retrievedObject!=null) {
			return true;
		}
		return false;
		
	}
	public Customer updateCustomerDetails(int id, Customer updatedCustomer) {
		session = sessionFactory.openSession();	
        session.saveOrUpdate(updatedCustomer);
            return updatedCustomer;
	}
	
	public Customer findCustomer(int CustomerId) {
		
		return session.find(Customer.class, new Integer(CustomerId));
	}

	
	public List<Customer> retrieveCustomerDetails() {
		return session.createQuery("Select s from Customer s", Customer.class).getResultList();
	}

}
