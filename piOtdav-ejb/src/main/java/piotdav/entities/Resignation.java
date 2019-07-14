package piotdav.entities;
// Generated 30 juin 2019 11:35:09 by Hibernate Tools 4.0.1.Final

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Resignation generated by hbm2java
 */
@Entity
@Table(name = "resignation", catalog = "pi_otdav")
public class Resignation implements java.io.Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	private int idResignation;
	private Date date;
	private String raison;
	@ManyToOne
	@JoinColumn(name = "user", nullable = false )
	private User user;
	public Resignation() {
	}



	
	@Column(name = "idResignation", unique = true, nullable = false)
	public int getIdResignation() {
		return this.idResignation;
	}

	public void setIdResignation(int idResignation) {
		this.idResignation = idResignation;
	}

	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public Resignation(Date date, String raison, User user) {
		
		this.date = date;
		this.raison = raison;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Resignation [idResignation=" + idResignation + ", date=" + date + ", raison=" + raison + ", user="
				+ user + "]";
	}
	
	
	

}
