package piotdav.entities;
// Generated 30 juin 2019 11:35:09 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import piotdav.entities.User;

/**
 * Fees generated by hbm2java
 */
@Entity
@Table(name = "fees", catalog = "pi_otdav")
public class Fees implements java.io.Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	@Column(name = "idFees", unique = true, nullable = false)
	private int idFees;
	private Float montant;	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = true)
	private User user;
	
	
	public Fees() {
	}
	
	public Fees(int idFees) {
		this.idFees = idFees;
	}

	public Fees(int idFees, Float montant) {
		this.idFees = idFees;
		this.montant = montant;
	}
	public Fees(int idFees, Float montant, User user) {
		this.idFees = idFees;
		this.montant = montant;
		this.user = user;
	}
	public Fees( Float montant, User user) {
		this.montant = montant;
		this.user = user;
	}
	public Fees( Float montant) {
		this.montant = montant;
	}
	public Fees(int idFees, Float montant, int idCategory) {
		super();
		this.idFees = idFees;
		this.montant = montant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "idFees", unique = true, nullable = false)
	public int getIdFees() {
		return this.idFees;
	}

	public void setIdFees(int idFees) {
		this.idFees = idFees;
	}


	@Column(name = "montant", precision = 12, scale = 0)
	public Float getMontant() {
		return this.montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}


}
