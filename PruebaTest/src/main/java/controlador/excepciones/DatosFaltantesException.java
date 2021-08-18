/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.excepciones;

/**
 *
 * @author sebitas
 */
public class DatosFaltantesException extends Exception {

    /**
     * Creates a new instance of <code>DatosFaltantesException</code> without
     * detail message.
     */
    public DatosFaltantesException() {
    }

    /**
     * Constructs an instance of <code>DatosFaltantesException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DatosFaltantesException(String msg) {
        super(msg);
    }
}
