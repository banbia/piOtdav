package piotdav.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import piotdav.entities.TypeWork;
import piotdav.entities.Work;
import piotdav.services.IWorkService;

public class WorkService implements IWorkService{
	
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	@Override
	public void addWork(Work work) {
		// TODO Auto-generated method stub
		em.persist(work);
		
		
	}
	
	@Override
	public String updateWork(Work NewWork) {
		if (em.find(Work.class, NewWork.getIdWork())==null)
		{
	return "Work don't existe" +NewWork.getIdWork();
		}
		else{
			System.out.println("In updateOeuvre : ");
			Work work = em.find(Work.class, NewWork.getIdWork());			
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
	return "Updated with success ";
}

		
	}

	@Override
	public Work findWorkById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Work> findAllWorks() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Work approveWork(Work work) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Work revokeWork(Work work) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Work cancelWork(Work work) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Work> findWorkBytype(TypeWork etat) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
