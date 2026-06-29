/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.sb;

import com.fpt.entity.LibraryCards;
import com.fpt.entity.Students;
import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author hp
 */
@Stateless
public class LibraryCardsFacade extends AbstractFacade<LibraryCards> implements LibraryCardsFacadeLocal {

    @PersistenceContext(unitName = "LibPU")
    private EntityManager em;

    @Override
    protected jakarta.persistence.EntityManager getEntityManager() {
        return em;
    }

    public LibraryCardsFacade() {
        super(LibraryCards.class);
    }

    @Override
    public List<LibraryCards> getLibCard() {
        return findAll();
    }

    @Override
    public List<Students> getStudent() {
       String sql = "SELECT s FROM Students s";
        TypedQuery<Students> query = em.createQuery(sql, Students.class);
        return query.getResultList();
    }

    @Override
    public void toggleStatus(LibraryCards card) {
        card.setStatus(card.getStatus() == null || !card.getStatus());
        edit(card);
    }

    @Override
    public void addLibCard(LibraryCards card) {
      create(card);
    }
    
}
