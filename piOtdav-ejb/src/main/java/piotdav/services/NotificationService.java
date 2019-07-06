package piotdav.services;


import javax.ejb.Remote;
import piotdav.entities.Notification;;

@Remote
public interface NotificationService {
	
	
 public void addrNotification(Notification notification);
 public void updateNotification(Notification notification);
 public void deleteNotification(Notification notification);
 public void selectNotification(Notification notification);
 public void searchNotification(Notification notification);
 
 
}
