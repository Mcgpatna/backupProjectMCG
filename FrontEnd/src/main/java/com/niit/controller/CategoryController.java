package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;

	boolean flag = true;

	//All Request mapping functions
	
	@RequestMapping("/category")
	public String showCategory(Model m) {
		List<Category> listCategories = categoryDAO.gettingCategories();
		m.addAttribute("listCategories", listCategories);

		for (Category category : listCategories) {
			System.out.println(category.getCategoryName() + ",");
		}
		flag = false;
		return "Category";
	}

	@RequestMapping(value = "/InsertCategory", method = RequestMethod.POST)
	public String insertCategoryData(@RequestParam("catname") String catname, @RequestParam("catdesc") String catdesc,
			Model m) {
		Category category = new Category();
		category.setCategoryName(catname);
		category.setCategoryDescript(catdesc);

		categoryDAO.addingCategory(category);

		List<Category> listCategories = categoryDAO.gettingCategories();
		m.addAttribute("listCategories", listCategories);
		flag = false;
		return "Category";
	}

	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.gettingCategory(categoryId);
		
		categoryDAO.deletingCategory(category);
		
		List<Category> listCategories=categoryDAO.gettingCategories();
		m.addAttribute("listCategories",listCategories);
		flag=false;
		return "UpdateCategory";
	}

	@RequestMapping("/updateCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.gettingCategory(categoryId);
		
		
		List<Category> listCategories=categoryDAO.gettingCategories();
		m.addAttribute("listCategories",listCategories);
		m.addAttribute("categoryInfo",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String categoryName,@RequestParam("catdesc") String categoryDesc,Model m)
	{
		Category category=categoryDAO.gettingCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDescript(categoryDesc);
		
		categoryDAO.updatingCategory(category);
		
		List<Category> listCategories=categoryDAO.gettingCategories();
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
	}

	//end of request mapping function
	
	
}
