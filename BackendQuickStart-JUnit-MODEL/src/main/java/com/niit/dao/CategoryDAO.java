package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO 
{
				public boolean addingCategory(Category category);
				public boolean updatingCategory(Category category);
				public Category gettingCategory(int categoryId);
				public List<Category> gettingCategories();
				public boolean deletingCategory(Category category);
				
				
}
