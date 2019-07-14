package piotdav.implement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


import piotdav.entities.TypeWork;
import piotdav.entities.Work;
import piotdav.services.IWorkService;
@Stateless
public class WorkService implements IWorkService{
	
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	@Override
	public Boolean addWork(Work work) {
		// TODO Auto-generated method stub
		Date myDate = new Date();
		String date= new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		Date date1;
		try {
		date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		work.setDate(date1);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		try {
			if(work!=null)
				em.persist(work);
				return true;
		}catch(Exception e) {
			return false;
		}
		
			
	}
	
	@Override
	public Boolean updateWork(Work NewWork) {
		
			
			Work work = em.find(Work.class, NewWork.getIdWork());	
			if(work != null) {
			work.setTitre(NewWork.getTitre());
			work.setCompositeur(NewWork.getCompositeur());
			work.setVille(NewWork.getVille());
			work.setDate(NewWork.getDate());			
			work.setDuree(NewWork.getDuree());
			work.setPourcentAdaptateur(NewWork.getPourcentAdaptateur());
			work.setPourcentArrangeur(NewWork.getPourcentArrangeur());
			work.setPourcentAuteur(NewWork.getPourcentAuteur());
			work.setPourcentCompositeur(NewWork.getPourcentCompositeur());
			work.setPourcentEditeur(NewWork.getPourcentEditeur());
			work.setBulletinOfdeclaration(NewWork.getBulletinOfdeclaration());
			work.setCopydeclarationOfExistance(NewWork.getCopydeclarationOfExistance());
			work.setCopymanagerIdentityCard(NewWork.getCopymanagerIdentityCard());
			work.setCopyOfThePublicationOfCaompnyJORT(NewWork.getCopyOfThePublicationOfCaompnyJORT());
			work.setCopyOfWork(NewWork.getCopyOfWork());
			work.setCopyTaxIdentificationNumber(NewWork.getCopyTaxIdentificationNumber());
			work.setTypeWork(NewWork.getTypeWork());
			em.persist(work);
			return true;
			}
			return false;
	
	
	}

	@Override
	public List<Work> listWorkByUser(int idUser) {
//		User user = em.find(User.class, idUser);
		TypedQuery<Work> query = em.createQuery(
				"SELECT w FROM Work w WHERE w.user.idUser = :user ", Work.class);
		query.setParameter("user", idUser);
		return query.getResultList();
	}

	@Override
	public List<Work> findAllWorks() {
		// TODO Auto-generated method stub
		List<Work> works = em.createQuery("select w from Work w",Work.class).getResultList();
		return works;
		
	}
	
	@Override
	public List<Work> findWorkBytype(int etat) {
		// TODO Auto-generated method stub
		TypedQuery<Work> query = em.createQuery("select w from Work w where w.etat = :etat", Work.class);
		query.setParameter("etat", etat);
		try
		{
		return query.getResultList();
		}
		catch (Exception e) { return null; }
	}


	
	@Override
	public Boolean approveWork(Work work) {
		// TODO Auto-generated method stub
		try {
			if (work != null && work.getEtat()== 1) {
				work.setEtat(2);}
				Work w = em.find(Work.class, work.getIdWork());
				w.setEtat(2);
				em.persist(w);
				return true;
			}catch ( Exception e ){
				return false;}
	}

	@Override
	public Boolean revokeWork(Work work) {
		// TODO Auto-generated method stub
		try {
			if (work!= null && work.getEtat()==1) {
				work.setEtat(3);}
				Work w = em.find(Work.class, work.getIdWork());
				w.setEtat(3);
				em.persist(w);
			return true;
			}catch ( Exception e ){
				return false;
				}
	}

	@Override
	public int cancelWork(int idWork) {
		// TODO Auto-generated method stub
		Work work = em.find(Work.class, idWork);
		try {
			if(work !=null && work.getEtat()==1)
			em.remove(work);
			return 1 ;
			}
			catch (Exception e) {
			return -1;

			}	
	}
	
	
	

}
