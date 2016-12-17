/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a435.dao;

import javax.persistence.EntityManager;
import com.a435.model.Card;

/**
 *
 * @author jerome
 */
public class CardDao {
    
     public void create(Card card) throws Throwable {
        EntityManager em = Util.obtenirEntityManager();
        try {
            em.persist(card);
        }
        catch(Exception e) {
            throw e;
        }
    }
    
    public Card update(Card card) throws Throwable {
        EntityManager em = Util.obtenirEntityManager();
        try {
            card = em.merge(card);
        }
        catch(Exception e){
            throw e;
        }
        return card;
    }
    
    public Card findById(Long id) throws Throwable {
        EntityManager em = Util.obtenirEntityManager();
        Card card = null;
        try {
            card = em.find(Card.class, id);
        }
        catch(Exception e) {
            throw e;
        }
        return card;
    }
    
}
