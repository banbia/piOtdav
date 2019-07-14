package otdav.resources;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import piotdav.entities.Document;
import piotdav.implement.DocumentService;
import piotdav.services.IDocumentService;
@ManagedBean
@RequestScoped
@Path("document")
public class DocumentRestService {
	@EJB
	private IDocumentService metier = new DocumentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.status(Status.OK).entity("Document").build();
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddDocument(Document document) {
		if (metier.addDocument(document) == true) {
			return Response.status(Status.CREATED).entity("Document added").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatDocument(Document document) {		
		if (metier.updateDocument(document) == true) {
			return Response.status(Status.OK).entity("Document updated").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDocument(Document document) {
		if (metier.deleteDocument(document.getIdDocument()) == true) {
			return Response.status(Status.OK).entity("deleted").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@GET
	@Path("getDocument")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneFee(@QueryParam(value="idDocument")int idDocument){
		 return Response.ok(metier.findDocumentById(idDocument), MediaType.APPLICATION_JSON).build();

	}
	@GET
	@Path("listeAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDocument(@QueryParam(value="idUser")int idUser){
		return Response.status(Status.OK).entity(metier.listDocument(idUser)).build();
	}
}
