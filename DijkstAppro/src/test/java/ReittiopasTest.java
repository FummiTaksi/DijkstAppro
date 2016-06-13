/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Baari;
import com.mycompany.dijkstappro.Jono;
import com.mycompany.dijkstappro.Kartta;
import com.mycompany.dijkstappro.Reittiopas;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
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
public class ReittiopasTest {

    private Reittiopas opas;

    public ReittiopasTest() throws FileNotFoundException {
        this.opas = new Reittiopas(new Kartta("esim1.txt"));
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
    public void alustaTesti(String syote) throws FileNotFoundException {
        this.opas = new Reittiopas(new Kartta(syote));
        opas.haeReitti();
    }
    
    

    @Test
    public void ensimmainenPaikkaOikein() {
        Baari aloitusPaikka = new Baari(1, 1, 0);
        opas.haeReitti();
        assertTrue(aloitusPaikka.equals(opas.getJono().poistaEnsimmainen()));
    }

    @Test
    public void toinenPaikkaOikein() {
        Baari b = new Baari(3, 2, 1);
        opas.haeReitti();
        Jono jono = opas.getJono();
        jono.poistaEnsimmainen();
        assertTrue(b.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void kolmasPaikkaOikein() {
        Baari c = new Baari(6, 3, 2);
        opas.haeReitti();
        Jono jono = opas.getJono();
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        assertTrue(c.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void lopetusPaikkaOikein() {
        Baari lopetus = new Baari(8, 3, 3);
        opas.haeReitti();
        Jono jono = opas.getJono();
        for (int i = 1; i <= 3; i++) {
            jono.poistaEnsimmainen();
        }
        assertTrue(lopetus.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void esim1ReittiOikein() {
        opas.haeReitti();
        assertEquals(92, opas.getHalvimmanReitinHinta());
    }

    @Test
    public void esim2ReittiOikein() throws FileNotFoundException {
        alustaTesti("esim2.txt");
        assertEquals(180, opas.getHalvimmanReitinHinta());
    }
    
    @Test
    public void esim3ReittiOikein() throws FileNotFoundException {
        alustaTesti("esim3.txt");
        assertEquals(160,opas.getHalvimmanReitinHinta());
    }

    @Test
    public void vaikea1ReittiOikein() throws FileNotFoundException {
        alustaTesti("vaikea1.txt");
        assertEquals("amwuyreqbtl",opas.palautaReitti());
    }
    @Test
    public void vaikea1ReitinHintaOikein() throws FileNotFoundException {
        alustaTesti("vaikea1.txt");
        assertEquals(736,opas.getHalvimmanReitinHinta());
    }
}
