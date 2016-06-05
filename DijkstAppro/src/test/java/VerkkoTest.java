/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Kartta;
import com.mycompany.dijkstappro.Verkko;
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
public class VerkkoTest {
    
    private Verkko verkko;
    
    public VerkkoTest() throws FileNotFoundException {
        this.verkko = new Verkko(new Kartta("esim1.txt"));
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
    public void alOikein1() {
        assertEquals(86,verkko.muodostaVerkko()[0][3]);
    }
    
    @Test
    public void alOikein2() {
        assertEquals(86,verkko.muodostaVerkko()[3][0]);
    }
    
    @Test
    public void acOikein1() {
        assertEquals(72,verkko.muodostaVerkko()[0][2]);
    }
    
    @Test
    public void acOikein2() {
        assertEquals(72,verkko.muodostaVerkko()[2][0]);
    }
    
    @Test
    public void abOikein1() {
        assertEquals(24,verkko.muodostaVerkko()[0][1]);
    }
    
    @Test
    public void abOikein2() {
        assertEquals(24,verkko.muodostaVerkko()[1][0]);
    }
    
    @Test
    public void bcOikein1() {
        assertEquals(48,verkko.muodostaVerkko()[1][2]);
    }
    
    @Test
    public void bcOikein2() {
        assertEquals(48,verkko.muodostaVerkko()[2][1]);
    }
    
    @Test
    
    public void esim2adOikein1() throws FileNotFoundException {
        verkko.setKartta(new Kartta("esim2.txt"));
        assertEquals(48,verkko.muodostaVerkko()[0][1]);
    }
    
}
