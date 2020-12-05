package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.cities.CitiesData;
import com.library.resources.model.City;

public class CityService {
	CitiesData citiesData = new CitiesData();
	private Map<Long, City> cities;

	public CityService() {
		cities = citiesData.getAllCities();
	}

	public List<City> getAllBooks() {
		return new ArrayList<City>(cities.values());
	}
	
	public City getBook(long id) {
		City city = cities.get(id);
		return city;
	}
	
	public City addBook(City city) {
//		message.setId(messages.size() + 1);
//		messages.put(message.getId(), message);
//		database action
		return city;
	}
	
	public City updateBook(City city) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		database action
		return city;
	}
	
	public City deleteBook(long id) {
//		database action
		return cities.remove(id);
	}
}
