package piotdav.services;

import java.util.List;
import javax.ejb.Local;
import piotdav.entities.Notification;

@Local
public interface INotificationService {
	public boolean addNotification(Notification notification);
	public boolean updateNotification(Notification notification);
	public boolean marquerLueNotification(int idNotif);
	public boolean deleteNotification(int idNotif);
	public List<Notification> listNotification(int idUser);
	public List<Notification> listNonLueNotification(int idUser);
	public Notification getNotification(int idNotif);
}
