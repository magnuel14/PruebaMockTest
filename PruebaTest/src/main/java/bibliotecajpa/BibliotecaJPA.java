/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecajpa;

import controlador.Conexion;
import controlador.Dao.DaoBiblioteca;
import controlador.Dao.DaoLibro;

/**
 *
 * @author sebastian
 */
public class BibliotecaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Conexion.getEM();
        DaoBiblioteca db = new DaoBiblioteca();
        db.getBiblioteca().setFacultad("FSH");
        db.getBiblioteca().setNombre("Biblioteca de salud");
        DaoLibro dl = new DaoLibro();
        dl.getLibro().setAutores("Larrea y Novillo");
        dl.getLibro().setBiblioteca(db.getBiblioteca());
        dl.getLibro().setClasificacion("M-S-M");
        dl.getLibro().setIsbn("099-M-EC");
        dl.getLibro().setNro_hojas(230);
        dl.getLibro().setNro_inventario(1);
        dl.getLibro().setResumen("Lenin Moreno");
        dl.getLibro().setTitulo("No hay texto");
        db.getBiblioteca().getListaDoc().add(dl.getLibro());
        if(db.guardar()) {
            System.out.println("Se ha guardado");
        } else {
            System.out.println("No se ha guardado");
        }
        
        DaoBiblioteca db1 = new DaoBiblioteca();
        db1.setBiblioteca(db1.obtener(1L));
        db1.getBiblioteca().setNombre("Biblioteca sin texto");
        if(db1.guardar()) {
            System.out.println("Se ha modificado");
        } else {
            System.out.println("No se ha modificado");
        }
    }
    
}
