/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author mustonea
 */
public class Reittiopas {

    private int[][] verkkoMatriisi;
    private Verkko verkko;
    private int halvinReitti;
    private Stack<Baari> reittiPino;

    public Reittiopas(String tiedostonNimi) throws FileNotFoundException {
        this.verkko = new Verkko(tiedostonNimi);
        this.verkkoMatriisi = verkko.muodostaVerkko();
        this.halvinReitti = Integer.MAX_VALUE;
    }

    public void etsiReitti(Baari alku, Baari loppu, int[] vierailu, int reitinHinta, Stack<Baari> reitti) {
        vierailu[alku.getId()] = 1;
        reitti.push(alku);
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
                reitti.push(loppu);
                this.reittiPino = reitti;
            }
            
        }
    }
    
    public void haeReitti() {
        int[] vierailu = new int[verkko.getKartta().getPaikkojenLkm() + 1];
        Stack<Baari> pino = new Stack();
        Baari aloitusPaikka = verkko.getKartta().getAloituspaikka();
        pino.push(aloitusPaikka);
        vierailu[aloitusPaikka.getId()] = 1;
        etsiReitti(verkko.getKartta().getAloituspaikka(),verkko.getKartta().getLopetuspaikka(),vierailu,0,pino);
    }

}
