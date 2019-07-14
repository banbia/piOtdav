package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.CategoryUser;
import piotdav.entities.Right;
@Local
public interface ICategoryUserService {
	public boolean addCategoryUser(CategoryUser categoriesUser);
	public void removeCategoryUser(CategoryUser categoryUser);
	public CategoryUser updateCategoryUser(CategoryUser categoryUser);
	public CategoryUser findCategoryUserById(int id);
	public List<CategoryUser> findAllCategoryUser();

}
