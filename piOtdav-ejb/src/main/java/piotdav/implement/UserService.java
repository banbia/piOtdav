package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import piotdav.entities.User;
import piotdav.services.IUserService;
@Stateless
public class UserService implements IUserService {
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean addUser(User a) {
	
		em.persist(a);

		return true;
	}





	@Override
	public User getUserById(int id) {
		User adh = new User();

		adh = em.find(User.class, id);

		return adh;
	}



	@Override
	public boolean deleteUser(int  iduser) {
	
		em.remove(em.find(User.class, iduser));

			return true;

		
	}

	@Override
	public boolean updateUser(int  iduser) {
		User u =em.find(User.class,iduser);
		u.setLieuNaissance("tunis");
		em.persist(u);
		return true;
	}

	@Override
	public User login(String login, String password) {
		try {
			Query query = em.createQuery("select e from User e where (e.login=:l or e.email=:l) and e.password=:p");
			query.setParameter("l", login).setParameter("p", password);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public List<User> getAllUser() {
		List<User> users = em.createQuery("select u from User u",User.class).getResultList();
		return users;

		}
	}
	


