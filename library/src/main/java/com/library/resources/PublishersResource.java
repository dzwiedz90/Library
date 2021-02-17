package com.library.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.resources.model.Book;
import com.library.resources.model.Publisher;
import com.library.resources.service.PublisherService;

@Path("/publishers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublishersResource {
	// Service to handle requests from REST API and communicate with database
		PublisherService publishersService = new PublisherService ();

		@GET
		public List<Publisher> getAllPublishers() {
			return publishersService.getAllPublishers();
		}
		
		@GET
		@Path("/{publisherId}")
		public Publisher getPublisher(@PathParam("publisherId") long publisherId) {
			Publisher publisher = publishersService.getPublisher(publisherId);
			return publisher;
		}
		
		@POST
		public Response addPublisher(Publisher publisher) {
			publishersService.addPublisher(publisher);
			return Response.created(null).entity(publisher).build();
		}

		@PUT
		@Path("/{publisherId}")
		public Publisher updatePublisher(@PathParam("publisherId") long publisherId, Publisher publisher) {
			publisher.setId(publisherId);
			return publishersService.updatePublisher(publisher);
		}

		@DELETE
		@Path("/{publisherId}")
		public Response deletePublisher(@PathParam("publisherId") long publisherId) {
			if (publishersService.deletePublisher(publisherId) == null) {
				return Response.status(409).entity("publisher already archiwed").build();
			} else
				return Response.ok().entity("publisher archiwed").build();
		}
}
