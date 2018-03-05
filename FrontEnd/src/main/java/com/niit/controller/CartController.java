package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId") int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		
		Cart cart=new Cart();
		Product product=productDAO.gettingProduct(productId);
		String username=(String)session.getAttribute("username");
		
		cart.setProductId(productId);
		cart.setQuantity(quantity);
		cart.setUsername(username);
		cart.setPaymentStatus("NP");
		cart.setSubtotal(quantity*product.getProductPrice());
		cart.setProductName(product.getProductName());
		cart.setPrice(product.getProductPrice());
		
		cartDAO.addingCart(cart);
		
		m.addAttribute("cartList", cartDAO.gettingCart(username));
		m.addAttribute("grandTotal", this.grandTotal(cartDAO.gettingCart(username)));
		
		return "Cart";
	}

	@RequestMapping("/updateCartItem/{cartId}")
	public String updateCartItem(@PathVariable("cartId") int cartId,@RequestParam("qty")int quantity,HttpSession session,Model m)
	{
		Cart cart=cartDAO.gettingCart(cartId);
		Product product=productDAO.gettingProduct(cart.getProductId());
		
		cart.setQuantity(quantity);
		cart.setSubtotal(quantity*product.getProductPrice());
		
		cartDAO.updatingCart(cart);
		
		String username=(String)session.getAttribute("username");
		m.addAttribute("cartList", cartDAO.gettingCart(username));
		m.addAttribute("grandTotal", this.grandTotal(cartDAO.gettingCart(username)));
		return "Cart";
	}

	@RequestMapping("/deleteCartItem/{cartId}")
	public String deleteCartItem(@PathVariable("cartId") int cartId,HttpSession session,Model m)
	{
		Cart cart=cartDAO.gettingCart(cartId);
				
		cartDAO.deletingCart(cart);
		
		String username=(String)session.getAttribute("username");
		m.addAttribute("cartList", cartDAO.gettingCart(username));
		m.addAttribute("grandTotal", this.grandTotal(cartDAO.gettingCart(username)));
		return "Cart";
	}
	public float grandTotal(List<Cart> listCart)
	{
		float gTotal=0.0f;
		
		for(Cart cart:listCart)
		{
			gTotal+=cart.getSubtotal();
		}
		
		return gTotal;
	}
	
}
