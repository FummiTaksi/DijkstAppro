/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Baari;
import com.mycompany.dijkstappro.Kartta;
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
public class KarttaTest {
    private Kartta kartta;
    public KarttaTest() throws FileNotFoundException {
        this.kartta = new Kartta("karttaTesti.txt");
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
    
    @Test
    public void karttaOikeassaMuodossa() {
        String oikea = "##a##" + "\n" + "####l" +"\n";
        assertEquals(oikea,kartta.getTarkistus());
    }
    
    @Test
    public void paikkojenMaaraOikea() {
        assertEquals(2,kartta.getPaikkojenLkm());
    }
    
    @Test
    public void aloituspaikanXOikein() {
       assertEquals(2,kartta.getBaarit()[0].getX());
    }
    
    @Test
    public void aloituspaikanYoikein() {
        assertEquals(0,kartta.getBaarit()[0].getY());
    }
    
//    @Test
//    public void aloituspaikanKirjainoikein() {
//        assertEquals("a",kartta.getBaarit()[0].toString());
//    }
    
    @Test
    public void lopetuspaikanXOikein() {
        assertEquals(4,kartta.getBaarit()[1].getX());
    }
    
    @Test
    public void lopetuspaikanYOikein() {
        assertEquals(1,kartta.getBaarit()[1].getY());
    }
    
//    @Test
//    public void lopetuspaikanKirjainoikein() {
//        assertEquals("l",kartta.getBaarit()[1].toString());
//    }
    
    
}
