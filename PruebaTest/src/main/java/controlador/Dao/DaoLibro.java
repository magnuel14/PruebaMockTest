/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Libro;

/**
 *
 * @author sebastian
 */
public class DaoLibro extends AdaptadorDao<Libro> {
    private Libro libro;

    public DaoLibro() {
        super(Libro.class);
    }

    public Libro getLibro() {
        if(libro == null)
            libro = new Libro();
        return libro;
    }
    
    public boolean guardar() {
        boolean band = false;
        try {
            getEm().getTransaction().begin();
            guardar(libro);
            getEm().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("Error en guardar libro "+e);
        }
        return band;
    }    
    
}
