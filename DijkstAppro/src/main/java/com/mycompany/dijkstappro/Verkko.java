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
public class Verkko {

    private int[][] etaisyysMatriisi;
    private Kartta kartta;

    /**
     *  Luokka pitää sisällään matriisin tekstitiedostosta luetusta appro-kartasta. Matriisissa on jokaisen baarin etäisyys toisistaan.
     * @param tiedostonNimi
     * @throws FileNotFoundException
     */
    public Verkko(Kartta kartta)  {
        this.kartta = kartta;
        this.etaisyysMatriisi = new int[100][100];
        
    }

    /**
     * Muodostaa verkon ja palauttaa sen kaksiuloitteisessa taulukossa.
     * @return
     */
    public int[][] muodostaVerkko()  {
//        System.out.println("metodissa");
        Astar tahti = new Astar(kartta);
        int nousu = 0;
        while (nousu < kartta.getPaikkojenLkm()) {
//            System.out.println("loopissa");
            Baari yksi = kartta.getPaikat()[nousu];
            for (int i = nousu + 1 ; i < kartta.getPaikkojenLkm() ; i++) {
//                System.out.println("forissa");
                
                Baari kaksi = kartta.getPaikat()[i];
//                System.out.println("toinen baari määritelty");
                Koordinaatti alkupiste = new Koordinaatti(yksi.getX(),yksi.getY(),0);
                Koordinaatti loppupiste = new Koordinaatti(kaksi.getX(),kaksi.getY(),0);
//                System.out.println("alku " + alkupiste);
//                System.out.println("loppu " + loppupiste);
                int etaisyys = tahti.aStar(alkupiste, loppupiste);
//                System.out.println("etäisyys laskettu");
                etaisyysMatriisi[yksi.getId()][kaksi.getId()] = etaisyys;
                etaisyysMatriisi[kaksi.getId()][yksi.getId()] = etaisyys;
            }
            nousu++;
        }
        return etaisyysMatriisi;
    }
    
    /**
     * palauttaa verkon kaksiuloitteisessa taulukossa.
     * @return
     */
    public int[][] getVerkko() {
        return etaisyysMatriisi;
    }
    
    /**
     * palauttaa verkon muodostamiseen käytetyn kartan.
     * @return
     */
    public Kartta getKartta() {
        return kartta;
    }
    
    /**
     * Asettaa luokalle uuden kartan.
     * @param uusiKartta
     */
    public void setKartta(Kartta uusiKartta) {
        this.kartta = uusiKartta;
    }
}
