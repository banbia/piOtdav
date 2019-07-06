package piotdav.implement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import piotdav.entities.Right;
import piotdav.services.IRightService;
@Stateless
public class RightService implements IRightService{
	private List<Right> rights;
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;
	public RightService() {
		rights=new ArrayList<Right>();
		rights.add(new Right(1,"ref1","Libelle1", "Lorem ispum sit amet dolor"));
		rights.add(new Right(2,"ref2","Libelle2", "Lorem ispum sit amet dolor"));
		rights.add(new Right(3,"ref3","Libelle3", "Lorem ispum sit amet dolor"));
		rights.add(new Right(4,"ref4","Libelle4", "Lorem ispum sit amet dolor"));
		rights.add(new Right(5,"ref5","Libelle5", "Lorem ispum sit amet dolor"));
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	
	public Right getRightByReference(String reference){
		for (Right l:rights){
			if(l.getReference()==reference)
				return l;
		}
		return null;
	}
	
	public boolean addRight(Right right){
		 em.persist(right);	
		 return true;
	}
	public void updateRight(Right right){
		em.persist(right);
	}
	
	public void deleteRight(Right right){
		em.remove(right);
	}
}
