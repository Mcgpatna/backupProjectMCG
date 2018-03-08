package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDetailDAO;
import com.niit.model.Cart;
import com.niit.model.OrderDetail;

@Controller
public class OrderController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO orderdetailDAO;
	
	@RequestMapping("/ConfirmOrder")
	public String confirmOrder(HttpSession session,Model m)
	{
		System.out.println("inside confirmOrder()....");
		String username=(String)session.getAttribute("username");
		List<Cart> listCart=cartDAO.gettingCart(username);
		m.addAttribute("cartList", listCart);
		m.addAttribute("grandTotal", this.grandTotal(cartDAO.gettingCart(username)));
		m.addAttribute("username",username);
		
		return "OrderConfirm";
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
	
	@RequestMapping(value="/PaymentConfirm", method=RequestMethod.POST)
	public String paymentConfirm(@RequestParam("pmode")String pmode,@RequestParam("shipAddr")String shipAddr,HttpSession session,Model m)
	{
		System.out.println("inside paymentConfirm()....");
		String username=(String)session.getAttribute("username");
		List<Cart> listCart=cartDAO.gettingCart(username);
		
		OrderDetail orderDetail=new OrderDetail();
		
		System.out.println(listCart.get(0).getCartId());
		System.out.println(shipAddr);
		System.out.println(username);
		System.out.println((int)this.grandTotal(cartDAO.gettingCart(username)));
		System.out.println(pmode);
		
		orderDetail.setCardId(listCart.get(0).getCartId());
		orderDetail.setOrderDate(new Date());
		orderDetail.setShippingAddr(shipAddr);
		orderDetail.setUsername(username);
		orderDetail.setTotalAmt((int)this.grandTotal(listCart));
		orderDetail.setPayMode(pmode);
		
		orderdetailDAO.confirmedOrderDetail(orderDetail);
		
		return "ThankYou";
	
	}
	

}
