package otdav.resources;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import piotdav.entities.CategoryUser;
import piotdav.entities.Right;
import piotdav.implement.CategoryUserService;
import piotdav.services.ICategoryUserService;

@ManagedBean
@RequestScoped
@Path("categoriesUser")
public class CategoryUserServices {
	@EJB
	private ICategoryUserService metier = new CategoryUserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		return Response.status(Status.OK).entity("categoriesUser").build();
	}
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjoutercategoriesUser(CategoryUser categoriesUser) {

		if (metier.addCategoryUser(categoriesUser)== true) {

			return Response.status(Status.CREATED).entity(categoriesUser.getLibele()).build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	 @PUT
		@Path("update")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response UpdateCategoryUser(CategoryUser categoryUser) {
			
			if (metier.updateCategoryUser(categoryUser)!= null) {

				return Response.status(Status.OK).entity("categoryUserService updated").build();
			}

			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
}
