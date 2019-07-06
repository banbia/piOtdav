package otdav.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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

import piotdav.entities.Right;
import piotdav.implement.RightService;
import piotdav.services.IRightService;


@ManagedBean
@RequestScoped
@Path("rights")
public class RightRestServices {
	@EJB
	private IRightService metier = new RightService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.status(Status.OK).entity("cccccc").build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterRight(Right right) {

		if (metier.addRight(right) == true) {

			return Response.status(Status.CREATED).entity("right added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
			
	
}
