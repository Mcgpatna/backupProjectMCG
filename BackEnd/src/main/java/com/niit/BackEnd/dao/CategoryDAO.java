package com.niit.BackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.BackEnd.model.Category;



@Repository // database repository
public interface CategoryDAO {
	
	//declare all crud operation
	
		public boolean save(Category category);
		public boolean update(Category category);
		public boolean delete(Category category);
		public Category getByName(String name);

		public Category get(String id);
		public List<Category> list();
	
}
