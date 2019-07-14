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

import piotdav.entities.Fees;
import piotdav.implement.FeesService;
import piotdav.services.IFeesService;



@ManagedBean
@RequestScoped
@Path("fees")
public class FeesRestServices {
	@EJB
	private IFeesService metier = new FeesService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.status(Status.OK).entity("Fees").build();
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddFees(Fees fees) {
		if (metier.addFees(fees) == true) {
			return Response.status(Status.CREATED).entity("fees added").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatFees(Fees fees) {		
		if (metier.updateFees(fees) == true) {
			return Response.status(Status.OK).entity("fees updated").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFees(Fees fess) {
		if (metier.deleteFees(fess.getIdFees()) == true) {
			return Response.status(Status.OK).entity("deleted").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@GET
	@Path("getFees")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneFee(@QueryParam(value="idFees")int idFees){
		 return Response.ok(metier.findFeesById(idFees), MediaType.APPLICATION_JSON).build();

	}
	@GET
	@Path("listeAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFees(@QueryParam(value="idUser")int idUser){
		return Response.status(Status.OK).entity(metier.listFees(idUser)).build();
	}
	
}
