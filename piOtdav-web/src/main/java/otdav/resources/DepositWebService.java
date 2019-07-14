package otdav.resources;


import javax.ejb.EJB;

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

import piotdav.entities.Deposit;
import piotdav.implement.DepositService;
import piotdav.implement.RightService;
import piotdav.services.IDepositService;
import piotdav.services.IRightService;


@ManagedBean
@RequestScoped
@Path("deposit")
public class DepositWebService {

	
	@EJB
	private IDepositService metier = new DepositService();

	 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe(){
		String var ="Hello";
		return Response.status(Status.OK).entity(var).build();
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddDeposit(Deposit deposit) {
		
		if (metier.addDeposit(deposit)== true) {

			return Response.status(Status.CREATED).entity("Deposit added").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateDeposit(Deposit deposit) {
		
		if (metier.updateDeposit(deposit)==true) {

			return Response.status(Status.OK).entity("Deposit updated").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	
	@PUT
	@Path("renewal")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response renewalDeposit(Deposit deposit) {
		
		if (metier.renewalDeposit(deposit)== true) {

		return Response.status(Status.OK).entity("Deposit renewaled").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Path("revoce")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response revocDeposit(Deposit deposit) {
		
		if (metier.revocDeposit(deposit.getIdDeposit()) == 1)  {

			return Response.status(Status.OK).entity("Deposit revoced").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	
	@DELETE
	@Path("deleteDep")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDeposit(Deposit idDeposit) {
		
		if (metier.deleteDeposit(idDeposit.getIdDeposit()) == 1) {

			return Response.status(Status.OK).entity("Deposit deleted").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
		
	

	}
	
	
	
	@GET
	@Path("alldeposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeposit(){
		
		 return Response.ok(metier.getDeposit(), MediaType.APPLICATION_JSON).build();

	}
	
	@GET
	@Path("depositbyAdherent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDepositbyadherent(@QueryParam(value="adherent")int idUser){
		
	 return Response.ok(metier.getDepositByAdherent(idUser), MediaType.APPLICATION_JSON).build();

	}
	
	
	
	@GET
	@Path("depositbyCategoriet")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDepositbycategorie(@QueryParam(value="categoryDeposit")int categoryDeposit){
		
		 return Response.ok(metier.getDepositByCategorie(categoryDeposit), MediaType.APPLICATION_JSON).build();

	}
	
}
