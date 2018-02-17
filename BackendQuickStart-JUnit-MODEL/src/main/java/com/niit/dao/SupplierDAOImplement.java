package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@Repository("SupplierDAO") 
public class SupplierDAOImplement implements SupplierDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addingSupplier(Supplier supplier) 
	{
		try
		{
		    sessionFactory.getCurrentSession().save(supplier);   // <~~ The SECOND LAST STEP - Very Very Important:- This is where the SupplierDAO opens up the entire tunnel for a UI (via. the Spring Container Bean OR SessionFactory object, both are same) to interact and change the database!!
		    return true;
		}
		catch(Exception e)
		{
		    System.out.println("Exception arose while ' adding ' Supplier!!" +e);
			return false;
		}
	}
	
	//gettingSupplier()
	@Override
public Supplier gettingSupplier(int supplierId)
{
		//Session session = sessionFactory.openSession();

		Supplier Supplier = (Supplier)sessionFactory.openSession().get(Supplier.class, supplierId);  // use also load() method in place of get() method here!!
		
		return Supplier;
}

	
	// For deletingSupplier()
	@Transactional
	@Override
	public boolean deletingSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' deleting ' Supplier!!" +e);		
		    return false;
		}
	}

	//For updatingSupplier
	@Transactional
	@Override
	public boolean updatingSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' updating ' Supplier!!" +e);		
		    return false;
		}
	}

	// For List<>gettingSuppliers()
	@Override
	public List<Supplier> gettingSupplier() 
	{
	     Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSuppliers = (List<Supplier>)query.list();
		return listSuppliers;
	}
}
