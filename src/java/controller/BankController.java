/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author syst3m
 */
public class BankController {
      @PersistenceContext(unitName = "Web-Services-hw3-BankPU")
    private EntityManager em;
    
}
