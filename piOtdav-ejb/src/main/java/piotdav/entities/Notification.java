package piotdav.entities;
// Generated 30 juin 2019 11:35:09 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Notification generated by hbm2java
 */
@Entity
@Table(name = "notification", catalog = "pi_otdav")
public class Notification implements java.io.Serializable {

	private int idNotification;
	private User user;
	private Date dateNotification;
	private String etat;
	private Integer typeNotification;
	private String description;

	public Notification() {
	}

	public Notification(int idNotification, User user) {
		this.idNotification = idNotification;
		this.user = user;
	}

	public Notification(int idNotification, User user, Date dateNotification, String etat, Integer typeNotification,
			String description) {
		this.idNotification = idNotification;
		this.user = user;
		this.dateNotification = dateNotification;
		this.etat = etat;
		this.typeNotification = typeNotification;
		this.description = description;
	}

	@Id

	@Column(name = "idNotification", unique = true, nullable = false)
	public int getIdNotification() {
		return this.idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateNotification", length = 19)
	public Date getDateNotification() {
		return this.dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

	@Column(name = "etat", length = 254)
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Column(name = "typeNotification")
	public Integer getTypeNotification() {
		return this.typeNotification;
	}

	public void setTypeNotification(Integer typeNotification) {
		this.typeNotification = typeNotification;
	}

	@Column(name = "description", length = 254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
