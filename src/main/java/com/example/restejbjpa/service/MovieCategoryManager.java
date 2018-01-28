package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.MovieCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MovieCategoryManager {

    @PersistenceContext
    EntityManager em;

    public void addMovieCategory(MovieCategory movieCategory){
        em.persist(movieCategory);
    }

    public MovieCategory getMovieCategory(Long id){
        return em.find(MovieCategory.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<MovieCategory> getAll(){

        return em.createNamedQuery("moviecategory.all").getResultList();
    }

    public void deleteAll(){
        em.createNamedQuery("moviecategory.deleteAll").executeUpdate();
    }

}
