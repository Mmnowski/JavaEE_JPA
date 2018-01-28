package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Studio;
import com.example.restejbjpa.service.StudioManager;

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

@Path("/studio")
public class StudioRestService {

	@EJB
  	StudioManager sm;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudio(Studio studio){
		sm.addStudio(studio);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Studio getStudio(@PathParam("id") Long id){
		return sm.getStudio(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Studio> getAll(){
		return sm.getAll();
	}

	@DELETE
	public Response deleteAll(){
		sm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}

}
