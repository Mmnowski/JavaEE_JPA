package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Buyer;
import com.example.restejbjpa.domain.Movie;
import com.example.restejbjpa.domain.MovieCategory;
import com.example.restejbjpa.domain.Studio;
import com.example.restejbjpa.service.MovieManager;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

@Path("/movie")
public class MovieRestService {

	@EJB
	MovieManager mm;

	@PersistenceContext
	EntityManager em;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovie(Movie movie) {
		mm.addMovie(movie);
		return Response.status(Response.Status.CREATED).build();
	}


	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovie(@PathParam("id") Long id){
		return mm.getMovie(id);
	}


	@GET
	@Path("/query/yor/{yor}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovieByYor(@PathParam("yor") int yor){
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = qb.createQuery(Movie.class);

		Root<Movie> m = cq.from(Movie.class);

		Predicate condition = qb.gt(g.get(Movie_.yearOfRelease), yor);
		cq.where(condition);

		TypedQuery<Movie> q = em.createQuery(cq);

		return q.getResultList();
	}

	@GET
	@Path("/query/movie.findByBuyer/{firstName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBuyerMovies(@PathParam("firstName") String firstName){

		List<Object[]> rawMovies = mm.getMovieOfAuthorByAuthorName(firstName);
		JsonArrayBuilder movies = Json.createArrayBuilder();

		for(Object[] rawMovie: rawMovies){

			String fName = (String) rawMovie[0];
			String lName = (String) rawMovie[1];
			String title = (String) rawMovie[2];

			movies.add(Json.createObjectBuilder()
					.add("firstName", fName)
					.add("lastName", lName)
					.add("title", title));
		}

		JsonObject json =  Json.createObjectBuilder().add("result", movies).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll(){
		return mm.getAll();
	}

	@DELETE
	public Response deleteMovie(){
		mm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}

}
