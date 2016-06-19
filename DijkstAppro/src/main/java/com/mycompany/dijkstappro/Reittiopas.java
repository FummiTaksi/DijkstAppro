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
    private Jono reittiJono;
    private String reitti;

    /**
     * Luokka laskee parhaan reitin tekstitiedostossa olevalle approkartalle.
     *
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

    public char[][] getKartta() {
        return kartta.getKartta();
    }

    public int getBaarienMaara() {
        return kartta.getBaarienLkm();
    }
    /**
     * Palauttaa jonon, jossa approreitti on.
     *
     * @return
     */
    public Jono getJono() {
        return reittiJono;
    }

    /**
     * palauttaa halvimman reitin hinnan.
     *
     * @return
     */
    public int getHalvimmanReitinHinta() {
        return halvinReitti;
    }
    /**
      Laskee kirjainten muodostaman reitin hinnan.
    */
    public int reitinHinta(String reitti) {
        Astar aStar = new Astar(kartta);
        int palautus = 0;
        for (int i = 0; i < reitti.length() - 2;i++) {
            char eka = reitti.charAt(i);
            char toka =reitti.charAt(i + 1);
            Koordinaatti alku = new Koordinaatti(0,0,0);
            Koordinaatti loppu = new Koordinaatti(0,0,0);
            for (int j = 0; j < kartta.getPaikkojenLkm();j++) {
                Baari baari = kartta.getPaikat()[j];
//                System.out.println("Baari " + baari);
                char baarinKirjain = kartta.getKartta()[baari.getY()][baari.getX()];
                if (baarinKirjain == eka) {
                    alku = new Koordinaatti(baari.getX(),baari.getY(),0);
                }
                if (baarinKirjain == toka) {
                    loppu = new Koordinaatti(baari.getX(),baari.getY(),0);
                }
            }
            palautus += aStar.aStar(alku, loppu);
        }
        return palautus;
    }

    /**
     * Rekursiivinen metodi parhaan reitin etsimiseen.
     *
     * @param alku
     * @param loppu
     * @param vierailu
     * @param reitinHinta
     * @param reitti
     */
    public void etsiReitti(Baari alku, Baari loppu, int[] vierailu, int reitinHinta, Jono reitti, int baarejaJaljella) {
//        System.out.println("alku " + getKartta()[alku.getY()][alku.getX()]);
//        System.out.println("loppu " + loppu);
//        System.out.println("reitinHinta " + reitinHinta);
        
        if (baarejaJaljella > 0) {
             Jono uusiReitti = reitti.kloonaa();
            uusiReitti.lisaa(alku);
            int[] uusiVierailu = vierailu.clone();
            uusiVierailu[alku.getId()] = 1;
            boolean kaikkiLoydetty = true;
            for (int i = 0; i < verkko.getKartta().getPaikkojenLkm(); i++) {
                Baari baari = verkko.getKartta().getPaikat()[i];
                if (!baari.equals(loppu) && uusiVierailu[baari.getId()] == 0) {
                    //System.out.println("hellurei");
                    int reitinUusiHinta = reitinHinta + verkkoMatriisi[alku.getId()][baari.getId()];
                    if (reitinUusiHinta < halvinReitti) {
//                         System.out.println(uusiReitti.toString());
                        etsiReitti(baari, loppu, uusiVierailu, reitinUusiHinta, uusiReitti, baarejaJaljella - 1);
                    }
//                    System.out.println("REITTI LOPPUI!");
                    kaikkiLoydetty = false;
                }

            }
        } else if (baarejaJaljella == 0) {
              Jono uusiReitti = reitti.kloonaa();
//            System.out.println("reitti loppui");
//            System.out.println("tämä on 86 " + verkkoMatriisi[alku.getId()][loppu.getId()]);
//            System.out.println("reitinHinta " + reitinHinta);
            int reitinLopullinenHinta = reitinHinta + verkkoMatriisi[alku.getId()][loppu.getId()];
//            System.out.println("lopullinen hinta " + reitinLopullinenHinta);
            if (reitinLopullinenHinta < halvinReitti) {

                halvinReitti = reitinLopullinenHinta;
                uusiReitti.lisaa(alku);
                uusiReitti.lisaa(loppu);
//                System.out.println(uusiReitti);
//                System.out.println("reitin hinta " + halvinReitti);
                this.reittiJono = uusiReitti;
            }

        }
    }

    /**
     * Hakee nopeimman approreitin aloituspistestä lopetuspisteeseen käymällä kaikki baarit läpi.
     */
    public void haeReitti() {
        int[] vierailu = new int[verkko.getKartta().getPaikkojenLkm() + 1];
//        System.out.println("aloituspaikka " + kartta.getAloituspaikka());
//        System.out.println("lopetuspaikka " + kartta.getLopetuspaikka());
        etsiReitti(verkko.getKartta().getAloituspaikka(), verkko.getKartta().getLopetuspaikka(), vierailu, 0, new Jono(),getBaarienMaara());
    }
    /**
     * Hakee nopeimman approreitin aloituspisteestä lopetuspisteeseen käymällä parametrin verran baareissa.
     * @param baarienMaara 
     */
    public void haeReitti(int baarienMaara) {
        int[] vierailu = new int[verkko.getKartta().getPaikkojenLkm() + 1];
        etsiReitti(verkko.getKartta().getAloituspaikka(),verkko.getKartta().getLopetuspaikka(),vierailu,0,new Jono(),baarienMaara);
    }

    /**
     * Palauttaa parhaan approreitin baarien kirjaimet alusta loppuun.
     *
     * @return
     */
    public String palautaReitti() {
        Jono apu = reittiJono.kloonaa();
        String palautus = "";
        while (!apu.onTyhja()) {
            Baari seuraava = apu.poistaEnsimmainen();
            palautus += kartta.getKartta()[seuraava.getY()][seuraava.getX()];
        }
        return palautus;
    }

    /**
     * Palauttaa approreitin string muodossa.
     *
     * @return
     */
    @Override
    public String toString() {
        String palautus = " Approreitti on seuraava: " + " \n";
        Jono apu = reittiJono.kloonaa();
        while (!apu.onTyhja()) {
            Baari seuraava = apu.poistaEnsimmainen();
            palautus += "Baari " + kartta.getKartta()[seuraava.getY()][seuraava.getX()] + ", sijainti " + seuraava + "\n";
        }

        return palautus + "\n" + " Reitin hinta on " + halvinReitti;
    }

}
