package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductUnitTest 
{

	static ProductDAO productDAO;
	//static Product product;
	//_____________________________________________________________________________________________________________
	
	
	@BeforeClass
	public static void firstInstantiateModuleForTest()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'productDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				productDAO = (ProductDAO)context.getBean("productDAO");	
				
				System.out.println(" We are inside Before Class intantiated object!!"+productDAO);
			    //Product product=(Product)context.getBean("product");
	}
	
//________________________________________________________________________________________________________________

	
// Test 1: ___________ADDING ' SINGLE ' PRODUCT_______________
@Ignore
@Test
	public void addingProductTest()
	{
				 Product product = new Product();
				  product.setProductName("Cricket Bats");
				  product.setProductDesc("English Willow");
				  product.setProductPrice(1000);
				  product.setQuantity(100);
				  product.setSupplierId(1);
				  product.setCategoryId(1);
		          assertTrue("Problem in Product Insertion into the H2 Database", productDAO.addingProduct(product));
	}
	
	
// Test 2: ____________GETTING OR RETRIEVING ' SINGLE ' PRODUCT________________
@Ignore
@Test
public void gettingProductTest()
{
				assertNotNull("Problem in the Product", productDAO.gettingProduct(2));
}
 

// Test 3: _____________DELETING ' SINGLE ' PRODUCT________________
@Ignore
@Test
public void deletingProductTest()
{
			Product product = productDAO.gettingProduct(2);
			assertTrue("Problem in Deleting:" , productDAO.deletingProduct(product));
}


// Test 4: ______________UPDATING ' SINGLE ' PRODUCT_______________
@Ignore
@Test
public void updateProductTest()
{
			Product product = productDAO.gettingProduct(1);
			product.setProductName("Cricket Bats for Children");
			assertTrue("Problem in Updation of Product Table", productDAO.updatingProduct(product));
}


// Test 5: _______________RETRIEVING THE ' ENTIRE ' PRODUCT RECORD________________
//@Ignore
@Test
public void listProductsTest()
{
			List<Product> listProducts = productDAO.gettingProducts();
			assertNotNull("No Products Exist!!", listProducts);
			
			for(Product product:listProducts)
			{
				   System.out.print(product.getProductId() + ":::");
				   System.out.print(product.getProductName() + ":::");
				   System.out.println(product.getProductDesc());
				   System.out.println(product.getCategoryId());
				   System.out.println(product.getQuantity());
				   System.out.println(product.getProductPrice());
			}
}

}
