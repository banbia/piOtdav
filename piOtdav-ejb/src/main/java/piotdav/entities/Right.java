package piotdav.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "right", catalog = "pi_otdav")
public class Right implements java.io.Serializable {
	@Id
	@Column(name = "idRight", unique = true, nullable = false)
	private int idRight;
	private String libele;
	private String reference;
	private String description;
	@ManyToMany(mappedBy="rights")
	private List<Work> works ;
	public Right() {
	}

	public Right(int idRight) {
		this.idRight = idRight;
	}

	public Right(int idRight,String reference, String libele,String description) {
		this.idRight = idRight;
		this.reference = reference;
		this.libele = libele;
		this.description = description;
	}
	
	public int getIdRight() {
		return this.idRight;
	}

	public void setIdRight(int idRight) {
		this.idRight = idRight;
	}
	@Column(name = "reference", length = 255)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	@Column(name = "libele", length = 254)
	public String getLibele() {
		return this.libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}
	@Column(name = "description", length=2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

}

