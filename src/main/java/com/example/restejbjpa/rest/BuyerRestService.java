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
import java.util.ArrayList;
import java.util.List;

@Path("/buyer")
public class BuyerRestService {

	@EJB
	BuyerManager bm;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBuyer(Buyer buyer) {
		bm.addBuyer(buyer);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Buyer getBuyer(@PathParam("id") Long id) {
		return bm.getBuyer(id);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Buyer> getAll() {
		return bm.getAll();
	}

	@DELETE
	public Response deleteBuyer() {
		bm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}

}