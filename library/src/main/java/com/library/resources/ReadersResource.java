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

import com.library.resources.model.Reader;
import com.library.resources.service.ReaderService;

/**
 * Reader resource for REST API, handles HTTP requests
 */
@Path("/readers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReadersResource {

//	Service to handle requests from REST API and communicate with database
	ReaderService readersService = new ReaderService();
	
	@GET
	public List<Reader> getAllReaders(){
		return readersService.getAllReaders();
	}
	
	@GET
	@Path("/{readerId}")
	public Reader getReader(@PathParam("readerId") long readerId) {
		Reader reader = readersService.getReader(readerId);
		return reader;
	}
	
	@POST
	public Response addBook(Reader reader) {
		readersService.addReader(reader);
		return Response.created(null).entity(reader).build();
	}
	
	@PUT
	@Path("/{readerId}")
	public Reader updateReader(@PathParam("readerId") long readerId, Reader reader) {
		reader.setId(readerId);
		return readersService.updateReader(reader);
	}
	
	@DELETE
	@Path("/{readerId}")
	public Response deleteReader(@PathParam("readerId") long readerId) {
		if (readersService.deleteReader(readerId) == null) {
			return Response.status(409).entity("reader already archiwed").build();
		} else
			return Response.ok().entity("reader archiwed").build();
	}
}
