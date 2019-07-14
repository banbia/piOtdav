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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import piotdav.entities.Right;
import piotdav.entities.Work;

import piotdav.implement.WorkService;
import piotdav.services.IWorkService;

@ManagedBean
@RequestScoped
@Path("works")
public class WorkRestServices {
	
	@EJB
	private IWorkService metier = new WorkService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.ok(metier.findAllWorks(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("byId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListeByid(){
		return Response.ok(metier.findAllWorks(), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterWork(Work work) {
		
		if (metier.addWork(work) == true) {

			return Response.status(Status.CREATED).entity("work added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWork(Work work)
	{
			if(metier.cancelWork(work.getIdWork()) == 1) {
				return Response.status(Status.OK).entity("deleted").build();
			}
			return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWork(Work work) {
		if (metier.updateWork(work)) {

		return Response.status(Status.OK).entity("update succ").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Path("approuve")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approuvedWork(Work work) {
		if (metier.approveWork(work)) {

		return Response.status(Status.OK).entity("approuved succ").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Path("revock")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response revockdWork(Work work) {
		if (metier.revokeWork(work)) {

		return Response.status(Status.OK).entity("revock succ").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@GET
	@Path("getWorkByUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkByUser(@QueryParam(value="idUser")int idUser){
		 return Response.ok(metier.listWorkByUser(idUser), MediaType.APPLICATION_JSON).build();

	}
	
	@GET
	@Path("getWorkByEtat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkByEtat(@QueryParam(value="etat")int etat){
		 return Response.ok(metier.findWorkBytype(etat), MediaType.APPLICATION_JSON).build();

	}
	

}
