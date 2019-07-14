package piotdav.services;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import piotdav.entities.Category;
import piotdav.entities.Deposit;
import piotdav.entities.User;

@Local
public interface IDepositService {
	 
	 public boolean addDeposit(Deposit deposit);
	 public boolean updateDeposit(Deposit deposit);
	 public boolean renewalDeposit(Deposit deposit);
	 public int deleteDeposit(int idDeposit);
	 public List<Deposit> getDeposit();
	 public int revocDeposit(int deposit);
	 public List<Deposit> getDepositByAdherent(int idUser);
	public List<Deposit> getDepositByCategorie(int categoryDeposit);
	
}
