package piotdav.services;

import java.util.List;

import javax.ejb.Local;


import piotdav.entities.Category;

@Local
public interface ICategoryService {
	
	public Boolean  addCategory(Category category);
	public int removeCategory(int idCategory);
	public Boolean updateCategory(Category NewCategory);
	public Category findCategoryById(int id);
	public List<Category> findAllCategory();
	

}
