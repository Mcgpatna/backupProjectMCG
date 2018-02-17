package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Customer;

@Repository("CustomerDAO") 
public class CustomerDAOImplement implements CustomerDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addingCustomer(Customer customer) 
	{
		try
		{
		    sessionFactory.getCurrentSession().save(customer);   // <~~ The SECOND LAST STEP - Very Very Important:- This is where the CustomerDAO opens up the entire tunnel for a UI (via. the Spring Container Bean OR SessionFactory object, both are same) to interact and change the database!!
		    return true;
		}
		catch(Exception e)
		{
		    System.out.println("Exception arose while ' adding ' Customer!!" +e);
			return false;
		}
	}
	
	//gettingCustomer()
	@Override
public Customer gettingCustomer(int customerId)
{
		//Session session = sessionFactory.openSession();

		Customer Customer = (Customer)sessionFactory.openSession().get(Customer.class, customerId);  // use also load() method in place of get() method here!!
		
		return Customer;
}

	
	// For deletingCustomer()
	@Transactional
	@Override
	public boolean deletingCustomer(Customer customer) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' deleting ' Customer!!" +e);		
		    return false;
		}
	}

	//For updatingCustomer
	@Transactional
	@Override
	public boolean updatingCustomer(Customer customer) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(customer);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' updating ' Customer!!" +e);		
		    return false;
		}
	}

	// For List<>gettingCustomers()
	@Override
	public List<Customer> gettingCustomers() 
	{
	     Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> listCustomers = (List<Customer>)query.list();
		return listCustomers;
	}
}