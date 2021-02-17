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
		refreshPublishersData();
	}
	
	private void refreshPublishersData() {
		publishers = publishersData.getAllPublishers();
	}

	public List<Publisher> getAllPublishers() {
		return new ArrayList<Publisher>(publishers.values());
	}
	
	public Publisher getPublisher(long id) {
		Publisher publisher = publishers.get(id);
		return publisher;
	}
	
	public Publisher addPublisher(Publisher publisher) {
		publishersData.addPublisher(publisher);
		refreshPublishersData();
		return publisher;
	}
	
	public Publisher updatePublisher(Publisher publisher) {
		if (publisher.getId() <= 0) {
			return null;
		}
		publishersData.updatePublisher(publisher);
		refreshPublishersData();
		return publisher;
	}
	
	public Publisher deletePublisher(long id) {
		if (publishers.get(id).getIsArchiwed() == false) {
			publishersData.deletePublisher(id);
			refreshPublishersData();
			return publishers.remove(id);
		} else
			return null;
	}
}
