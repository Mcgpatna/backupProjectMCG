package com.niit.BackEnd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.model.Category;



@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public  CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean save(Category category)
	{
		try {
			log.debug("Starting of the save ");
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Exception occured in save() "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Category category)
	{
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Category category)
	{
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Category get(String id)
	{
		//select * from catogory where id='101';
		log.debug("starting of get()");
		log.info("trying to get category of id : "+id);
		String hql=" from Category where id= '"+id+"'";
		
		log.info("hql is :" +hql);
		
		@SuppressWarnings("deprecation")
		Query query=sessionFactory.openSession().createQuery(hql);//.getCurrentSession().createQuery(hql);
		
		List<Category> list= query.list();
		
		if(list==null || list.isEmpty())
		{
			log.debug("No categories are available");
			return null;
		}
		else
		{
			return list.get(0);
		}
		
	}
	public List<Category> list()
	{
		
		String hql="from Category";
		
		@SuppressWarnings("deprecation")
		Query query=sessionFactory.openSession().createQuery(hql);//.getCurrentSession().createQuery(hql);
		List<Category> catgList=(List<Category>) query.list();
		//return (List<Category>) query.list();
		for(Category catg:catgList)
		{
			System.out.println(catg.getId());
			System.out.println(catg.getName());
			System.out.println(catg.getDescription());
			
		}
			return catgList;
		
	}
	@Transactional
	public Category getByName(String name) {
		String hql = "from Category where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	}
	
}
