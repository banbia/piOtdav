package piotdav.services;

import java.util.List;

import javax.ejb.Local;
<<<<<<< HEAD
import javax.ejb.Remote;
=======

>>>>>>> c4bfd2720e2e81271310492344895b02538e3d27

import piotdav.entities.Category;

@Local
public interface ICategoryService {
	
	public Boolean  addCategory(Category category);
	public int removeCategory(int idCategory);
	public Boolean updateCategory(Category NewCategory);
	public Category findCategoryById(int id);
	public List<Category> findAllCategory();
	

}
