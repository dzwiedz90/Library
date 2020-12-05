package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.publishers.PublishersData;
import com.library.resources.model.Publisher;

public class PublisherService {
	PublishersData publishersData = new PublishersData();
	private Map<Long, Publisher> publishers;

	public PublisherService() {
		publishers = publishersData.getAllPublishers();
	}

	public List<Publisher> getAllPublishers() {
		return new ArrayList<Publisher>(publishers.values());
	}
	
	public Publisher getBook(long id) {
		Publisher publisher = publishers.get(id);
		return publisher;
	}
	
	public Publisher addBook(Publisher publisher) {
//		message.setId(messages.size() + 1);
//		messages.put(message.getId(), message);
//		database action
		return publisher;
	}
	
	public Publisher updateBook(Publisher publisher) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		database action
		return publisher;
	}
	
	public Publisher deleteBook(long id) {
//		database action
		return publishers.remove(id);
	}
}