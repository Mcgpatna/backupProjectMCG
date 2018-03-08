package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean confirmedOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
		try {
			 sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception arose while ' adding ' OrderDetail!!" +e);
			e.printStackTrace();
			return false;
		}
	}

}
