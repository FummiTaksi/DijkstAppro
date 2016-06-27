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
    private int juomienHinnat;

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
     * Laskee kirjainten muodostaman reitin hinnan.
     */
    public int reitinHinta(String reitti) {
        Astar aStar = new Astar(kartta);
        int palautus = 0;
        for (int i = 0; i < reitti.length() - 2; i++) {
            char eka = reitti.charAt(i);
            if (eka == 'l') {
                break;
            }
            char toka = reitti.charAt(i + 1);
            Koordinaatti alku = new Koordinaatti(0, 0);
            Koordinaatti loppu = new Koordinaatti(0, 0);
            for (int j = 0; j < kartta.getPaikkojenLkm() + 1; j++) {
                Koordinaatti lapiKaytava = kartta.getPaikat()[j];
//                System.out.println("Baari " + baari);

                char baarinKirjain = kartta.getKartta()[lapiKaytava.getY()][lapiKaytava.getX()];
                if (baarinKirjain == eka) {
                    alku = lapiKaytava;
                }
                if (baarinKirjain == toka) {
                    loppu = lapiKaytava;
                }

            }
            System.out.println("alku " + alku);
            System.out.println("loppu " + loppu);
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
    public void etsiReitti(Koordinaatti alku, Koordinaatti loppu, int[] vierailu, int reitinHinta, Jono reitti, int baarejaJaljella,
            Koordinaatti[] paikat, int paikkojenLkm) {
//        System.out.println("alku " + getKartta()[alku.getY()][alku.getX()]);
//        System.out.println("loppu " + loppu);
//        System.out.println("reitinHinta " + reitinHinta);
//        System.out.println("baareja jaljella " + baarejaJaljella);

        if (baarejaJaljella > 0) {
            Jono uusiReitti = reitti.kloonaa();
            uusiReitti.lisaa(alku);
            int[] uusiVierailu = vierailu.clone();
            uusiVierailu[alku.getId()] = 1;
            for (int i = 0; i < paikkojenLkm; i++) {
                Koordinaatti lapiKaytava = paikat[i];
//                System.out.println(lapiKaytava);
                if (!lapiKaytava.equals(loppu) && uusiVierailu[lapiKaytava.getId()] == 0) {
                    //System.out.println("hellurei");
                    int reitinUusiHinta = reitinHinta + verkkoMatriisi[alku.getId()][lapiKaytava.getId()];
                    if (reitinUusiHinta < halvinReitti) {
//                         System.out.println(uusiReitti.toString());
                        etsiReitti(lapiKaytava, loppu, uusiVierailu, reitinUusiHinta, uusiReitti, baarejaJaljella - 1, paikat, paikkojenLkm);
                    }
//                    System.out.println("REITTI LOPPUI!");

                }

            }
        } else if (baarejaJaljella == 0) {
//            System.out.println("hellurei");
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
     * Hakee nopeimman approreitin aloituspistestä lopetuspisteeseen käymällä
     * kaikki baarit läpi.
     */
    public void haeReitti() {
        int[] vierailu = new int[kartta.getPaikkojenLkm() + 1];
//        System.out.println("aloituspaikka " + kartta.getAloituspaikka());
//        System.out.println("lopetuspaikka " + kartta.getLopetuspaikka());
        etsiReitti(verkko.getKartta().getAloituspaikka(), verkko.getKartta().getLopetuspaikka(), vierailu, 0, new Jono(), getBaarienMaara(),
                verkko.getKartta().getPaikat(), verkko.getKartta().getPaikkojenLkm());
    }

    /**
     * Hakee nopeimman approreitin aloituspisteestä lopetuspisteeseen käymällä
     * parametrin verran baareissa.
     *
     * @param baarienMaara
     */
    public void haeReitti(int baarienMaara) {
        int[] vierailu = new int[kartta.getPaikkojenLkm() + 1];
        etsiReitti(verkko.getKartta().getAloituspaikka(), verkko.getKartta().getLopetuspaikka(), vierailu, 0, new Jono(), baarienMaara,
                verkko.getKartta().getPaikat(), verkko.getKartta().getPaikkojenLkm());
    }

    public void haeReittiOptimoitu(int baarienMaara) {
        int[] vierailu = new int[kartta.getPaikkojenLkm() + 1];
        
    }
    /**
     * Hakee nopeimman approreitin halvimmilla juomilla.
     *
     * @param juomalista Tekstitiedostosta luettu juomalista.
     * @param baarienMaara monta baaria approreitissä on.
     */
    public void haeReitti(String juomalista, int baarienMaara) throws FileNotFoundException {
        Juomalista lista = new Juomalista(juomalista, kartta);
        int[] vierailu = new int[kartta.getPaikkojenLkm() + 1];
        Koordinaatti[] paikat = lista.palautaHalvimmat(baarienMaara);
        etsiReitti(verkko.getKartta().getAloituspaikka(), verkko.getKartta().getLopetuspaikka(), vierailu, 0, new Jono(),
                baarienMaara - 1, paikat, baarienMaara);

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
            Koordinaatti seuraava = apu.poistaEnsimmainen();
            palautus += kartta.getKartta()[seuraava.getY()][seuraava.getX()];
        }
        return palautus;
    }

    /**
     * Palauttaa approreittien juomien hinnat.
     *
     * @return
     */
    public int juomienHinnat() {
        int palautus = 0;
        Jono apu = reittiJono.kloonaa();
        while (!apu.onTyhja()) {
            palautus += apu.poistaEnsimmainen().getHinta();
        }
        return palautus;
    }

    /**
     * Palauttaa baarit taulukossa, jossa alussa ovat ne , jotka ovat lähimpänä
     * aloituspaikkaa.
     *
     * @return
     */
    public Koordinaatti[] getPaikatLahimpanaAloitusta() {

        Koordinaatti[] palautus = new Koordinaatti[kartta.getPaikkojenLkm() + 1];
        int hissi = kartta.getPaikkojenLkm() - 1;
//        System.out.println("aloitus " + kartta.getAloituspaikka());
        int aloitusId = kartta.getAloituspaikka().getId();
        Minimikeko keko = new Minimikeko();
        while (hissi > 0) {
            Koordinaatti paikka = kartta.getPaikat()[hissi];
//            System.out.println("paikka " + paikka);
            char kirjain = kartta.getKirjain(paikka);
            if (kirjain != 'a' && kirjain != 'l') {
                int etaisyys = verkkoMatriisi[aloitusId][paikka.getId()];
//                System.out.println("etäisyys " + etaisyys);
                keko.lisaa(new Koordinaatti(paikka.getX(), paikka.getY(), etaisyys));
            }
            hissi--;
        }
        hissi = 0;
        while (!keko.tyhja()) {
            palautus[hissi] = keko.poistaPienin();
            hissi++;
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
            Koordinaatti seuraava = apu.poistaEnsimmainen();
            palautus += "Baari " + kartta.getKartta()[seuraava.getY()][seuraava.getX()] + ", sijainti " + seuraava + "\n";
        }

        return palautus + "\n" + " Reitin hinta on " + halvinReitti;
    }

}
