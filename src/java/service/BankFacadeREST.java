/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Bank;

/**
 *
 * @author syst3m
 */
@Stateless

@Path("/bank")
public class BankFacadeREST extends AbstractFacade<Bank> {
    @PersistenceContext(unitName = "Web-Services-hw3-BankPU")
    private EntityManager em;

    public BankFacadeREST() {
        super(Bank.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Bank entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Bank entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bank find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Path("/pay")
    @Produces({MediaType.APPLICATION_JSON})
    public String pay(String name){
        System.out.println("name " + name.length());
        Bank bank = em.find(Bank.class, "saman");
        
        if(bank == null){
            return "false";
        }
        return "true";
    }


    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bank> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bank> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
