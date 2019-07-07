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
import piotdav.entities.User;
import piotdav.implement.UserService;

import piotdav.services.IUserService;

@ManagedBean
@RequestScoped
@Path("users")
public class UserRestServices {
	@EJB
	private IUserService metier = new UserService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.status(Status.OK).entity("ok").build();
	}
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterUser(User user) {
		
		if (metier.addUser(user) == true) {

			return Response.status(Status.CREATED).entity("User Added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
}
