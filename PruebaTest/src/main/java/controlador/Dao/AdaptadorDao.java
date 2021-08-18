/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import controlador.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author sebastian
 */
public class AdaptadorDao <T> implements InterfazDao<T>{
    private Class clazz;
    private EntityManager em;

    public AdaptadorDao(Class clazz) {
        this.clazz = clazz;
        em = Conexion.getEM();
    }
    
    public EntityManager getEm() {
        return em;
    }
    
    @Override
    public void guardar(T obj) throws Exception {
        getEm().persist(obj);
    }

    @Override
    public void modificar(T obj) throws Exception {
        getEm().merge(obj);
        //getEm().refresh(obj);
    }

    @Override
    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        try {
            String query = "Select p from " + clazz.getSimpleName() + " p";
            lista = getEm().createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println("Hubo un error en el listar "+e);
        }
        return lista;
    }

    @Override
    public T obtener(Long id) {
        T obj = null;
        try {
            obj = (T) getEm().find(clazz, id);
        } catch (Exception e) {
            System.out.println("Error en obtener obj "+e);
        }
        return obj;
    }
    
    
    
    
}
