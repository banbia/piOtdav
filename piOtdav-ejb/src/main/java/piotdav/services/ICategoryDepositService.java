package piotdav.services;

import java.util.List;

import javax.ejb.Remote;

import piotdav.entities.CategoryDeposit;

@Remote
public interface ICategoryDepositService {
	 public boolean addCategoryDeposit(CategoryDeposit C_deposit);
	 public boolean updateCategoryDeposit(CategoryDeposit C_deposit);
	 public int deleteCategoryDeposit(int idC_Deposit);
	 public List<CategoryDeposit> getCategoryDeposit();
	
}
