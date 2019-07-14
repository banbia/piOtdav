package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.Document;
import piotdav.entities.User;

 @Local
public interface IDocumentService {
	public boolean addDocument(Document document);
	public boolean updateDocument(Document document);
	public Document getDocumentByUser(User user);
	public Document findDocumentById(int idDocument);
	public boolean  deleteDocument(int idDocument) ;
	public List<Document> listDocument(int idUser);
}
