package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO 
{
				public boolean addingProduct(Product product);
				public boolean updatingProduct(Product product);
				public Product gettingProduct(int productId);
				public List<Product> gettingProducts();
				public boolean deletingProduct(Product product);		
}