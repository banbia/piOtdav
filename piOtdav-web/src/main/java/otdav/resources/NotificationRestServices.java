package otdav.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import piotdav.entities.Notification;
import piotdav.entities.User;
import piotdav.implement.NotificationService;
import piotdav.services.INotificationService;

@ManagedBean
@RequestScoped
@Path("notifs")
public class NotificationRestServices {
	@EJB
	private INotificationService metier = new NotificationService();

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AjouterRight(Notification notif) {
		
		if (metier.addNotification(notif) == true) {
			return Response.status(Status.CREATED).entity("right added").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteNotification(Notification notif) {
		if (metier.deleteNotification(notif.getIdNotification()) == true) {
			return Response.status(Status.OK).entity("deleted").build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@PUT
	@Path("lue")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response marquerLueNotification(Notification notif) {
		if (metier.marquerLueNotification(notif.getIdNotification()) == true) {

		return Response.status(Status.OK).entity("notif lue").build();
		}

		return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	@GET
	@Path("getNotif")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneNotif1(@QueryParam(value="idNotif")int idNotif){
		 return Response.ok(metier.getNotification(idNotif), MediaType.APPLICATION_JSON).build();

	}
	
	@GET
	@Path("listeAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNotifs(@QueryParam(value="idUser")int idUser){
		return Response.status(Status.OK).entity(metier.listNotification(idUser)).build();
//		 return Response.ok(metier.listNotification(idUser), MediaType.APPLICATION_JSON).build();

	}
	@GET
	@Path("listeAllNonLue")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNotifsNonLue(@QueryParam(value="idUser")int idUser){
		return Response.status(Status.OK).entity(metier.listNonLueNotification(idUser)).build();
//		 return Response.ok(metier.listNotification(idUser), MediaType.APPLICATION_JSON).build();

	}
}
