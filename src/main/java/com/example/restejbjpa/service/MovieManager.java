package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Movie;

@Stateless
public class MovieManager {

	@PersistenceContext
	EntityManager em;

	public void addMovie(Movie movie){
		em.persist(movie);
	}

	public Movie getMovie(Long id){
		return em.find(Movie.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getMovieOfAuthorByAuthorName(String firstName){
		return em.createNamedQuery("movie.findByAuthorFirstName").setParameter("firstName", firstName).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAll(){

	  return em.createNamedQuery("movie.all").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findByYor(int yor){
		return em.createNamedQuery("movie.findByYor").setParameter("yearOfRelease", yor).getResultList();
	}

	public void deleteAll(){

	  em.createNamedQuery("movie.deleteAll").executeUpdate();
	}

}
