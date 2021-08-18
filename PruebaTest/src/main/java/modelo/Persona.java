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
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10)
    private String cedula;
    @Column(length = 50)
    private String apellidos;
    @Column(length = 50)
    private String nombres;
    private String direccion;
    @Column(length = 15)
    private String telefono;
    

    @Override
    public String toString() {
        return "modelo.Persona[ id=" + id + " ]";
    }
    
}
