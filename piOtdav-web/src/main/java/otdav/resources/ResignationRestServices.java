package otdav.resources;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import piotdav.entities.Resignation;
import piotdav.implement.ResignationService;
import piotdav.services.IResignationService;

@ManagedBean
@RequestScoped
@Path("resignation")
public class ResignationRestServices {
	@EJB
	private IResignationService metier = new ResignationService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.ok(metier.getAll().toString(), MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getResiById")
	public Response getResignationByIdUser(@QueryParam("id")int id ){
		return Response.ok(metier.getResignationById(id).toString(), MediaType.APPLICATION_JSON).build();
	}
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterResignation(Resignation resignation) {
		
		if (metier.addResignation(resignation) == true) {

			return Response.status(Status.CREATED).entity("resignation  added").build();
		}
//
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
}
