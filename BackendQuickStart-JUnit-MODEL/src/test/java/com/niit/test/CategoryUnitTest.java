package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryUnitTest 
{

	static CategoryDAO categoryDAO;
	//static Category category;
	//_____________________________________________________________________________________________________________
	
	
	@BeforeClass
	public static void firstInstantiateModuleForTest()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'categoryDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				//CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");	
				categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
				System.out.println(" We are inside Before Class intantiated object!!"+categoryDAO);
			    //Category category=(Category)context.getBean("category");
	}
	
//________________________________________________________________________________________________________________

	
// Test 1: ___________ADDING ' SINGLE ' CATEGORY_______________
@Ignore
@Test
	public void addingCategoryTest()
	{
				 Category category = new Category();
				  category.setCategoryName("Cricket Bats");
				  category.setCategoryDescript("English Willow");
		          assertTrue("Problem in Category Insertion into the H2 Database", categoryDAO.addingCategory(category));
	}
	
	
// Test 2: ____________GETTING OR RETRIEVING ' SINGLE ' CATEGORY________________
@Ignore
@Test
public void gettingCategoryTest()
{
				assertNotNull("Problem in the Category", categoryDAO.gettingCategory(2));
}
 

// Test 3: _____________DELETING ' SINGLE ' CATEGORY________________
@Ignore
@Test
public void deletingCategoryTest()
{
			Category category = categoryDAO.gettingCategory(3);
			assertTrue("Problem in Deleting:" , categoryDAO.deletingCategory(category));
}


// Test 4: ______________UPDATING ' SINGLE ' CATEGORY_______________
@Ignore
@Test
public void updateCategoryTest()
{
			Category category = categoryDAO.gettingCategory(3);
			category.setCategoryName("Fruits");
			assertTrue("Problem in Updation of Category Table", categoryDAO.updatingCategory(category));
}


// Test 5: _______________RETRIEVING THE ' ENTIRE ' CATEGORY RECORD________________
//@Ignore
@Test
public void listCategoriesTest()
{
			List<Category> listCategories = categoryDAO.gettingCategories();
			assertNotNull("No Categories Exist!!", listCategories);
			
			for(Category category:listCategories)
			{
				   System.out.print(category.getCategoryId() + ":::");
				   System.out.print(category.getCategoryName() + ":::");
				   System.out.println(category.getCategoryDescript());
			}
}

}
