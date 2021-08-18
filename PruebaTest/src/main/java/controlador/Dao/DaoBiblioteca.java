/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Biblioteca;

/**
 *
 * @author sebastian
 */
public class DaoBiblioteca extends AdaptadorDao<Biblioteca> {
    private Biblioteca biblioteca;

    public DaoBiblioteca() {
        super(Biblioteca.class);
    }

    public Biblioteca getBiblioteca() {
        if(biblioteca == null)
            biblioteca = new Biblioteca();
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
    
    public boolean guardar() {
        boolean band = false;
        try {
            getEm().getTransaction().begin();
            if(biblioteca.getId() != null)
                modificar(biblioteca);
            else
                guardar(biblioteca);
            getEm().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("Error en guardar biblioteca "+e);
        }
        return band;
    }    
    
}
