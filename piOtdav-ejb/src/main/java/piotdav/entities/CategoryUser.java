package piotdav.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import piotdav.entities.User;

@Entity
@Table(name = "categoryUser", catalog = "pi_otdav")
public class CategoryUser implements java.io.Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	@Column(name="idCategoryUser",length=254)
	private int idCategory;
	private String libele;
	@OneToMany(mappedBy = "category")
	private Set<User> users ;
	
	public CategoryUser() {		
		
	}
	public Set<User> getUser() {
		return users;
	}
	public void setUser(Set<User> user) {
		this.users = user;
	}

	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public CategoryUser(String libele) {
	
		this.libele = libele;
	}

	
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
