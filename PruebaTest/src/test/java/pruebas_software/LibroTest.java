/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas_software;

import controlador.Conexion;
import controlador.Dao.DaoLibro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import controlador.excepciones.DatosFaltantesException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import junit.framework.Assert;
import modelo.Libro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author magnuel
 */
@RunWith(PowerMockRunner.class)
@PowerMockIgnore("java.sql.*")
public class LibroTest {

    private Conexion conexion;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private Statement st;
    private DaoLibro dl;
    private Libro libro;

    @Before
    public void setUp() {
        conexion = Mockito.mock(Conexion.class);//obejto falso
        dl = Mockito.spy(new DaoLibro());
        libro = new Libro();
        libro.setIsbn("isb-1234");
        libro.setNro_hojas(300);
    }

    @Test
    public void insertarTest() throws Exception {
        Mockito.when(dl.getLibro()).thenReturn(libro);
        assertTrue(dl.guardar());
    }

    @Test(expected = NullPointerException.class)
    public void insertarTestDatosNulos() throws Exception {
        DaoLibro dl2 = Mockito.spy(new DaoLibro());
        Libro libro2 = new Libro();
        libro2.setIsbn("");
        libro2.setNro_hojas(0);
        dl2.guardar();
    }

    @Test(expected = DatosFaltantesException.class)
    public void insertarTestDatosFalt() throws Exception {
        libro.setIsbn("");
        Mockito.when(dl.getLibro()).thenReturn(libro);
        dl.guardar();
    }

    @Test
    public void ediarTest() throws Exception {
        libro.setNro_hojas(500);
        Mockito.when(dl.getLibro()).thenReturn(libro);
        dl.modificar(libro);
    }

    @Test(expected = DatosFaltantesException.class)
    public void ediarSinNumeroHTest() throws Exception {
        libro.setIsbn("isb-567");
        Mockito.when(dl.getLibro()).thenReturn(libro);
        dl.modificar(libro);
    }

    @Test(expected = DatosFaltantesException.class)
    public void ediarISBNTest() throws Exception {
        libro.setNro_hojas(700);
        Mockito.when(dl.getLibro()).thenReturn(libro);
        dl.modificar(libro);
    }

    @Test
    public void getLibro() throws SQLException {
        Mockito.when(dl.getLibro()).thenReturn(libro);
    }
       @Test
     public void listarTest() throws SQLException {
        Mockito.when(dl.listar());
        List<Libro> lista = dl.listar();
        // System.out.println(lista.toString());
        Assert.assertEquals(lista.toString(),"[Rodny Jesus, Brayan Guaman]");
     }
}
