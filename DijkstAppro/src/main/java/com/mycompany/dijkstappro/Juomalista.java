/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Luokan tehtävä on lukea tekstitiedostosta juomien hinnat ja lisätä ne
 * Koordinaatti-olioille.
 *
 * @author mustonea
 */
public class Juomalista {

    private Minimikeko keko;
    private Kartta kartta;

    /**
     * Parametriksi tulee tiedostonnimi sekä kartta, jossa baarit ovat.
     *
     * @param tiedostonNimi
     * @param kartta
     * @throws FileNotFoundException
     */
    public Juomalista(String tiedostonNimi, Kartta kartta) throws FileNotFoundException {
        this.keko = new Minimikeko();
        this.kartta = kartta;
        alustaLista(tiedostonNimi);
    }

    /**
     * Palauttaa keon, jossa koordinaatit ovat.
     *
     * @return
     */
    public Minimikeko getKeko() {
        return keko;
    }

    /**
     * Metodissa luetaan tekstitiedostosta juomien hinnat ja lisätään ne
     * baareille.
     *
     * @param tiedosto
     * @throws FileNotFoundException
     */
    public void alustaLista(String tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(new File(tiedosto), "UTF-8");
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
//            System.out.println(rivi);
            String[] taulukko = rivi.split(" ");
            char kirjain = taulukko[0].charAt(0);
            for (int i = 0; i < kartta.getPaikkojenLkm(); i++) {
                char baarinKirjain = kartta.getKartta()[kartta.getPaikat()[i].getY()][kartta.getPaikat()[i].getX()];
                if (kirjain == baarinKirjain) {
                    kartta.getPaikat()[i].setHinta(Integer.parseInt(taulukko[1]));
                    keko.lisaa(kartta.getPaikat()[i]);
                }

            }
        }
    }

    /**
     * Palauttaa parametrin verran koordinaatteja aloittaen halvimmasta.
     *
     * @param maara
     * @return
     */
    public Koordinaatti[] palautaHalvimmat(int maara) {
        Koordinaatti[] palautus = new Koordinaatti[kartta.getPaikkojenLkm() + 1];
        Minimikeko kopio = keko.kloonaa();
        int nousu = 0;
        int suurin = 0;
        while (!keko.tyhja()) {
           
            Koordinaatti seuraava = keko.poistaPienin();
            if (nousu < maara || seuraava.getHinta() == suurin) {
                palautus[nousu] = seuraava;
                suurin = palautus[nousu].getHinta();
                nousu++;
            }
            if (nousu > maara && seuraava.getHinta() > suurin) {
                break;
            }

        }
        return palautus;
    }
}
