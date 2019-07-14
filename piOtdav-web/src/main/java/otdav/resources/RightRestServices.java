package otdav.resources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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

import piotdav.entities.Notification;
import piotdav.entities.Right;
import piotdav.implement.RightService;
import piotdav.services.IRightService;

@ManagedBean
@RequestScoped
@Path("rights")
public class RightRestServices {
	@EJB
	private IRightService metier = new RightService();

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterRight(Right right) {
		right.setWorks(null);
		if (metier.addRight(right) == true) {

			return Response.status(Status.CREATED).entity("right added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRight(Right right) {
		if (metier.deleteRight(right.getIdRight()) == true) {
			return Response.status(Status.OK).entity("deleted").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRight(Right right) {
		if (metier.updateRight(right) == true) {

			return Response.status(Status.OK).entity("right updated").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE)
				.entity("Your request have been rejected, This Right linked to one or more work(s)").build();

	}
	@GET
	@Path("byRef")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRightByRef(@QueryParam(value = "ref") String ref) {
		if(ref==null) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("ref null").build();
		}
		Right right = metier.getRightByReference(ref);
		if (right == null ) {
			return Response.status(Status.NOT_FOUND).entity("No Right found with this ref").build();
		}
		return Response.status(Status.FOUND).entity(right).build();

	}
	@GET
	@Path("listByWork")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(@QueryParam(value = "idWork") int idWork) {
		
		List<Right> liste = metier.getRightsByWork(idWork);
		if (liste.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("No Rights linked to this work").build();
		}
		return Response.status(Status.FOUND).entity(liste).build();

	}
	@GET
	@Path("linkRightToWork")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(@QueryParam(value = "idWork") int idWork,@QueryParam(value = "idRight") int idRight) {
		if (metier.linkRightsToWork(idRight,idWork)==false) {
			return Response.status(Status.NOT_FOUND).entity("This right is already binded to this work").build();
		}
		return Response.status(Status.OK).entity("right linked to work successfully" ).build();
 
	}
}
