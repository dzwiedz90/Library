package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.authors.AuthorsData;
import com.library.resources.model.Author;

public class AuthorService {
	AuthorsData authorsData = new AuthorsData();
	private Map<Long, Author> authors;
	
	public AuthorService() {
		authors = authorsData.getAllAuthors();
	}
	
	public List<Author> getAllAuthors(){
		return new ArrayList<Author>(authors.values());
	}
	
	public Author getAuthor(long id) {
		Author author = authors.get(id);
		return author;
	}
	
	public Author addBook(Author author) {
//		message.setId(messages.size() + 1);
//		messages.put(message.getId(), message);
//		database action
		return author;
	}
	
	public Author updateBook(Author author) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		database action
		return author;
	}
	
	public Author deleteBook(long id) {
//		database action
		return authors.remove(id);
	}
}
