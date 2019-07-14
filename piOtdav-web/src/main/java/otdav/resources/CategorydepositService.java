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

import piotdav.entities.CategoryDeposit;
import piotdav.entities.Deposit;
import piotdav.implement.CategoryDepositSercive;
import piotdav.services.ICategoryDepositService;

;

@ManagedBean
@RequestScoped
@Path("categorydeposit")
public class CategorydepositService {
	
	
	@EJB
	private ICategoryDepositService metier = new CategoryDepositSercive();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		String var ="Hello";
		return Response.status(Status.OK).entity(var).build();
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddCategoryDeposit(CategoryDeposit C_deposit) {
		
		if (metier.addCategoryDeposit(C_deposit)== true) {

			return Response.status(Status.CREATED).entity("CategoryDeposit added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateCAtegoryDeposit(CategoryDeposit C_deposit) {
		
		if (metier.updateCategoryDeposit(C_deposit)== true) {

			return Response.status(Status.OK).entity("CategoryDeposit updated").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	
	@DELETE
	@Path("deleteD")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCategoryDeposit(CategoryDeposit C_deposit) {
		
		if (metier.deleteCategoryDeposit(C_deposit.getIdCategoryDeposit())== 1) {

			return Response.status(Status.OK).entity("CategoryDeposit deleted").build();
		}
			return Response.status(Status.NOT_ACCEPTABLE).build();
			
			//String var ="HelloDelete";
			//return Response.status(Status.OK).entity(var).build();

	}
	
	
	
	@GET
	@Path("allCategorydeposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryDeposit(){
		
		 return Response.ok(metier.getCategoryDeposit(), MediaType.APPLICATION_JSON).build();

	}

}
