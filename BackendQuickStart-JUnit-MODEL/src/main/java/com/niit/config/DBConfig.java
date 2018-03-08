package com.niit.config;




import org.springframework.context.annotation.Bean;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDAO;
import com.niit.dao.CartDAOImplement;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImplement;
import com.niit.dao.CustomerDAO;
import com.niit.dao.CustomerDAOImplement;
import com.niit.dao.OrderDetailDAO;
import com.niit.dao.OrderDetailDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImplement;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImplement;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.OrderDetail;
import com.niit.model.Product;
import com.niit.model.Supplier;

import org.springframework.orm.hibernate4.HibernateTransactionManager;


//============================================================================================================
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{
			@Bean(name="data1")
			public DataSource getH2DataSource()
    		{
				System.out.println("inside getH2DataSource()....");
    			DriverManagerDataSource dataSource = new  DriverManagerDataSource();
    			
    			dataSource.setDriverClassName("org.h2.Driver");
    			dataSource.setUrl("jdbc:h2:tcp://localhost/~/online");
    			dataSource.setUsername("user1");
    			dataSource.setPassword("user1");
    			
    			System.out.println("-------->  Data Source is now operational  <---------");
    			return dataSource;
    		}
    		
    		@Bean(name="sessionFactory")
    		public SessionFactory getSessionFactory()
    		{
    				Properties hibernateProp = new Properties();
    				
    				hibernateProp.setProperty("hibernate.hbm2ddl.auto","update");
    				hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
    				
    				LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getH2DataSource()); // This is data coming/pulled from H2 Database.(Talking about the parameter here!)
    				
    				factoryBuilder.addAnnotatedClass(Category.class); // This is data coming/generated from the UI as class objects.
    				factoryBuilder.addAnnotatedClass(Product.class);
    				factoryBuilder.addAnnotatedClass(Customer.class);
    				factoryBuilder.addAnnotatedClass(Cart.class);
    				factoryBuilder.addAnnotatedClass(Supplier.class);
    				factoryBuilder.addAnnotatedClass(OrderDetail.class);
    				
    				
    				factoryBuilder.addProperties(hibernateProp);  // This is the ORM mapping bridge tool for Category class object to H2 DataSource object
    				
    				// The LocalSessionFactoryBuilder object which, is responsible for creating a bean object of the entire 
    				// active session between the application's external user interface and the H2 Database in the back-end, is taking
    				// into its body, the H2 DataSource and the Hibernate orm properties of hbm auto update and the orm H2 dialect
    				// that will translate each java based Model Entity bean data objects in the dialect of H2 Database Datasets via orm of Hibernate
    				// during an ongoing session in real-time!!
    				
    				System.out.println(" * * * * * Session Factory Bean or better to call 'the Spring Container' has just been initalized * * * * * ");
    				return factoryBuilder.buildSessionFactory();
    		}
    		
//========================================================================================================================
   // CREATIONS OF SPRING BEANS OF ALL THE MODEL COMPONENT'S DAO MODULE: -
    		
    		// 1. Bean of CATEGORY DAO:
    		@Bean(name="categoryDAO")
    		public CategoryDAO getCategoryDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Category Model as CatogoryDAO has been enabled now!! +++++");
    			    return new CategoryDAOImplement();
    		}
    		//__________________________________________________________________________________________________________________________
    		
    		// Bean of PRODUCT DAO:
    		@Bean(name="productDAO")
    		public ProductDAO getProductDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Product Model as ProductDAO has been enabled now!! +++++");
    			    return new ProductDAOImplement();
    		}
    		//___________________________________________________________________________________________________________________________
    		
    		// Bean of CUSTOMER DAO:
    		@Bean(name="customerDAO")
    		public CustomerDAO getCustomerDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Customer Model as CustomerDAO has been enabled now!! +++++");
    			    return new CustomerDAOImplement();
    		}
    		//___________________________________________________________________________________________________________________________
    		
    		// Bean of CART DAO:
    		@Bean(name="cartDAO")
    		public CartDAO getCartDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Cart Model as CartDAO has been enabled now!! +++++");
    			    return new CartDAOImplement();
    		}
    		//___________________________________________________________________________________________________________________________
    		
    		// Bean of SUPPLIER DAO:    		
    		@Bean(name="supplierDAO")
    		public SupplierDAO getSupplierDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Supplier Model as SupplierDAO has been enabled now!! +++++");
    			    return new SupplierDAOImplement();
    		}
    		
    		@Bean(name="orderdetailDAO")
    		public OrderDetailDAO getorderdetailDAO()
    		{
    				System.out.println("+++++ Do database manipulation of Category Model as CatogoryDAO has been enabled now!! +++++");
    			    return new OrderDetailDAOImpl();
    		}
//=========================================================================================================================
    		
    		@Bean(name="transTunnel")
    		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    		{
    			System.out.println("(   (  ( (Transaction Tunnel has been opened for a Synchronized committed transaction with the H2 Database) )  )   )");
    			return new HibernateTransactionManager(sessionFactory);
    		}
}
