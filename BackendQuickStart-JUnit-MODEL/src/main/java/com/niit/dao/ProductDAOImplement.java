package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@Repository("ProductDAO") 
public class ProductDAOImplement implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addingProduct(Product product) 
	{
		try
		{
		    sessionFactory.getCurrentSession().save(product);   // <~~ The SECOND LAST STEP - Very Very Important:- This is where the ProductDAO opens up the entire tunnel for a UI (via. the Spring Container Bean OR SessionFactory object, both are same) to interact and change the database!!
		    return true;
		}
		catch(Exception e)
		{
		    System.out.println("Exception arose while ' adding ' Product!!" +e);
			return false;
		}
	}
	
	//gettingProduct()
	@Override
public Product gettingProduct(int productId)
{
		//Session session = sessionFactory.openSession();

		Product Product = (Product)sessionFactory.openSession().get(Product.class, productId);  // use also load() method in place of get() method here!!
		
		return Product;
}

	
	// For deletingProduct()
	@Transactional
	@Override
	public boolean deletingProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' deleting ' Product!!" +e);		
		    return false;
		}
	}

	//For updatingProduct
	@Transactional
	@Override
	public boolean updatingProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' updating ' Product!!" +e);		
		    return false;
		}
	}

	// For List<>gettingProducts()
	@Override
	public List<Product> gettingProducts() 
	{
	     Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listProducts = (List<Product>)query.list();
		return listProducts;
	}
}