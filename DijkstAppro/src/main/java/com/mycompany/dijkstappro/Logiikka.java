/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.FileNotFoundException;

/**
 *
 * @author mustonea
 */
public class Logiikka {
    private Kartta kartta;
    private Verkko verkko;
    private Reittiopas opas;
    private Astar tahti;
    
    /**
     * Luokka yhdistää kaikki ohjelman luokat toimimaan yhdessä.
     * @param tiedostonNimi
     * @throws FileNotFoundException
     */
    public Logiikka(String tiedostonNimi) throws FileNotFoundException {
        setKartta(tiedostonNimi);
    }
    
    /**
     * Alustaa kaikki reittioppaan tarvitsemat apuoliot tekstitiedostossa olevalle kartalle.
     * @param uusiKartta
     * @throws FileNotFoundException 
     */
    public void setKartta(String uusiKartta) throws FileNotFoundException {
        this.kartta = new Kartta(uusiKartta);
        this.verkko = new Verkko(kartta);
        this.tahti= new Astar(kartta);
        this.opas = new Reittiopas(kartta);
    }
    
    /**
     * Palauttaa kartta-olion.
     * @return 
     */
    public Kartta getKartta() {
        return kartta;
    }
    /**
     * Tulostaa approreitin.
     */
    public void tulostaReitti() {
        opas.haeReitti();
        System.out.println(opas);
    }
    
    /**
     *  Tulostaa approreitin, jossa on parametrin verran baareja.
     * @param baarienMaara 
     */
    public void tulostaReitti(int baarienMaara) {
        opas.haeReitti(baarienMaara);
        System.out.println(opas);
    }
}
