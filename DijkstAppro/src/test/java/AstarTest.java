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
    
    public void alustaVaikeaTesti() throws FileNotFoundException {
        aStar.setKartta(new Kartta("vaikea1.txt"));
    }
    
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
    
    @Test
    public void esim2adOikein1() throws FileNotFoundException {
        aStar.setKartta(new Kartta("esim2.txt"));
        assertEquals(48,aStar.aStar(new Koordinaatti(3,1,0), new Koordinaatti(1,5,0)));
    }
    
    @Test
    public void esim2adOikein2() throws FileNotFoundException {
        aStar.setKartta(new Kartta("esim2.txt"));
        assertEquals(48,aStar.aStar(new Koordinaatti(1,5,0), new Koordinaatti(3,1,0)));
    }
    
    @Test
    public void vaikea1amOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(30,aStar.aStar(new Koordinaatti(1,4,0), new Koordinaatti(1,7,0)));
    }
    
    @Test
    public void vaikea1mwOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(98,aStar.aStar(new Koordinaatti(1,7,9),new Koordinaatti(7,2,0)));
    }
    
    @Test
    public void vaikea1wyOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(78,aStar.aStar(new Koordinaatti(7,2,0), new Koordinaatti(14,4,0)));
    }
    
    @Test
    public void vaikea1yuOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(24,aStar.aStar(new Koordinaatti(14,4,0), new Koordinaatti(12,5,0)));
    }
    
    @Test
    public void vaikea1urOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(102,aStar.aStar(new Koordinaatti(12,5,0), new Koordinaatti(18,3,0)));
    }
    
    @Test
    public void vaikea1reOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(10,aStar.aStar((new Koordinaatti(18,3,0)), new Koordinaatti(18,2,0)));
    }
    
    @Test
    public void vaikea1eqOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(44,aStar.aStar(new Koordinaatti(18,2,0), new Koordinaatti(22,1,0)));
    }
    
    @Test
    public void vaikea1qbOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(134,aStar.aStar(new Koordinaatti(22,1,0), new Koordinaatti(35,2,0)));
    }
    
    @Test
    public void vaikea1btOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(64,aStar.aStar(new Koordinaatti(35,2,0), new Koordinaatti(29,3,0)));
    }
    
    @Test
    public void vaikea1tlOikein() throws FileNotFoundException {
        alustaVaikeaTesti();
        assertEquals(178,aStar.aStar(new Koordinaatti(29,3,0), new Koordinaatti(42,5,0)));
    }
}
