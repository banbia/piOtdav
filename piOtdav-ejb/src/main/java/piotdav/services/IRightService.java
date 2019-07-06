package piotdav.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import piotdav.entities.Right;

@Local
public interface IRightService {
	public List<Right> getRights();
	public void setRights(List<Right> rights);
	public Right getRightByReference(String reference);
	public boolean addRight(Right right);
	public void updateRight(Right right);
	public void deleteRight(Right right);
}
