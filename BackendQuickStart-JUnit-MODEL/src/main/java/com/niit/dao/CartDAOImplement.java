package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository("CartDAO") 
public class CartDAOImplement implements CartDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addingCart(Cart cart) 
	{
		try
		{
		    sessionFactory.getCurrentSession().save(cart);   // <~~ The SECOND LAST STEP - Very Very Important:- This is where the CartDAO opens up the entire tunnel for a UI (via. the Spring Container Bean OR SessionFactory object, both are same) to interact and change the database!!
		    return true;
		}
		catch(Exception e)
		{
		    System.out.println("Exception arose while ' adding ' Cart!!" +e);
			return false;
		}
	}
	
	//gettingCart()
	@Override
public Cart gettingCart(int cartId)
{
		//Session session = sessionFactory.openSession();

		Cart Cart = (Cart)sessionFactory.openSession().get(Cart.class, cartId);  // use also load() method in place of get() method here!!
		
		return Cart;
}

	
	// For deletingCart()
	@Transactional
	@Override
	public boolean deletingCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' deleting ' Cart!!" +e);		
		    return false;
		}
	}

	//For updatingCart
	@Transactional
	@Override
	public boolean updatingCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arose while ' updating ' Cart!!" +e);		
		    return false;
		}
	}

	// For List<>gettingCarts()
	@Override
	public List<Cart> gettingCart(String username) 
	{
		
	     try {
			Session session = sessionFactory.openSession();
			String status="NP";
			Query query = session.createQuery("from Cart where username=:username and paymentstatus=:status");
			query.setParameter("username", username);
			query.setParameter("status", status);
			
			List<Cart> listCarts = (List<Cart>)query.list();
			return listCarts;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in getting Cart details for user.."+e);
			return null;
			
		}
	}
}