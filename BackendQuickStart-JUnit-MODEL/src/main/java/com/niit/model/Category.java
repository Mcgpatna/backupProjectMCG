package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category 
{
			@Id
			@GeneratedValue  // WORKS ONLY FOR INTEGER TYPE '@Id TARGATED PRIMARY KEY' WHICH IS categoryId in this program; 
			//... it won't work for String type Primary Keys or any other datatypes that are prescribed to be used within any database except for integers like categoryId!!
			private int categoryId;
			private String categoryName;
			private String categoryDescript;
			
			public int getCategoryId() 
			{
				return categoryId;
			}
			public void setCategoryId(int categoryId) 
			{
				this.categoryId = categoryId;
			}
			public String getCategoryName() 
			{
				return categoryName;
			}
			public void setCategoryName(String categoryName) 
			{
				this.categoryName = categoryName;
			}
			public String getCategoryDescript() 
			{
				return categoryDescript;
			}
			public void setCategoryDescript(String categoryDescript) 
			{
				this.categoryDescript = categoryDescript;
			}
}
