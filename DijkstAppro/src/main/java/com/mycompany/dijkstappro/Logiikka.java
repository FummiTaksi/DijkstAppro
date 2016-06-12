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
        this.kartta = new Kartta(tiedostonNimi);
        this.verkko  = new Verkko(kartta);
        this.tahti = new Astar(kartta);
        this.opas = new Reittiopas(kartta); 
    }
    
    /**
     * Tulostaa approreitin.
     */
    public void tulostaReitti() {
        opas.haeReitti();
        System.out.println(opas);
    }
}
