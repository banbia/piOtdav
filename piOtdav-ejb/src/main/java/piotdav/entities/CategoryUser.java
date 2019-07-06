package piotdav.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoryUser", catalog = "pi_otdav")
public class CategoryUser implements java.io.Serializable  {

	private int idCategory;
	private String libele;
	@OneToMany(mappedBy = "categoryUser")
	private Set<Fees> fees;
	
	public CategoryUser() {		
		
	}
	public CategoryUser(int idCategoryUser) {		
		this.idCategory = idCategoryUser;
	}
	
	public CategoryUser(int idCategoryUser, String libele) {
		this.idCategory = idCategoryUser;
		this.libele = libele;
	}

	@Id
	@Column(name = "idCategoryUser", unique = true, nullable = false)
	public int getIdCategoryUser() {
		return idCategory;
	}
	public void setIdCategoryUser(int idCategoryUser) {
		this.idCategory = idCategoryUser;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	
	
}
