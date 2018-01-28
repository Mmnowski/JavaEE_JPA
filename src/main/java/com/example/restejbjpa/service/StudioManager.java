package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.Studio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudioManager {

    @PersistenceContext
    EntityManager em;

    public void addStudio(Studio studio){
        em.persist(studio);
    }

    public Studio getStudio(Long id){
        return em.find(Studio.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Studio> getAll(){

        return em.createNamedQuery("studio.all").getResultList();
    }

    public void deleteAll(){
        em.createNamedQuery("studio.deleteAll").executeUpdate();
    }
}
