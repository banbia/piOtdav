package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.Resignation;
@Local
public interface IResignationService {
	public boolean addResignation(Resignation resignation);	
	public Resignation getResignationById(int id);
	public List<Resignation> getAll();	
	public Resignation  getResignationByIdUser(int id);
}
