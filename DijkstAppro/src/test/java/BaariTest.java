/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Baari;
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
public class BaariTest {
    private Baari baari;
    public BaariTest() {
        this.baari = new Baari(5,3,0);
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
    public void xKoordinaattiOikein() {
        assertEquals(5,baari.getX());
    }
    @Test
    public void yKoordinaattiOikein() {
        assertEquals(3,baari.getY());
    }
    @Test
    public void idOikein() {
        assertEquals(0,baari.getId());
    }

}
