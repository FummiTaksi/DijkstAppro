/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Baari;
import com.mycompany.dijkstappro.Jono;
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
public class JonoTest {
    private Jono jono;
    public JonoTest() {
        this.jono = new Jono();
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
    
    public void alustaTesti() {
        jono.lisaa(new Baari(1,1,1));
        jono.lisaa(new Baari(2,2,2));
    }
    @Test
    public void alussaTyhja() {
        assertTrue(jono.onTyhja());
    }
    
    @Test
    public void lisataanYksiEiOleTyhja() {
        jono.lisaa(new Baari(1,1,1));
        assertFalse(jono.onTyhja());
    }
    
    @Test
    public void poistetaanOikeaAlkio() {
        alustaTesti();
        assertTrue(jono.poistaEnsimmainen().equals(new Baari(1,1,1)));
    }
    
    @Test
    public void eiOlePoistonJalkeenTyhja() {
        alustaTesti();
        jono.poistaEnsimmainen();
        assertFalse(jono.onTyhja());
    }
    
    @Test
    public void poistetaanMolemmatOnTyhja() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        assertTrue(jono.onTyhja());
    }
    
    @Test
    public void poistetaanMolemmatLisataanYksiOikein() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        assertTrue(jono.poistaEnsimmainen().equals(new Baari(3,3,3)));
    }
    
    @Test
    public void lisataanYksiLisaaJaPoistetaanOikeaAlkio() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        assertTrue(jono.poistaEnsimmainen().equals(new Baari(2,2,2)));
    }
    
    @Test
    public void lisataanJaPoistetaanEiOleTyhja() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        jono.poistaEnsimmainen();
        assertFalse(jono.onTyhja());
    }
    
    @Test
    public void poistetaanViimeinenOnOikein() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        jono.poistaEnsimmainen();
        assertEquals(jono.poistaEnsimmainen(),new Baari(3,3,3));
    }
    @Test
    public void poistetaanViimeinenOnTyhja() {
        alustaTesti();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        assertTrue(jono.onTyhja());
    }
    
    @Test
    public void lisaysToimiiTyhjennyksenJalkeen() {
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        jono.lisaa(new Baari(3,3,3));
        assertTrue(jono.poistaEnsimmainen().equals(new Baari(3,3,3)));
    }
    
    @Test
    public void klooniEiOleTyhja() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        assertFalse(klooni.onTyhja());
    }
    @Test
    public void kloonausTuottaaOikean1() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        assertTrue(klooni.poistaEnsimmainen().equals(new Baari(1,1,1)));
    }
    @Test
    public void kloonausTuottaaOikean2() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        klooni.poistaEnsimmainen();
        assertTrue(klooni.poistaEnsimmainen().equals(new Baari(2,2,2)));
    }
    
    @Test
    public void kloonistaPoistaminenEiVaikutaAlkuperaiseen() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        klooni.poistaEnsimmainen();
        assertTrue(jono.poistaEnsimmainen().equals(new Baari(1,1,1)));
    }
    
    @Test
    public void AlkuperaisestaPoistaminenEiVaikutaKlooniin() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        jono.poistaEnsimmainen();
        assertTrue(klooni.poistaEnsimmainen().equals(new Baari(1,1,1)));
    }
    
    @Test
    public void klooniinLisaaminenEiLisaaAlkuperaiseen() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        klooni.lisaa(new Baari(3,3,3));
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        assertTrue(jono.onTyhja());
    }
    
    @Test
    public void alkuperaiseenLisaaminenEiLisaaKlooniin() {
        alustaTesti();
        Jono klooni = jono.kloonaa();
        jono.lisaa(new Baari(3,3,3));
        klooni.poistaEnsimmainen();
        klooni.poistaEnsimmainen();
        assertTrue(klooni.onTyhja());
    }
}
