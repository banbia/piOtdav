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

import org.jboss.logging.Param;

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
		return Response.ok(metier.getAllUser().toString(), MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response Login(@QueryParam("login")String login,@QueryParam("password") String password ){
		return Response.ok(metier.login(login, password).toString(), MediaType.APPLICATION_JSON).build();
	}
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterUser(User user) {
		
		if (metier.addUser(user) == true) {

			return Response.status(Status.CREATED).entity("user added").build();
		}
//
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(User u) {
	if (metier.deleteUser(u.getIdUser()) == true) {
			return Response.status(Status.OK).entity("deleted").build();
		}
	return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@PUT
	@Path("modif")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifierUser(User user) {
		if (metier.updateUser(user.getIdUser()) == true) {

		return Response.status(Status.OK).entity("modification faite").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).entity(user.getIdUser()).build();

	}
}
