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

import com.library.resources.model.Author;
import com.library.resources.service.AuthorService;

/**
 * Author resource for REST API, handles HTTP requests
 */
@Path("/authors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorsResource {

//		Service to handle requests from REST API and communicate with database
		AuthorService authorsService = new AuthorService();

		@GET
		public List<Author> getAllAuthors() {
			return authorsService.getAllAuthors();
		}
		
		@GET
		@Path("/{authorId}")
		public Author getAuthor(@PathParam("authorId") long authorId) {
			Author author= authorsService.getAuthor(authorId);
			return author;
		}
		
		@POST
		public Response addAuthor(Author author) {
			authorsService.addAuthor(author);
			return Response.created(null).entity(author).build();
		}

		@PUT
		@Path("/{authorId}")
		public Author updateAuthor(@PathParam("authorId") long authorId, Author author) {
			author.setId(authorId);
			return authorsService.updateAuthor(author);
		}

		@DELETE
		@Path("/{authorId}")
		public Response deleteAuthor(@PathParam("authorId") long authorId) {
			if (authorsService.deleteAuthor(authorId) == null) {
				return Response.status(409).entity("author already archiwed").build();
			} else
				return Response.ok().entity("author archiwed").build();
		}
}
