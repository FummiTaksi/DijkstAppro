/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author mustonea
 */
public class Reittiopas {

    private int[][] verkkoMatriisi;
    private Verkko verkko;
    private Kartta kartta;
    private int halvinReitti;
    private ArrayDeque<Baari> reittiJono;

    /**
     * Luokka laskee parhaan reitin tekstitiedostossa olevalle approkartalle.
     * @param tiedostonNimi
     * @throws FileNotFoundException
     */
    public Reittiopas(Kartta kartta) throws FileNotFoundException {
        this.verkko = new Verkko(kartta);
        this.kartta = kartta;
        this.verkkoMatriisi = verkko.muodostaVerkko();
        this.halvinReitti = Integer.MAX_VALUE;
    }

    public ArrayDeque<Baari> getJono() {
        return reittiJono;
    }

    /**
     * Rekursiivinen metodi parhaan reitin etsimiseen.
     * @param alku
     * @param loppu
     * @param vierailu
     * @param reitinHinta
     * @param reitti
     */
    public void etsiReitti(Baari alku, Baari loppu, int[] vierailu, int reitinHinta, ArrayDeque<Baari> reitti) {
        vierailu[alku.getId()] = 1;
        reitti.add(alku);
        boolean kaikkiLoydetty = true;
        for (int i = 0; i < verkko.getKartta().getPaikkojenLkm(); i++) {
            Baari baari = verkko.getKartta().getBaarit()[i];
            if (!baari.equals(loppu) && vierailu[baari.getId()] == 0) {
                    int reitinUusiHinta = reitinHinta + verkkoMatriisi[alku.getId()][baari.getId()];
                    if (reitinUusiHinta < halvinReitti) {
                         etsiReitti(baari,loppu,vierailu,reitinUusiHinta,reitti);
                    }
                    kaikkiLoydetty = false;
        
            }

        }
        if (kaikkiLoydetty) {
            int reitinLopullinenHinta = reitinHinta + verkkoMatriisi[alku.getId()][loppu.getId()];
            if (reitinLopullinenHinta < halvinReitti) {
                halvinReitti = reitinLopullinenHinta;
                reitti.add(loppu);
                this.reittiJono = reitti;
            }
            
        }
    }
    
    /**
     *  
     */
    public void haeReitti() {
        int[] vierailu = new int[verkko.getKartta().getPaikkojenLkm() + 1];
//        System.out.println("aloituspaikka " + kartta.getAloituspaikka());
//        System.out.println("lopetuspaikka " + kartta.getLopetuspaikka());
        ArrayDeque<Baari> jono = new ArrayDeque();
        etsiReitti(verkko.getKartta().getAloituspaikka(),verkko.getKartta().getLopetuspaikka(),vierailu,0,jono);
    }
    
    @Override
    public String toString() {
        String palautus = " Approreitti on seuraava: " + " \n";

        while(!reittiJono.isEmpty()) {
            Baari seuraava = reittiJono.poll();
            
            palautus += "Baari " + kartta.getKartta()[seuraava.getY()][seuraava.getX()] + ", sijainti " + seuraava + "\n";
        }
        
        return palautus + "\n" + " Reitin hinta on " + halvinReitti;
    }

}
