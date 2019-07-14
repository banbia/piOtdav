package piotdav.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import piotdav.entities.TypeWork;
import piotdav.entities.Work;

@Local
public interface IWorkService {
	
	public Boolean  addWork(Work work);
	public Boolean approveWork (Work work);
	public Boolean revokeWork (Work work);
	public int cancelWork (int intWork); // delete
	public Boolean updateWork(Work work);	
	public List<Work> findWorkBytype(int etat);
	public List<Work> findAllWorks();
	public List<Work> listWorkByUser(int idUser);

}
