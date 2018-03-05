package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO 
{
				public boolean addingCart(Cart cart);
				public boolean updatingCart(Cart cart);
				public Cart gettingCart(int cartId);
				public List<Cart> gettingCart(String username);
				public boolean deletingCart(Cart cart);			
}