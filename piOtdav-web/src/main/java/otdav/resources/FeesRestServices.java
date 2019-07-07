package otdav.resources;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import piotdav.entities.Fees;
import piotdav.implement.FeesService;
import piotdav.services.IFeesService;



@ManagedBean
@RequestScoped
@Path("feeses")
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
		fees.setUser(null);
		if (metier.addFees(fees) == true) {

			return Response.status(Status.CREATED).entity("fees added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
}
