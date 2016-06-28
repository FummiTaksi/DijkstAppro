/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dijkstappro.Jono;
import com.mycompany.dijkstappro.Kartta;
import com.mycompany.dijkstappro.Koordinaatti;
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
    
    public void haeReitti(String kartta,int baarienMaara) throws FileNotFoundException {
        this.opas = new Reittiopas(new Kartta(kartta));
        opas.haeReitti(baarienMaara);
    }
    
    public void haeReittiHinnoilla(String kartta,String juomat,int baarienMaara) throws FileNotFoundException {
        this.opas = new Reittiopas(new Kartta(kartta));
        opas.haeReitti(juomat, baarienMaara);
    }
    

    @Test
    public void ensimmainenPaikkaOikein() {
        Koordinaatti aloitusPaikka = new Koordinaatti(1, 1);
        opas.haeReitti();
        assertTrue(aloitusPaikka.equals(opas.getJono().poistaEnsimmainen()));
    }

    @Test
    public void toinenPaikkaOikein() {
        Koordinaatti b = new Koordinaatti(3, 2);
        opas.haeReitti();
        Jono jono = opas.getJono();
        jono.poistaEnsimmainen();
        assertTrue(b.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void kolmasPaikkaOikein() {
        Koordinaatti c = new Koordinaatti(6, 3);
        opas.haeReitti();
        Jono jono = opas.getJono();
        jono.poistaEnsimmainen();
        jono.poistaEnsimmainen();
        assertTrue(c.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void lopetusPaikkaOikein() {
        Koordinaatti lopetus = new Koordinaatti(8, 3);
        opas.haeReitti();
        Jono jono = opas.getJono();
        for (int i = 1; i <= 3; i++) {
            jono.poistaEnsimmainen();
        }
        assertTrue(lopetus.equals(jono.poistaEnsimmainen()));
    }

    @Test
    public void esim1ReittiOikein() throws FileNotFoundException {
        alustaTesti("esim1.txt");
//        System.out.println("esim1 tämä on 2 " + opas.getBaarienMaara());
        opas.haeReitti();
        assertEquals(92, opas.getHalvimmanReitinHinta());
    }

    @Test
    public void esim2ReittiOikein() throws FileNotFoundException {
        alustaTesti("esim2.txt");
//        System.out.println("esim2 tämä on 4 " + opas.getBaarienMaara());
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
    @Test
    public void esim1OikeinYhdellaBaarilla() throws FileNotFoundException {
        haeReitti("esim1.txt",1);
        assertEquals("abl",opas.palautaReitti());
    }
    @Test
    public void esim2OikeinKahdellaBaarilla() throws FileNotFoundException {
        haeReitti("esim2.txt",2);
        assertEquals("abcl",opas.palautaReitti());
    }
    @Test
    public void esim2OikeinKolmellaBaarilla() throws FileNotFoundException {
        haeReitti("esim2.txt",3);
        assertEquals("abecl",opas.palautaReitti());
    }
    @Test
    public void esim3OikenKahdellaBaarilla() throws FileNotFoundException {
        haeReitti("esim3.txt",2);
        assertEquals("adel",opas.palautaReitti());
    }
    @Test
    public void vaikea1OikeinKahdellaBaarilla() throws FileNotFoundException {
        haeReitti("vaikea1.txt",2);
        assertEquals("aeql",opas.palautaReitti());
    }
    @Test
    public void vaikea1KahdellaBaarillaReitinHintaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",2);
        assertEquals(494,opas.getHalvimmanReitinHinta());
    }
    
    @Test
    public void vaikea1KolmellaBaarillaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",3);
        assertEquals("areql",opas.palautaReitti());
    }
    
    @Test 
    public void vaikea1KolmellaBaarillaHintaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",3);
        assertEquals(494,opas.getHalvimmanReitinHinta());
    }
    
    @Test
    public void vaikea1NeljallaBaarillaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",4);
        assertEquals("aureql",opas.palautaReitti());
    }
    
    @Test
    public void vaikea1ViidellaBaarillaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",5);
        assertEquals("awureql",opas.palautaReitti());
    }
    
    @Test
    public void vaikea1ViidellaBaarillaHintaOikein() throws FileNotFoundException {
        haeReitti("vaikea1.txt",5);
        assertEquals(502,opas.getHalvimmanReitinHinta());
    }
    
    @Test
    public void esim2JuomillaPalauttaaSiltiNopeimmanReitin() throws FileNotFoundException {
        haeReittiHinnoilla("esim2.txt","esim2juomat.txt",5);
        assertEquals("adbecl",opas.palautaReitti());
    }
    
    @Test
    public void esim2JuomillaPalauttaaOikeanReitinKolmeBaaria() throws FileNotFoundException {
        haeReittiHinnoilla("esim2.txt","esim2juomat.txt",3);
        assertEquals(6,opas.juomienHinnat());
    }
    
    @Test
    public void esim1JarjestaminenToimii() {
        assertEquals(new Koordinaatti(3,2,0),opas.getPaikatLahimpanaAloitusta()[0]);
    }
    
    @Test
    public void esim2JarjestaminenToimii() {
        assertEquals(new Koordinaatti(6,3,0),opas.getPaikatLahimpanaAloitusta()[1]);
    }
    @Test
    public void haeReittiOptimoituToimiiSamallaTavalla() {
        opas.haeReittiOptimoitu();
        assertEquals("abcl",opas.palautaReitti());
    }
    @Test
    public void haeReittiOptimoituOikeaHinta() {
        opas.haeReittiOptimoitu();
        assertEquals(92,opas.getHalvimmanReitinHinta());
    }
}
