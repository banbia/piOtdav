package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import piotdav.entities.Document;
import piotdav.entities.User;
import piotdav.services.IDocumentService;
@Stateless
public class DocumentService implements IDocumentService {

	private List<Document> Documents;
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;
	
	public List<Document> getDocuments() {
		return Documents;
	}

	public void setDocuments(List<Document> documents) {
		Documents = documents;
	}

	@Override
	public boolean addDocument(Document document) {
		em.persist(document);
		return true;	
	}

	@Override
	public boolean updateDocument(Document document) {
		Document doc = em.find(Document.class, document.getIdDocument());
		doc.setDateAjout(document.getDateAjout());
		doc.setLieu(document.getLieu());
		doc.setNomDocument(document.getNomDocument());
		doc.setTypeDocument(document.getTypeDocument());
		em.persist(doc);
		return true ;
	}

	@Override
	public Document getDocumentByUser(User user) {
		TypedQuery<Document> query = em.createQuery(
				"SELECT u FROM Document u WHERE u.user.idUser = :user",Document.class);		
		query.setParameter("iduser", user.getIdUser());
		return (Document) query.getResultList();
	}

	@Override
	public Document findDocumentById(int idDocument) {
		Document documentToFind = em.find(Document.class, idDocument);
		return documentToFind;
	}

	@Override
	public boolean deleteDocument(int idDocument) {
		em.remove(em.find(Document.class, idDocument));
		return true;
	}

	@Override
	public List<Document> listDocument(int idUser) {
		TypedQuery<Document> query = em.createQuery(
				"SELECT u FROM Document u WHERE u.user.idUser = :user ", Document.class);
		query.setParameter("user", idUser);
		return query.getResultList();
	}

}
