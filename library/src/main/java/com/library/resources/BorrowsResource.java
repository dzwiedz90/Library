package com.library.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.resources.model.Borrow;
import com.library.resources.service.BorrowService;

@Path("/borrows")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BorrowsResource {

// 		Service to handle requests from REST API and communicate with database
		BorrowService borrowsService = new BorrowService();

		@GET
		public List<Borrow> getAllBorrows() {
			return borrowsService.getAllBorrows();
		}

		@GET
		@Path("/{borrowId}")
		public Borrow getBorrow(@PathParam("borrowId") long borrowId) {
			Borrow borrow = borrowsService.getBorrow(borrowId);
			return borrow;
		}
		
		@POST
		public Response addBorrow(Borrow borrow) {
			borrowsService.addBorrow(borrow);
			return Response.created(null).entity(borrow).build();
		}

		@PUT
		@Path("/{borrowId}")
		public Borrow updateBorrow(@PathParam("borrowId") long borrowId) {
			return borrowsService.updateBorrow(borrowId);
		}
}
