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
		refreshCities();
	}
	
	private void refreshCities() {
		cities = citiesData.getAllCities();
	}

	public List<City> getAllCities() {
		return new ArrayList<City>(cities.values());
	}
	
	public City getCity(long id) {
		City city = cities.get(id);
		return city;
	}
	
	public City addCity(City city) {
		citiesData.addCity(city);
		refreshCities();
		return city;
	}

	public City updateCity(City city) {
		if (city.getCityId() <= 0) {
			return null;
		}
		citiesData.updateCity(city);
		return city;
	}
	
//	Cities cannot be deleted
//	public City deleteCity(long id) {
//		database action
//		return cities.remove(id);
//	}
}
