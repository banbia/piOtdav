package piotdav.entities;
// Generated 30 juin 2019 11:35:09 by Hibernate Tools 4.0.1.Final

import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Work generated by hbm2java
 */
@Entity
@Table(name = "work", catalog = "pi_otdav")
public class Work implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idWork;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user", nullable = true)
	private User user;
	private String titre;
	private String compositeur;
	private String ville;
	private Date date;
	private String genre;
	private Integer duree;
	private int etat;
	private Float pourcentAdaptateur;
	private Float pourcentArrangeur;
	private Float pourcentAuteur;
	private Float pourcentCompositeur;
	private Float pourcentEditeur;
	private TypeWork typeWork;
	private String bulletinOfdeclaration;
	private String copyOfWork;
	private String tradRegisterExcept;
	private String statutOfCompany;
	private String copyOfThePublicationOfCaompnyJORT;
	private String copyTaxIdentificationNumber;
	private String copydeclarationOfExistance;
	private String copymanagerIdentityCard;
	@ManyToOne
	@JoinColumn(name = "category", nullable = true)
	private Category category;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "works_rights", joinColumns = { @JoinColumn(name = "FK_WORK") }, inverseJoinColumns = {
			@JoinColumn(name = "FK_RIGHT") })
	private List<Right> rights ;

	public Work() {
	}

	public Work(int idWork, List<Right> rights) {
		super();
		this.idWork = idWork;
		this.rights = rights;
	}

	public Work(int idWork, User user) {
		this.idWork = idWork;
		this.user = user;
	}
	

	public Work(int etat) {
		super();		
		this.etat=etat;	
	}

	public Work(int idWork, User user, Category category, TypeWork typeWork) {
		super();
		this.idWork = idWork;
		this.user = user;
		this.typeWork = typeWork;
	}

	public Work(int idWork, User user, String titre, String compositeur, String ville, Date date,
			String genre, Integer duree, Float pourcentAdaptateur, Float pourcentArrangeur, Float pourcentAuteur,
			Float pourcentCompositeur, Float pourcentEditeur) {
		this.idWork = idWork;
		this.user = user;
		this.titre = titre;
		this.compositeur = compositeur;
		this.ville = ville;
		this.date = date;
		this.genre = genre;
		this.duree = duree;
		this.pourcentAdaptateur = pourcentAdaptateur;
		this.pourcentArrangeur = pourcentArrangeur;
		this.pourcentAuteur = pourcentAuteur;
		this.pourcentCompositeur = pourcentCompositeur;
		this.pourcentEditeur = pourcentEditeur;
		
	}
	
	//physique	

	public Work(int idWork, User user, String titre, String compositeur, String ville, Date date,
			String genre, Integer duree, Float pourcentAdaptateur, Float pourcentArrangeur, Float pourcentAuteur,
			Float pourcentCompositeur, Float pourcentEditeur, TypeWork typeWork, Set<Division> divisions) {
		super();
		this.idWork = idWork;
		this.user = user;
		this.titre = titre;
		this.compositeur = compositeur;
		this.ville = ville;
		this.date = date;
		this.genre = genre;
		this.duree = duree;
		this.pourcentAdaptateur = pourcentAdaptateur;
		this.pourcentArrangeur = pourcentArrangeur;
		this.pourcentAuteur = pourcentAuteur;
		this.pourcentCompositeur = pourcentCompositeur;
		this.pourcentEditeur = pourcentEditeur;
		this.typeWork = typeWork;
	}
	
	//Moral
	

	public Work(int idWork, User user, String titre, String compositeur, String ville, Date date, String genre,
			Integer duree, int etat, Float pourcentAdaptateur, Float pourcentArrangeur, Float pourcentAuteur,
			Float pourcentCompositeur, Float pourcentEditeur, TypeWork typeWork) {
		super();
		this.idWork = idWork;
		this.user = user;
		this.titre = titre;
		this.compositeur = compositeur;
		this.ville = ville;
		this.date = date;
		this.genre = genre;
		this.duree = duree;
		this.etat = etat;
		this.pourcentAdaptateur = pourcentAdaptateur;
		this.pourcentArrangeur = pourcentArrangeur;
		this.pourcentAuteur = pourcentAuteur;
		this.pourcentCompositeur = pourcentCompositeur;
		this.pourcentEditeur = pourcentEditeur;
		this.typeWork = typeWork;
	}

	public Work(int idWork, User user, String titre, String compositeur, String ville, Date date, String genre,
			Integer duree, int etat, Float pourcentAdaptateur, Float pourcentArrangeur, Float pourcentAuteur,
			Float pourcentCompositeur, Float pourcentEditeur, TypeWork typeWork, String bulletinOfdeclaration,
			String copyOfWork, String tradRegisterExcept, String statutOfCompany,
			String copyOfThePublicationOfCaompnyJORT, String copyTaxIdentificationNumber,
			String copydeclarationOfExistance, String copymanagerIdentityCard) {
		super();
		this.idWork = idWork;
		this.user = user;
		this.titre = titre;
		this.compositeur = compositeur;
		this.ville = ville;
		this.date = date;
		this.genre = genre;
		this.duree = duree;
		this.etat = etat;
		this.pourcentAdaptateur = pourcentAdaptateur;
		this.pourcentArrangeur = pourcentArrangeur;
		this.pourcentAuteur = pourcentAuteur;
		this.pourcentCompositeur = pourcentCompositeur;
		this.pourcentEditeur = pourcentEditeur;
		this.typeWork = typeWork;
		this.bulletinOfdeclaration = bulletinOfdeclaration;
		this.copyOfWork = copyOfWork;
		this.tradRegisterExcept = tradRegisterExcept;
		this.statutOfCompany = statutOfCompany;
		this.copyOfThePublicationOfCaompnyJORT = copyOfThePublicationOfCaompnyJORT;
		this.copyTaxIdentificationNumber = copyTaxIdentificationNumber;
		this.copydeclarationOfExistance = copydeclarationOfExistance;
		this.copymanagerIdentityCard = copymanagerIdentityCard;
	}

	
	public Work(int idWork, User user, String titre, String compositeur, String ville, Date date, String genre,
			Integer duree, int etat, Float pourcentAdaptateur, Float pourcentArrangeur, Float pourcentAuteur,
			Float pourcentCompositeur, Float pourcentEditeur, TypeWork typeWork, String bulletinOfdeclaration,
			String copyOfWork, String tradRegisterExcept, String statutOfCompany,
			String copyOfThePublicationOfCaompnyJORT, String copyTaxIdentificationNumber,
			String copydeclarationOfExistance, String copymanagerIdentityCard, Category category) {
		super();
		this.idWork = idWork;
		this.user = user;
		this.titre = titre;
		this.compositeur = compositeur;
		this.ville = ville;
		this.date = date;
		this.genre = genre;
		this.duree = duree;
		this.etat = etat;
		this.pourcentAdaptateur = pourcentAdaptateur;
		this.pourcentArrangeur = pourcentArrangeur;
		this.pourcentAuteur = pourcentAuteur;
		this.pourcentCompositeur = pourcentCompositeur;
		this.pourcentEditeur = pourcentEditeur;
		this.typeWork = typeWork;
		this.bulletinOfdeclaration = bulletinOfdeclaration;
		this.copyOfWork = copyOfWork;
		this.tradRegisterExcept = tradRegisterExcept;
		this.statutOfCompany = statutOfCompany;
		this.copyOfThePublicationOfCaompnyJORT = copyOfThePublicationOfCaompnyJORT;
		this.copyTaxIdentificationNumber = copyTaxIdentificationNumber;
		this.copydeclarationOfExistance = copydeclarationOfExistance;
		this.copymanagerIdentityCard = copymanagerIdentityCard;
		this.category = category;
	}

	@Column(name = "idWork", unique = true, nullable = false)
	public int getIdWork() {
		return this.idWork;
	}

	public void setIdWork(int idWork) {
		this.idWork = idWork;
	}

	
	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "titre", length = 254)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "compositeur", length = 254)
	public String getCompositeur() {
		return this.compositeur;
	}

	public void setCompositeur(String compositeur) {
		this.compositeur = compositeur;
	}

	@Column(name = "ville", length = 254)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "genre", length = 254)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "duree")
	public Integer getDuree() {
		return this.duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}	

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@Column(name = "pourcentAdaptateur", precision = 12, scale = 0)
	public Float getPourcentAdaptateur() {
		return this.pourcentAdaptateur;
	}

	public void setPourcentAdaptateur(Float pourcentAdaptateur) {
		this.pourcentAdaptateur = pourcentAdaptateur;
	}

	@Column(name = "pourcentArrangeur", precision = 12, scale = 0)
	public Float getPourcentArrangeur() {
		return this.pourcentArrangeur;
	}

	public void setPourcentArrangeur(Float pourcentArrangeur) {
		this.pourcentArrangeur = pourcentArrangeur;
	}

	@Column(name = "pourcentAuteur", precision = 12, scale = 0)
	public Float getPourcentAuteur() {
		return this.pourcentAuteur;
	}

	public void setPourcentAuteur(Float pourcentAuteur) {
		this.pourcentAuteur = pourcentAuteur;
	}

	@Column(name = "pourcentCompositeur", precision = 12, scale = 0)
	public Float getPourcentCompositeur() {
		return this.pourcentCompositeur;
	}

	public void setPourcentCompositeur(Float pourcentCompositeur) {
		this.pourcentCompositeur = pourcentCompositeur;
	}

	@Column(name = "pourcentEditeur", precision = 12, scale = 0)
	public Float getPourcentEditeur() {
		return this.pourcentEditeur;
	}

	public void setPourcentEditeur(Float pourcentEditeur) {
		this.pourcentEditeur = pourcentEditeur;
	}
	
	public TypeWork getTypeWork() {
		return typeWork;
	}

	public void setTypeWork(TypeWork typeWork) {
		this.typeWork = typeWork;
	}

	public String getBulletinOfdeclaration() {
		return bulletinOfdeclaration;
	}

	public void setBulletinOfdeclaration(String bulletinOfdeclaration) {
		this.bulletinOfdeclaration = bulletinOfdeclaration;
	}

	public String getCopyOfWork() {
		return copyOfWork;
	}

	public void setCopyOfWork(String copyOfWork) {
		this.copyOfWork = copyOfWork;
	}

	public String getTradRegisterExcept() {
		return tradRegisterExcept;
	}

	public void setTradRegisterExcept(String tradRegisterExcept) {
		this.tradRegisterExcept = tradRegisterExcept;
	}

	public String getStatutOfCompany() {
		return statutOfCompany;
	}

	public void setStatutOfCompany(String statutOfCompany) {
		this.statutOfCompany = statutOfCompany;
	}

	public String getCopyOfThePublicationOfCaompnyJORT() {
		return copyOfThePublicationOfCaompnyJORT;
	}

	public void setCopyOfThePublicationOfCaompnyJORT(String copyOfThePublicationOfCaompnyJORT) {
		this.copyOfThePublicationOfCaompnyJORT = copyOfThePublicationOfCaompnyJORT;
	}

	public String getCopyTaxIdentificationNumber() {
		return copyTaxIdentificationNumber;
	}

	public void setCopyTaxIdentificationNumber(String copyTaxIdentificationNumber) {
		this.copyTaxIdentificationNumber = copyTaxIdentificationNumber;
	}

	public String getCopydeclarationOfExistance() {
		return copydeclarationOfExistance;
	}

	public void setCopydeclarationOfExistance(String copydeclarationOfExistance) {
		this.copydeclarationOfExistance = copydeclarationOfExistance;
	}

	public String getCopymanagerIdentityCard() {
		return copymanagerIdentityCard;
	}

	public void setCopymanagerIdentityCard(String copymanagerIdentityCard) {
		this.copymanagerIdentityCard = copymanagerIdentityCard;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		

}
