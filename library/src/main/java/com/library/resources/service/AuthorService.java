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
		refreshData();
	}
	
	private void refreshData() {
		authors = authorsData.getAllAuthors();
	}
	
	public List<Author> getAllAuthors(){
		return new ArrayList<Author>(authors.values());
	}
	
	public Author getAuthor(long id) {
		Author author = authors.get(id);
		return author;
	}
	
	public Author addAuthor(Author author) {
		authorsData.addAuthor(author);
		refreshData();
		return author;
	}
	
	public Author updateAuthor(Author author) {
		authorsData.updateAuthor(author);
		refreshData();
		return author;
	}
	
	public Author deleteAuthor(long id) {
		if (authors.get(id).getIsArchiwed() == false) {
			authorsData.deleteAuthor(id);
			refreshData();
			return authors.remove(id);
		} else
			return null;
	}
}
