/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Astar;
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
public class AstarTest {
    private Astar aStar;
    public AstarTest() throws FileNotFoundException {
        this.aStar = new Astar(new Kartta("esim1.txt"));
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
    public void yksiOikealleEtaisyysOikein() {
        assertEquals(10,aStar.aStar(new Koordinaatti(1,1,0), new Koordinaatti(2,1,0)));
    }
    
    @Test
    public void yksiVinoonEtaisyysOikein() {
        assertEquals(14,aStar.aStar(new Koordinaatti(1,1,0), new Koordinaatti(2,2,0)));
    }
    
    @Test
    public void aloituksestaLopetuksestaOikein() {
        assertEquals(86,aStar.aStar(new Koordinaatti(1,1,0), new Koordinaatti(8,3,0)));
    }
    
    @Test
    public void abOikein() {
        assertEquals(24,aStar.aStar(new Koordinaatti(1,1,0), new Koordinaatti(3,2,0)));
    }
    
    @Test
    public void bcOikein() {
        assertEquals(48,aStar.aStar(new Koordinaatti(3,2,0), new Koordinaatti(6,3,0)));
    }
    
    @Test
    public void acOikein() {
        assertEquals(72,aStar.aStar(new Koordinaatti(1,1,0), new Koordinaatti(6,3,0)));
    }
}
