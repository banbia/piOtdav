package piotdav.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import piotdav.entities.Category;

@Local
public interface ICategoryService {
	
	public void  addCategory(Category category);
	public String removeCategory(int idCategory);
	public String updateCategory(Category NewCategory);
	public Category findCategoryById(int id);
	public List<Category> findAllCategory();

}
