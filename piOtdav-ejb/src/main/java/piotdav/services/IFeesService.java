package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.Fees;
import piotdav.entities.User;

@Local
public interface IFeesService {
	public boolean addFees(Fees fees);
	public boolean updateFees(Fees fees);
	public Fees getFeesByUser(User user);
	public Fees findFeesById(int idFees);
	public boolean  deleteFees(int idFees) ;
	public List<Fees> listFees(int idUser);
}
