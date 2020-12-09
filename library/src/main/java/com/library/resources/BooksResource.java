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
import com.library.resources.service.BookService;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {

	BookService booksService = new BookService();

	@GET
	public List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GET
	@Path("/{bookId}")
	public Book getMessage(@PathParam("bookId") long bookId) {
		Book book = booksService.getBook(bookId);
		return book;
	}

	@POST
	public Response addBook(Book book) {
		booksService.addBook(book);
		return Response.created(null).entity(book).build();
	}

	@PUT
	@Path("/{bookId}")
	public Book updateBook(@PathParam("bookId") long bookId, Book book) {
		book.setId(bookId);
		return booksService.updateBook(book);
	}

	@DELETE
	@Path("/{bookId}")
	public Response deleteBook(@PathParam("bookId") long bookId) {
		if (booksService.deleteBook(bookId) == null) {
			return Response.status(409).entity("book archiwed or borrowed").build();
		} else
			return Response.ok().entity("book archiwed").build();
	}
}
