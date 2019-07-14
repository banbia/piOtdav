package piotdav.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoryDeposit", catalog = "pi_otdav")
public class CategoryDeposit implements java.io.Serializable {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCategory_D", unique = true, nullable = false)
	private int idCategoryDep;
	private String libele;
	@OneToMany(mappedBy = "categoryDeposit")
	private Set<Deposit> deposit = new HashSet(0);
	
	
	public CategoryDeposit() {		
		
	}
	public CategoryDeposit(int idCategory_D) {		
		this.idCategoryDep = idCategory_D;
	}
	
	public CategoryDeposit(int idCategory_D, String libele) {
		this.idCategoryDep = idCategory_D;
		this.libele = libele;
	}

	
	public int getIdCategoryDeposit() {
		return idCategoryDep;
	}
	public void setIdCategoryDeposit(int idCategoryDeposit) {
		this.idCategoryDep = idCategoryDeposit;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	
	
}
