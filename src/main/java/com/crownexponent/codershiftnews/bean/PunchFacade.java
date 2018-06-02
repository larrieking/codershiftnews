/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crownexponent.codershiftnews.bean;


import com.codershift.entity.Punch;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ISSAH OJIVO
 */
@Stateless
public class PunchFacade extends AbstractFacade<Punch> {

    @PersistenceContext(unitName = "com.crownexponent_CoderShiftNews_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PunchFacade() {
        super(Punch.class);
    }
    
    
    public void createNewsItem(Punch punch){
        super.create(punch);
    }
    
}
