package piotdav.implement;

import java.util.List;

import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import piotdav.entities.Category;
import piotdav.entities.Work;
import piotdav.services.ICategoryService;


public class CategoryService implements ICategoryService{
	
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		
		em.persist(category);
		
	}

	@Override
	public String removeCategory(int idCategory) {
		// TODO Auto-generated method stub
		if(em.find(Category.class, idCategory)== null) {
			
			return "idCategory ="+idCategory+"d'ont existe";
		}else {
			em.remove(em.find(Category.class, idCategory));
			return "Delete succeful";
		}
		
	}

	@Override
	public String updateCategory(Category NewCategory) {
		// TODO Auto-generated method stub
		
		if (em.find(Category.class, NewCategory.getIdCategory())==null)
		{
	return "Category don't existe" +NewCategory.getIdCategory();
		}
		else{
			Category category = em.find(Category.class, NewCategory.getIdCategory());
			category.setLibele(NewCategory.getLibele());
			
		}
		return "Update successful";
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
		System.out.println("In findAlloeuvrs : "); 
		List<Category> categories =
				em.createQuery("from Category", Category.class).getResultList();
		System.out.println("Out of findAllCategory : "); 
		return categories;
		
	}

}
