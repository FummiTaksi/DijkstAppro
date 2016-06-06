/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Koordinaatti;
import com.mycompany.dijkstappro.Minimikeko;
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
public class MinimikekoTest {

    private Minimikeko keko;

    public MinimikekoTest() {
        this.keko = new Minimikeko();
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
    public void alustaHeapifyTesti() {
        Koordinaatti[] taulukko = new Koordinaatti[10];
        taulukko[1] = new Koordinaatti(7, 7, 7);
        taulukko[2] = new Koordinaatti(2, 2, 2);
        taulukko[3] = new Koordinaatti(1, 1, 1);
        taulukko[4] = new Koordinaatti(5, 5, 5);
        taulukko[5] = new Koordinaatti(6, 6, 6);
        taulukko[6] = new Koordinaatti(4, 4, 4);
        keko.setTaulukko(taulukko);
        keko.setKoko(6);
        keko.heapify(1);
    }
    
    public void alustaLisaysTesti() {
        keko.lisaa(new Koordinaatti(6,6,6));
        keko.lisaa(new Koordinaatti(3,3,3));
        keko.lisaa(new Koordinaatti(2,2,2));
        keko.lisaa(new Koordinaatti(1,1,1));
    }

    @Test
    public void lisaaminenTyhjaanKekoonToimii() {
        Koordinaatti lisattava = new Koordinaatti(1, 1, 1);
        keko.lisaa(lisattava);
        assertEquals(lisattava, keko.getTaulukko()[keko.getKoko()]);
    }

    @Test
    public void vaihdaAlkiotToimii1() {
        Koordinaatti yksi = new Koordinaatti(1, 1, 1);
        Koordinaatti kaksi = new Koordinaatti(2, 2, 2);
        keko.lisaa(yksi);
        keko.lisaa(kaksi);
        keko.vaihdaAlkiot(1, 2);
        assertEquals(keko.getTaulukko()[1], kaksi);
    }

    @Test
    public void vaihdaAlkiotToimii2() {
        Koordinaatti yksi = new Koordinaatti(1, 1, 1);
        Koordinaatti kaksi = new Koordinaatti(2, 2, 2);
        keko.lisaa(yksi);
        keko.lisaa(kaksi);
        keko.vaihdaAlkiot(1, 2);
        assertEquals(keko.getTaulukko()[2], yksi);
    }

    @Test
    public void heapifyToimii1() {
        alustaHeapifyTesti();
        assertEquals(keko.getTaulukko()[1], new Koordinaatti(1, 1, 1));
    }

    @Test
    public void heapifyToimii2() {
        alustaHeapifyTesti();
        assertEquals(keko.getTaulukko()[2],new Koordinaatti(2,2,2));
    }
    
    @Test
    public void heapifyToimii3() {
        alustaHeapifyTesti();
        
        assertEquals(keko.getTaulukko()[3],new Koordinaatti(4,4,4));
    }
    
    @Test
    public void heapifyToimii4() {
        alustaHeapifyTesti();
        assertEquals(keko.getTaulukko()[4],new Koordinaatti(5,5,5));
    }
    
    @Test
    public void heapifyToimii5() {
        alustaHeapifyTesti();
        assertEquals(keko.getTaulukko()[5],new Koordinaatti(6,6,6));
    }
    
    @Test
    public void heapifyToimii6() {
        alustaHeapifyTesti();
        assertEquals(keko.getTaulukko()[6],new Koordinaatti(7,7,7));
    }
    
    @Test
    public void lisaysToimii1() {
        alustaLisaysTesti();
        assertEquals(keko.getTaulukko()[1],new Koordinaatti(1,1,1));
    }
    
    @Test
    public void lisaysToimii2() {
        alustaLisaysTesti();
        assertEquals(keko.getTaulukko()[2],new Koordinaatti(2,2,2));
    }
    
    @Test
    public void lisaysToimii3() {
        alustaLisaysTesti();
        assertEquals(keko.getTaulukko()[3],new Koordinaatti(3,3,3));
    }
    
    @Test
    public void lisaysToimii4() {
        alustaLisaysTesti();
        assertEquals(keko.getTaulukko()[4],new Koordinaatti(6,6,6));
    }
    
    @Test
    public void ensimmainenPoistoPalauttaaOikean() {
        alustaLisaysTesti();
        assertEquals(keko.poistaPienin(),new Koordinaatti(1,1,1));
    }
    
    @Test
    public void toinenPoistoPalauttaaOikean() {
        alustaLisaysTesti();
        keko.poistaPienin();
        assertEquals(keko.poistaPienin(),new Koordinaatti(2,2,2));
    }
    
    @Test
    public void kolmasPoistoPalauttaaOikean() {
        alustaLisaysTesti();
        keko.poistaPienin();
        keko.poistaPienin();
        assertEquals(keko.poistaPienin(),new Koordinaatti(3,3,3));
    }
    
    @Test
    public void neljasPoistoPalauttaaOikean() {
        alustaLisaysTesti();
        keko.poistaPienin();
        keko.poistaPienin();
        keko.poistaPienin();
        assertEquals(keko.poistaPienin(),new Koordinaatti(6,6,6));
    }
    
    @Test
    public void lisataanPieniAlkioMeneeKehonHuipulle() {
        keko.lisaa(new Koordinaatti(2,2,2));
        keko.lisaa(new Koordinaatti(3,3,3));
        keko.lisaa(new Koordinaatti(5,5,5));
        keko.lisaa(new Koordinaatti(6,6,6));
        keko.lisaa(new Koordinaatti(1,1,1));
        assertEquals(keko.poistaPienin(),new Koordinaatti(1,1,1));
    }
}
