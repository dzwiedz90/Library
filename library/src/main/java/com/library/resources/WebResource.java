package com.library.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class WebResource {
	@Context
    ServletContext servletContext;
	
	@GET
	public FileInputStream doGet() {
		String base = servletContext.getRealPath("/www/index.html");
		File html = new File(base);
		try {
			return new FileInputStream(html);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
