package com.library.resources;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.database.sample.CreateSampleDatabaseAndTables;
import com.library.database.sample.FillSampleDBWithData;

@Path("/sample")
public class SampleDatabaseResource {
	
	@Path("/sampleDatabase")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDatabase() {
		try {
			CreateSampleDatabaseAndTables sampleDB = new CreateSampleDatabaseAndTables();
			FillSampleDBWithData fillDB = new FillSampleDBWithData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Response.created(null).entity("database created").build();
	}
}
