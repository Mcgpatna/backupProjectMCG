package com.niit.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.niit.dao.CustomerDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Customer;
import com.niit.model.Product;


@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/UserHome")
	public String displayUserHome(Model a)
	{
		List<Product> listProduct=productDAO.gettingProducts();
		
		a.addAttribute("listProducts", listProduct);
		return "UserHome";
	}
	
	@RequestMapping(value="/InsertCustomer",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer")Customer customer,Model m)
	{
		System.out.println("inside addCustomer()....");
		Customer customer1=new Customer();
		m.addAttribute(customer1);
		customerDAO.addingCustomer(customer);
	    
		m.addAttribute("msg", "Registered Successfully");
		return "Register";
	}
	
	@RequestMapping("/login_success")
	public String showHomePage(HttpSession session,Model m)
	{
		//String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ADMIN"))
			{
				loggedIn=true;
				//page="AdminPage";
				session.setAttribute("loggedin", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				//page="UserPage";
				session.setAttribute("loggedin", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		 return "index";
	}
}
