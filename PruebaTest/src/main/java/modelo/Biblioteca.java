/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String nombre; 
    @Column(length = 100, name = "nombre_facultad")
    private String facultad;
    @OneToMany(mappedBy = "biblioteca", cascade = {CascadeType.ALL})
    private List<Documento> listaDoc = new ArrayList<>();

    @Override
    public String toString() {
        return "modelo.Biblioteca[ id=" + id + " ]";
    }
    
}
