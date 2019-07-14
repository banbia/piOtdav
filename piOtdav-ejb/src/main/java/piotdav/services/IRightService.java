package piotdav.services;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Remote;

import piotdav.entities.Right;
import piotdav.entities.Work;

@Local
public interface IRightService {
	public List<Right> getRightsByWork(int workId);
	public Right getRightByReference(String reference);
	public boolean addRight(Right right);
	public boolean updateRight(Right right);
	public boolean deleteRight(int idRiht);
	public boolean linkRightsToWork(int idRight, int idWork);
}
