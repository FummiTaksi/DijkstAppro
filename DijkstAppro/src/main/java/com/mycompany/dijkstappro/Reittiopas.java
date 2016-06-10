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
    private String reitti;

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
        this.reitti = "";
    }

    public ArrayDeque<Baari> getJono() {
        return reittiJono;
    }
    
    public int getHalvimmanReitinHinta() {
        return halvinReitti;
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
//        System.out.println("alku " + alku);
//        System.out.println("loppu " + loppu);
//        System.out.println("reitinHinta " + reitinHinta);
        ArrayDeque<Baari> uusiReitti = reitti.clone();
        uusiReitti.add(alku);
        int[] uusiVierailu = vierailu.clone();
        uusiVierailu[alku.getId()] = 1;
        boolean kaikkiLoydetty = true;
        for (int i = 0; i < verkko.getKartta().getPaikkojenLkm(); i++) {
            Baari baari = verkko.getKartta().getBaarit()[i];
            if (!baari.equals(loppu) && uusiVierailu[baari.getId()] == 0) {
                //System.out.println("hellurei");
                    int reitinUusiHinta = reitinHinta + verkkoMatriisi[alku.getId()][baari.getId()];
                    if (reitinUusiHinta < halvinReitti) {
                         etsiReitti(baari,loppu,uusiVierailu,reitinUusiHinta,uusiReitti);
                    }
                    kaikkiLoydetty = false;      
            }

        }
        if (kaikkiLoydetty) {
//            System.out.println("reitti loppui");
//            System.out.println("tämä on 86 " + verkkoMatriisi[alku.getId()][loppu.getId()]);
//            System.out.println("reitinHinta " + reitinHinta);
            int reitinLopullinenHinta = reitinHinta + verkkoMatriisi[alku.getId()][loppu.getId()];
//            System.out.println("lopullinen hinta " + reitinLopullinenHinta);
            if (reitinLopullinenHinta < halvinReitti) {
                halvinReitti = reitinLopullinenHinta;
                uusiReitti.add(loppu);
                this.reittiJono = uusiReitti;
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
    
    public String palautaReitti() {
        ArrayDeque<Baari> apu = reittiJono.clone();
        String palautus = "";
        while(!apu.isEmpty()) {
            Baari seuraava = apu.poll();
            palautus += kartta.getKartta()[seuraava.getY()][seuraava.getX()];
        }
        return palautus;
    }
    
    @Override
    public String toString() {
        String palautus = " Approreitti on seuraava: " + " \n";
        ArrayDeque<Baari> apu = reittiJono.clone();
        while(!apu.isEmpty()) {
            Baari seuraava = apu.poll();
            palautus += "Baari " + kartta.getKartta()[seuraava.getY()][seuraava.getX()] + ", sijainti " + seuraava + "\n";
        }
        
        return palautus + "\n" + " Reitin hinta on " + halvinReitti;
    }

}
