package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

public class CartUnitTest 
{

	static CartDAO cartDAO;
	//static Cart cart;
	//_____________________________________________________________________________________________________________
	
	
	@BeforeClass
	public static void firstInstantiateModuleForTest()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'cartDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				cartDAO = (CartDAO)context.getBean("cartDAO");	
				
				System.out.println(" We are inside Before Class intantiated object!!"+cartDAO);
			    //Cart cart=(Cart)context.getBean("cart");
	}
	
//________________________________________________________________________________________________________________

	
// Test 1: ___________ADDING ' SINGLE ' CART_______________
//@Ignore
@Test
	public void addingCartTest()
	{
				 Cart cart = new Cart();
				  cart.setProductId(1);
				  cart.setPrice(1000);
				  cart.setQuantity(2);
				  cart.setUsername("srinivas");
				  cart.setPaymentStatus("NP");
				  cart.setSubtotal(2000);
		          assertTrue("Problem in Cart Insertion into the H2 Database", cartDAO.addingCart(cart));
	}
	
	
// Test 2: ____________GETTING OR RETRIEVING ' SINGLE ' CART________________
@Ignore
@Test
public void gettingCartTest()
{
				assertNotNull("Problem in the Cart", cartDAO.gettingCart(2));
}
 

// Test 3: _____________DELETING ' SINGLE ' CART________________
@Ignore
@Test
public void deletingCartTest()
{
			Cart cart = cartDAO.gettingCart(2);
			assertTrue("Problem in Deleting:" , cartDAO.deletingCart(cart));
}


// Test 4: ______________UPDATING ' SINGLE ' CART_______________
@Ignore
@Test
public void updateCartTest()
{
			Cart cart = cartDAO.gettingCart(1);
			cart.setQuantity(100);
			assertTrue("Problem in Updation of Cart Table", cartDAO.updatingCart(cart));
}


// Test 5: _______________RETRIEVING THE ' ENTIRE ' CART RECORD________________
@Ignore
@Test
public void listCartTest()
{
			List<Cart> listCart = cartDAO.gettingCart("srinivas");
			assertNotNull("No Cart Exist!!", listCart);
			
			for(Cart cart:listCart)
			{
				   System.out.print(cart.getCartId() + ":::");
				   System.out.print(cart.getProductId() + ":::");
				   System.out.println(cart.getProductName());
				   System.out.println(cart.getQuantity());
				   System.out.println(cart.getPaymentStatus());
				   System.out.println(cart.getUsername());
			}
}

}

