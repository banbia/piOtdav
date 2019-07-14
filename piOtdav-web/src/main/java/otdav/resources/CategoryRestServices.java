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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import piotdav.entities.Category;
import piotdav.entities.Work;
import piotdav.implement.CategoryService;
import piotdav.services.ICategoryService;



@ManagedBean
@RequestScoped
@Path("categories")
public class CategoryRestServices {
	
	@EJB
	private ICategoryService metier = new CategoryService();
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterCategory(Category category) {
		
		if (metier.addCategory(category)== true)  {

			return Response.status(Status.CREATED).entity("Category added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCategory(Category category)
	{
			if(metier.removeCategory(category.getIdCategory()) == 1) {
				return Response.status(Status.OK).entity("deleted").build();
			}
			return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListeCategory(){
		return Response.ok(metier.findAllCategory(), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(Category category) {
		if (metier.updateCategory(category)) {

		return Response.status(Status.OK).entity("update succ").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}

}
