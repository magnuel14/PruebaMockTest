/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Revista extends Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Column(length = 20)
    private String issn;
    private int nro_articulos;
    @Temporal(TemporalType.DATE)
    private Date fecha_publicacion;
    
    @Override
    public String toString() {
        return "Autores " + getAutores()+" titulo: "+getTitulo()+" issn: "+issn;
    }
    
}
