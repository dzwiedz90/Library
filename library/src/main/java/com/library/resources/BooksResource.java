package com.library.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.library.resources.model.Book;
import com.library.resources.service.BookService;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {
	
	BookService booksService = new BookService();
	
	@GET
	public List<Book> getAllBooks(){
		return booksService.getAllBooks();
	}
	
	@GET
	@Path("/{bookId}")
	public Book getMessage(@PathParam("bookId") long bookId) {
		Book book =  booksService.getBook(bookId);
		return book;
	}
}
