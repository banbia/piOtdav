package piotdav.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import piotdav.entities.Deposit;
import piotdav.entities.User;

@Remote
public interface DepositService {
	 
	 public void addDeposit(Deposit deposit);
	 public Deposit updateDeposit(Deposit deposit);
	 public Deposit renewalDeposit(Deposit deposit);
	 public void deleteDeposit(int idDeposit);
	 public List<Deposit> getDeposit();
	 public Deposit revocDeposit(Deposit deposit);
	 public List<Deposit> DepositByAdherent(User user);
	 public List<Deposit> getDepositByCategorie(String category);
	
}
