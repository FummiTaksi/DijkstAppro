/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

//import static com.mycompany.dijkstappro.Main.baarit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Kartta pitaa kirjaa kartalla olevissa koordinaateissa sijaitsevista merkeista
 * seka listan baareista.
 *
 * @author mustonea
 */
public class Kartta {

    private char[][] kartta;      // ensin y, sitten x kuten kaikissa muissa taulukoissa.
    private Koordinaatti[] paikat;
    private int paikkojenLkm;    // kuvaa kuinka monta baaria , aloitus ja lopetuspaikkaa on .
    private String tarkistus;    // käytetään vain testaamiseen.
    private Koordinaatti aloituspaikka;
    private Koordinaatti lopetuspaikka;

    /**
     * Kartta muodostetaan tekstitiedosta konstruktorissa. Tiedostonnimi on
     * parametrissa String-muodossa.
     *
     * @param tiedosto
     * @throws FileNotFoundException
     */
    public Kartta(String tiedosto) throws FileNotFoundException {
        this.paikat = new Koordinaatti[100];
        this.paikkojenLkm = 0;
        this.tarkistus = "";
        this.kartta = kartanAlustus(tiedosto);
    }
    public Kartta() {
        paikat = new Koordinaatti[1000000];
        this.paikkojenLkm = 0;
        this.tarkistus = "";
        kartanAlustusIsoTest();
    }

    /**
     * Palauttaa aloituspaikan.
     *
     */
    public Koordinaatti getAloituspaikka() {
        return aloituspaikka;
    }

    /**
     * palauttaa Lopetuspaikan.
     *
     * @return
     */
    public Koordinaatti getLopetuspaikka() {
        return lopetuspaikka;
    }
    /**
     * Palauttaa, mikä kirjain parametrissa olevalla koordinaatilla on kartassa.
     * @param koordinaatti
     * @return 
     */
    public Character getKirjain(Koordinaatti koordinaatti) {
        return kartta[koordinaatti.getY()][koordinaatti.getX()];
    }

    /**
     * Palauttaa kartan taulukossa.Saa parametrina tiedoston nimen.
     *
     * @param tiedostonNimi
     * @return
     * @throws FileNotFoundException
     */
    public char[][] kartanAlustus(String tiedostonNimi) throws FileNotFoundException {
        char[][] kartta = new char[100][100];
        Scanner lukija = new Scanner(new File(tiedostonNimi), "UTF-8");
       
        int riviNro = 0;
        String testi = "testi";
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            
            tarkistus += rivi + "\n";
            for (int i = 0; i < rivi.length(); i++) {
                Koordinaatti uusi = new Koordinaatti(i, riviNro);
                char kirjain = rivi.charAt(i);
//                System.out.print(kirjain);
                if (kirjain == 'a') {
//                    System.out.println("a");
//                    System.out.println("x " + i + " y " + riviNro);
                    this.aloituspaikka = uusi;
                }
                if (kirjain == 'l') {
//                    System.out.println("l");
//                    System.out.println("x " + i + " y " + riviNro);
                    this.lopetuspaikka = uusi;
                }
                if (kirjain != '#' && kirjain != '.') {
//                     System.out.println("kirjain  " + kirjain);
                    uusi.setId(paikkojenLkm);
                    paikat[paikkojenLkm] = uusi;

                    paikkojenLkm++;
                }
                kartta[riviNro][i] = rivi.charAt(i);
            }
//            System.out.println("");
            riviNro++;
        }

        return kartta;
    }
    /**
     * Käytetään testaamiseen
     */
    public void kartanAlustusIsoTest() {
        char[][]uusi= new char[10001][10001];
        uusi[1][1] = 'a';
        uusi[999][999] = 'l';
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000;j++) {
                if (i == 0 || j == 0 || i == 1000 || j == 1000) {
//                    tarkistus += '#';
                    uusi[j][i] = '#';
                }
                else {
                    int luku = new Random().nextInt(2);
                    if (luku == 0) {
//                        tarkistus += '#';
                        uusi[j][i] = '#';
                    }
                    if (luku == 1) {
//                        tarkistus += '#';
                        uusi[j][i] = 'x';
                    }
                    if (luku == 2) {
//                        tarkistus += '#';
                        uusi[j][i] = '.';
                    }
                }
//                tarkistus += "\n";
            }
        }
        this.kartta = uusi;
    }

    /**
     * Palauttaa kartan taulukkomuodossa.
     *
     * @return
     */
    public char[][] getKartta() {
        return kartta;
    }

    /**
     * Palauttaa paikkojen lukumaaran.
     *
     * @return
     */
    public int getPaikkojenLkm() {
        return paikkojenLkm;
    }

    public int getBaarienLkm() {
        return paikkojenLkm - 2;
    }

    /**
     * Palauttaa taulukon kartan Baareista ja aloitus ja lopetuspaikasta, jotka
     * ovat Koordinaatti-olioita.
     *
     * @return
     */
    public Koordinaatti[] getPaikat() {
        return paikat;
    }

    

    /**
     * Käytetään testaamiseen.
     *
     * @return
     */
    public String getTarkistus() {
        return tarkistus;
    }
}
