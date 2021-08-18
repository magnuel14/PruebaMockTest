/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sebastian
 */
public class Conexion {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    private static void conexion() {
        if(em == null) {
            emf = Persistence.createEntityManagerFactory("ministrosPU");
            em = emf.createEntityManager();
        }
            
    }
    
    public static EntityManager getEM() {
        conexion();
        return em;
    }
    
}
