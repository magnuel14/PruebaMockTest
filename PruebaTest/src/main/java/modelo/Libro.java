/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sebastian
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Libro extends Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(length = 20)
    private String isbn;
    private int nro_hojas;
    @Override
    public String toString() {
        return "Autor(es): " + getAutores() + " titulo: " + getTitulo();
    }

}
