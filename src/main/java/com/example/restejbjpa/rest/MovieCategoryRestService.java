package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.MovieCategory;

import com.example.restejbjpa.service.MovieManager;
import com.example.restejbjpa.service.MovieCategoryManager;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieCategory> getAll() {
		return mcm.getAll();
	}

	@DELETE
	public Response deleteGame() {
		mcm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}
}