/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a435.model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jerome
 */

@Entity
public class Card {  
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToMany
    List<PlayerClass> belonging = new LinkedList<>();
    
    String name;
    
    public Card(String name) {
        this.name = name;
    }

    public List<PlayerClass> getBelonging() {
        return belonging;
    }

    public void setBelonging(List<PlayerClass> belonging) {
        this.belonging = belonging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", belonging=" + belonging + ", name=" + name + '}';
    }
    
    
}
