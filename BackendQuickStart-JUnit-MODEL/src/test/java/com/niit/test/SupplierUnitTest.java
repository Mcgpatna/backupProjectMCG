package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest 
{

	static SupplierDAO supplierDAO;
	//static Supplier supplier;
	//_____________________________________________________________________________________________________________
	
	
	@BeforeClass
	public static void firstInstantiateModuleForTest()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'supplierDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				supplierDAO = (SupplierDAO)context.getBean("supplierDAO");	
				
				System.out.println(" We are inside Before Class intantiated object!!"+supplierDAO);
			    //Supplier supplier=(Supplier)context.getBean("supplier");
	}
	
//________________________________________________________________________________________________________________

	
// Test 1: ___________ADDING ' SINGLE ' SUPPLIER_______________
@Ignore
@Test
	public void addingSupplierTest()
	{
				 Supplier supplier = new Supplier();
				  supplier.setSupplierName("Ranjit");
				  supplier.setSupplierAddress("Boring Road Patna");
		          assertTrue("Problem in Supplier Insertion into the H2 Database", supplierDAO.addingSupplier(supplier));
	}
	
	
// Test 2: ____________GETTING OR RETRIEVING ' SINGLE ' SUPPLIER________________
@Ignore
@Test
public void gettingSupplierTest()
{
				assertNotNull("Problem in the Supplier", supplierDAO.gettingSupplier(2));
}
 

// Test 3: _____________DELETING ' SINGLE ' SUPPLIER________________
@Ignore
@Test
public void deletingSupplierTest()
{
			Supplier supplier = supplierDAO.gettingSupplier(2);
			assertTrue("Problem in Deleting:" , supplierDAO.deletingSupplier(supplier));
}


// Test 4: ______________UPDATING ' SINGLE ' SUPPLIER_______________
@Ignore
@Test
public void updateSupplierTest()
{
			Supplier supplier = supplierDAO.gettingSupplier(1);
			supplier.setSupplierName(" Ranjeet Kumar");
			assertTrue("Problem in Updation of Supplier Table", supplierDAO.updatingSupplier(supplier));
}


// Test 5: _______________RETRIEVING THE ' ENTIRE ' SUPPLIER RECORD________________
//@Ignore
@Test
public void listSuppliersTest()
{
			List<Supplier> listSuppliers = supplierDAO.gettingSupplier();
			assertNotNull("No Suppliers Exist!!", listSuppliers);
			
			for(Supplier supplier:listSuppliers)
			{
				   System.out.print(supplier.getSupplierId() + ":::");
				   System.out.print(supplier.getSupplierName() + ":::");
				   System.out.println(supplier.getSupplierAddress());
			}
}

}
