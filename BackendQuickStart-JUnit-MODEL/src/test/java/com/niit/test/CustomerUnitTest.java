package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CustomerDAO;
import com.niit.model.Customer;

public class CustomerUnitTest 
{

	static CustomerDAO customerDAO;
	//static Customer customer;
	//_____________________________________________________________________________________________________________
	
	
	@BeforeClass
	public static void firstInstantiateModuleForTest()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'customerDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				customerDAO = (CustomerDAO)context.getBean("customerDAO");	
				
				System.out.println(" We are inside Before Class intantiated object!!"+customerDAO);
			    //Customer customer=(Customer)context.getBean("customer");
	}
	
//________________________________________________________________________________________________________________

	
// Test 1: ___________ADDING ' SINGLE ' COSTUMER_______________
@Ignore
@Test
	public void addingCustomerTest()
	{
				 Customer customer = new Customer();
				  customer.setCustomerFName("Srinivas");
				  customer.setCustomerAddress("Hydrabad");
				  customer.setCustomerEmail("srinivas@gmail.com");
		          assertTrue("Problem in Customer Insertion into the H2 Database", customerDAO.addingCustomer(customer));
	}
	
	
// Test 2: ____________GETTING OR RETRIEVING ' SINGLE ' COSTUMER________________
@Ignore
@Test
public void gettingCustomerTest()
{
				assertNotNull("Problem in the Customer", customerDAO.gettingCustomer(2));
}
 

// Test 3: _____________DELETING ' SINGLE ' COSTUMER________________
@Ignore
@Test
public void deletingCustomerTest()
{
			Customer customer = customerDAO.gettingCustomer(2);
			assertTrue("Problem in Deleting:" , customerDAO.deletingCustomer(customer));
}


// Test 4: ______________UPDATING ' SINGLE ' COSTUMER_______________
@Ignore
@Test
public void updateCustomerTest()
{
			Customer customer = customerDAO.gettingCustomer(2);
			customer.setCustomerLName("Patnaik");
			customer.setCustomerEmail("patnaik@gmail.com");
			assertTrue("Problem in Updation of Customer Table", customerDAO.updatingCustomer(customer));
}


// Test 5: _______________RETRIEVING THE ' ENTIRE ' COSTUMER RECORD________________
//@Ignore
@Test
public void listCustomersTest()
{
			List<Customer> listCustomers = customerDAO.gettingCustomers();
			assertNotNull("No Customers Exist!!", listCustomers);
			
			for(Customer customer:listCustomers)
			{
				   System.out.print(customer.getCustomerId() + ":::");
				   System.out.print(customer.getCustomerFName() + ":::");
				   System.out.print(customer.getCustomerLName() + ":::");
				   System.out.println(customer.getCustomerAddress());
			}
}

}
