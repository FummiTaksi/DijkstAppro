/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

/**
 * Jono pitää sisällään baareja. Jonon loppuun voi lisätä ja alusta poistaa.
 * @author mustonea
 */
public class Jono {

    private Baari[] taulukko;
    private int alku;
    private int loppu;

    /**
     * Taulukko alustetaan ja alku ja loppuideksi nollaan.
     */
    public Jono() {
        this.taulukko = new Baari[100];
        this.alku = 0;
        this.loppu = 0;
    }

    /**
     * Jonon voi myös alustaa valmiilla taulukolla ja erilaisilla alku ja loppuindekseillä.
     * @param alku
     * @param loppu
     * @param taulukko
     */
    public Jono(int alku, int loppu, Baari[] taulukko) {
        this.taulukko = taulukko;
        this.alku = alku;
        this.loppu = loppu;
    }

    /**
     * metodi lisää Baarin jonon loppuun.
     * @param baari
     */
    public void lisaa(Baari baari) {
        taulukko[loppu] = baari;
        loppu++;
    }

    /**
     * poistaa ja palauttaa jonon ensimmäisen alkion.
     * @return
     */
    public Baari poistaEnsimmainen() {
        if (alku == loppu) {
            return null;
        }
        alku++;
        return taulukko[alku - 1];
    }

    /**
     * palauttaa true jos jono on tyhja, false jos jonossa on alkioita
     * @return
     */
    public boolean onTyhja() {
        return alku == loppu;
    }

    /**
     * Palauttaa identtisen Jono-olion itsestään.
     * @return
     */
    public Jono kloonaa() {
        Baari[] kopioTaulukko = new Baari[100];
        for (int i = alku; i <= loppu; i++) {
            kopioTaulukko[i] = taulukko[i];
        }
        return new Jono(alku, loppu , kopioTaulukko);
    }

    /**
     * Kertoo, mitä alkioita jonossa on.
     * @return
     */
    public String toString() {

        if (alku < loppu) {
            String palautus = "Jonossa on seuraavat alkiot: " + "\n";
            for (int i = alku; i <= loppu; i++) {
                palautus += taulukko[i] + "\n";
            }
            return palautus;
        }
        return "Jono on tyhjä.";

    }
}
