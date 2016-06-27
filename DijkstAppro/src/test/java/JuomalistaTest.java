/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Juomalista;
import com.mycompany.dijkstappro.Kartta;
import com.mycompany.dijkstappro.Koordinaatti;
import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mustonea
 */
public class JuomalistaTest {

    private Juomalista lista;

    public JuomalistaTest() throws FileNotFoundException {
        this.lista = new Juomalista("esim2juomat.txt", new Kartta("esim2.txt"));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public void esim3TestAlustus() throws FileNotFoundException {
        lista = new Juomalista("esim3juomat.txt",new Kartta("esim3.txt"));
    }
    @Test
    public void dEnsimmainen() {
        assertEquals(new Koordinaatti(3, 1, 1),lista.palautaHalvimmat(4)[0]);
    }
    
    @Test
    public void aToinen() {
        assertEquals(new Koordinaatti(1,5,2),lista.palautaHalvimmat(4)[1]);
    }
    
    @Test
    public void bKolmas() {
        assertEquals(new Koordinaatti(4,5,3),lista.palautaHalvimmat(4)[2]);
    }
    
    @Test
    public void cNeljas() {
        assertEquals(new Koordinaatti(6,5,7),lista.palautaHalvimmat(4)[3]);
    }
    
    @Test
    public void dViides() {
        assertEquals(new Koordinaatti(5,8,8),lista.palautaHalvimmat(5)[4]);
    }
    @Test
    public void esim3eOikein() throws FileNotFoundException {
        esim3TestAlustus();
        assertEquals(new Koordinaatti(13,2,1),lista.palautaHalvimmat(3)[0]);
    }
    @Test
    public void esim3bOikein() throws FileNotFoundException {
        esim3TestAlustus();
        assertEquals(new Koordinaatti(1,1,2),lista.palautaHalvimmat(3)[1]);
    }
    @Test
    public void esim3cOikein() throws FileNotFoundException {
        esim3TestAlustus();
        assertEquals(new Koordinaatti(13,1,3),lista.palautaHalvimmat(3)[2]);
    }
    @Test
    public void esim3dOikein() throws FileNotFoundException {
        esim3TestAlustus();
        assertEquals(new Koordinaatti(1,2,3),lista.palautaHalvimmat(3)[3]);
    }
   
}
