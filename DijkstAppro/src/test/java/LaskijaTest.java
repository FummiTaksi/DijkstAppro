/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Baari;
import com.mycompany.dijkstappro.Laskija;
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
public class LaskijaTest {
    private Laskija laskija;
    public LaskijaTest() {
        this.laskija = new Laskija();
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
    public void etaisyysLaskeeOikein() {
        assertEquals(5.0,laskija.laskeEtaisyys(new Baari("a",1,1), new Baari("b",4,5)),0.01);
    }
    @Test
    public void etaisyysAluksiNolla() {
        assertEquals(0.0,laskija.getEtaisyysTaulukko()[5][7],0.01);
    }
    
    @Test
    public void etaisyysAsetetaanOikein1() {
        laskija.laskeEtaisyys(new Baari("a",1,1), new Baari("b",4,5));
        assertEquals(5.0,laskija.getEtaisyysTaulukko()[11][45],0.01);
    }
    
    @Test
    public void etaisyysAsetetaanOikein2() {
        laskija.laskeEtaisyys(new Baari("a",1,1), new Baari("b",4,5));
        assertEquals(5.0,laskija.getEtaisyysTaulukko()[45][11],0.01);
    }
}
