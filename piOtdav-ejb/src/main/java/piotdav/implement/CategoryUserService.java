package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import piotdav.entities.CategoryUser;
import piotdav.services.ICategoryUserService;
@Stateless
public class CategoryUserService implements ICategoryUserService {
	private List<CategoryUser> categoreisUser;
	@PersistenceContext(name="otdav-ejb")
	 static	EntityManager em;
	
	public List<CategoryUser> getCategoreisUser() {
		return categoreisUser;
	}

	public void setCategoreisUser(List<CategoryUser> categoreisUser) {
		this.categoreisUser = categoreisUser;
	}

	@Override
	public boolean addCategoryUser(CategoryUser categoryUser) {
		em.persist(categoryUser);
		return true;	
	}

	@Override
	public void removeCategoryUser(CategoryUser categoryUser) {
		em.remove(categoryUser);	
		
	}

	@Override
	public CategoryUser updateCategoryUser(CategoryUser categoryUser) {
	 return	em.merge(categoryUser);
		
	}

	@Override
	public CategoryUser findCategoryUserById(int id) {
		CategoryUser cotegoryUserToFind = em.find(CategoryUser.class, id);
		return cotegoryUserToFind;
	}

	@Override
	public List<CategoryUser> findAllCategoryUser() {
		return categoreisUser;
	}

}
