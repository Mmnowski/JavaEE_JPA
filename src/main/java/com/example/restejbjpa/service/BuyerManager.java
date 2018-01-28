package com.example.restejbjpa.service;

import com.example.restejbjpa.domain.Buyer;
import com.example.restejbjpa.domain.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BuyerManager {
    
    @PersistenceContext
    EntityManager em;

    public void addBuyer(Buyer buyer) {
        em.persist(buyer);
    }

    public Buyer getBuyer(Long id) {
        return em.find(Buyer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Buyer> getAll() {

        return em.createNamedQuery("buyer.all").getResultList();
    }

    public void deleteAll() {
        em.createNamedQuery("buyer.deleteAll").executeUpdate();
    }
}
