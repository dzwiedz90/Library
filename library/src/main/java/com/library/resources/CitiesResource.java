package com.library.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.resources.model.City;
import com.library.resources.service.CityService;

/**
 * City resource for REST API, handles HTTP requests
 */
@Path("/cities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CitiesResource {

	// Service to handle requests from REST API and communicate with database
		CityService citiesService = new CityService();

		@GET
		public List<City> getAllCities() {
			return citiesService.getAllCities();
		}
		
		@GET
		@Path("/{cityId}")
		public City getCity(@PathParam("cityId") long cityId) {
			City city = citiesService.getCity(cityId);
			return city;
		}
		
		@POST
		public Response addCity(City city) {
			citiesService.addCity(city);
			return Response.created(null).entity(city).build();
		}
		
		@PUT
		@Path("/{cityId}")
		public City updateCity(@PathParam("cityId") long cityId, City city) {
			city.setCityId(cityId);
			return citiesService.updateCity(city);
		}
}
