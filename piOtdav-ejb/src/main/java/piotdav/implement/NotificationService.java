package piotdav.implement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import piotdav.entities.Category;
import piotdav.entities.Notification;
import piotdav.entities.User;
import piotdav.services.INotificationService;
@Stateless
public class NotificationService implements INotificationService{
	
	private List<Notification> notifs;
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;
	
	@Override
	public boolean addNotification(Notification notification) {
		Date myDate = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			notification.setDateNotification(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		notification.setEtat("0");
		em.persist(notification);
		return true;
	}

	@Override
	public boolean updateNotification(Notification notification) {
		em.merge(notification);
		return true;
	}

	@Override
	public boolean deleteNotification(int idNotif) {
		em.remove(em.find(Notification.class, idNotif));
		return true;
	}

	@Override
	public boolean marquerLueNotification(int idNotif) {
		Notification  notif = em.find(Notification.class, idNotif);
		notif.setEtat("1");
		em.persist(notif);
		return true;
	}
	@Override
	public Notification getNotification(int idNotif) {
		Notification notif = em.find(Notification.class, idNotif);
		
		return notif;
	}
	@Override
	public List<Notification> listNotification(int idUser) {
//		User user = em.find(User.class, idUser);
		TypedQuery<Notification> query = em.createQuery(
				"SELECT u FROM Notification u WHERE u.user.idUser = :user ", Notification.class);
		query.setParameter("user", idUser);
		return query.getResultList();
	}
	@Override
	public List<Notification> listNonLueNotification(int idUser) {
//		User user = em.find(User.class, idUser);
		TypedQuery<Notification> query = em.createQuery(
				"SELECT u FROM Notification u WHERE u.user.idUser = :user and u.etat='0'", Notification.class);
		query.setParameter("user", idUser);
		return query.getResultList();
	}
}
