package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.MovieCategory;

import com.example.restejbjpa.service.MovieManager;
import com.example.restejbjpa.service.MovieCategoryManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/category")
public class MovieCategoryRestService {

	@EJB
	MovieManager mm;

	@EJB
  	MovieCategoryManager mcm;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovieCategory(MovieCategory movieCategory) {
		mcm.addMovieCategory(movieCategory);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MovieCategory getMovieCategory(@PathParam("id") Long id) {
		return mcm.getMovieCategory(id);
	}


	@GET
	@Produces(MediaTypec.APPLICATION_JSON)
	public List<MovieCategory> getAll() {
		return mcm.getAll();
	}

	@DELETE
	public Response deleteGame() {
		mcm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}
}