/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Käyttöliittymä DijkstAppro-sovellukselle.
 * @author mustonea
 */
public class Kayttoliittyma {

    private Scanner lukija;

    /**
     * Konstruktori alustaa scanner-olion ja käynnistää käyttöliittymän.
     */
    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        aloita();
    }

    /**
     *    Metodi käyttöliittymän aloitukselle.
     */
    public void aloita() {
        System.out.println("Tervetuloa DijkstApproon arvoisa approilija.");
        while (true) {
            System.out.println("Valitse seuraavista vaihtoehdoista: ");
            System.out.println("[1] Aloita uusi approreitin haku");
            System.out.println("[2] Lopeta");
            String valinta = lukija.nextLine();
            if (valinta.equals("1")) {
                reitinHaku();
            }
            else if (valinta.equals("2")) {
                System.out.println("Kiitos DijkstAppron käytöstä.");
                break;
            }
            else {
                System.out.println("Virheellinen syöte.");
            }
        }
    }

    /**
     *   Metodi jossa käyttäjä saa tietää haluamansa approreitin halauamassaan kartassa.
     */
    public void reitinHaku() {
        boolean lopetus = true;
        while (lopetus) {
            System.out.println("Kirjoita tekstitiedoston nimi, josta haluat hakea approreitin.");
            String valinta = lukija.nextLine();
            try {
                Logiikka logiikka = new Logiikka(valinta);
                System.out.println("Kartan alustus onnistui.");
                while (1 == 1) {
                    System.out.println("[1] Aloita reitinhaku");
                    System.out.println("[2] Tulosta kartta");
                    System.out.println("[3] Alusta uusi kartta");
                    System.out.println("[4] Palaa päävalikkoon");
                    String valinta2 = lukija.nextLine();
                    if (valinta2.equals("1")) {
                        System.out.println("Kartassa on " + logiikka.getKartta().getBaarienLkm() + " baaria. Monta baaria haluat reittiisi?");
                        String vastaus = lukija.nextLine();
                        logiikka.tulostaReitti(Integer.parseInt(vastaus));
                    }
                    else if (valinta2.equals("2")) {
                        System.out.println(logiikka.getKartta().getTarkistus());
                    }
                    else if (valinta2.equals("3")) {
                        reitinHaku();
                    }
                   else if (valinta2.equals("4")) {
                        lopetus = false;
                        break;
                    }
                   else {
                        System.out.println("Syöte oli virheellinen");
                   }
                    
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Tekstitiedoston nimi oli virheellinen. ");
                while (true) {
                    System.out.println("[1] Kirjoita tekstitiedoston nimi uudelleen");
                    System.out.println("[2] Lopeta");
                    String valinta2 = lukija.nextLine();
                    if (valinta2.equals("1")) {
                        reitinHaku();
                    }
                    else if (valinta2.equals("2")) {
                        System.out.println("Kiitos DijkstAppron käyttämisestä. Hauskaa approa!");
                    }
                    else {
                        System.out.println("Valinta virheellinen, kirjoita uudelleen.");
                    }
                    
                }
            }
        }
    }
}
