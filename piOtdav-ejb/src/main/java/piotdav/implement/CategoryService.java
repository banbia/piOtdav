package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import piotdav.entities.Category;
import piotdav.entities.Work;
import piotdav.services.ICategoryService;

@Stateless
public class CategoryService implements ICategoryService{
	
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	@Override
	public Boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		
		try {
			if(category!=null)
				em.persist(category);
				return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public int removeCategory(int idCategory) {
		// TODO Auto-generated method stub
		Category category = em.find(Category.class, idCategory);
		try {
			
			em.remove(category);
			return 1 ;
			}
			catch (Exception e) {
			return -1;

			}
		
	}

	@Override
	public Boolean updateCategory(Category NewCategory) {
		// TODO Auto-generated method stub
		
		Category category = em.find(Category.class, NewCategory.getIdCategory());	
		if(category != null) {
		category.setLibele(NewCategory.getLibele());
		em.persist(category);
		return true;
		}
		return false;
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		System.out.println("In findCategoryById : ");
		Category category = em.find(Category.class, id);
		System.out.println("Out of findCategoryId : ");
		return category;
		
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> categories =
				em.createQuery("select c from Category c", Category.class).getResultList();
		 
		return categories;
		
	}

}
