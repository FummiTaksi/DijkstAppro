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
import java.util.Scanner;

/**
 * Kartta pitaa kirjaa kartalla olevissa koordinaateissa sijaitsevista merkeista seka listan baareista.
 * @author mustonea
 */
public class Kartta {

    private char[][] kartta;      // ensin y, sitten x kuten kaikissa muissa taulukoissa.
    private Baari[] baarit;       
    private int paikkojenLkm;    // kuvaa kuinka monta baaria , aloitus ja lopetuspaikkaa on .
    private String tarkistus;    // käytetään vain testaamiseen.
    private Baari aloituspaikka;
    private Baari lopetuspaikka;
    /**
     * Kartta muodostetaan tekstitiedosta konstruktorissa. Tiedostonnimi on parametrissa String-muodossa.
     * 
     * @param tiedosto
     * @throws FileNotFoundException
     */
    public Kartta(String tiedosto) throws FileNotFoundException {
        this.baarit = new Baari[100];
        this.paikkojenLkm = 0;
        this.tarkistus = "";
        this.kartta = kartanAlustus(tiedosto);
    }

    /**
     * Palauttaa aloituspaikan.
     *
     */
    
    public Baari getAloituspaikka() {
        return aloituspaikka;
    }
    
    /**
     * palauttaa Lopetuspaikan.
     * @return
     */
    public Baari getLopetuspaikka() {
        return lopetuspaikka;
    }
    
    /**
     * Palauttaa kartan taulukossa.Saa parametrina tiedoston nimen.
     * @param tiedostonNimi
     * @return
     * @throws FileNotFoundException
     */
    public char[][] kartanAlustus(String tiedostonNimi) throws FileNotFoundException {
        char[][] kartta = new char[100][100];
        Scanner lukija = new Scanner(new File(tiedostonNimi), "UTF-8");
        int riviNro = 0;
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tarkistus += rivi + "\n";
            for (int i = 0; i < rivi.length(); i++) {
                char kirjain = rivi.charAt(i);
//                System.out.print(kirjain);
                if (kirjain == 'a') {
//                    System.out.println("a");
//                    System.out.println("x " + i + " y " + riviNro);
                    this.aloituspaikka = new Baari(i,riviNro,paikkojenLkm);
                }
                if (kirjain == 'l') {
//                    System.out.println("l");
//                    System.out.println("x " + i + " y " + riviNro);
                    this.lopetuspaikka = new Baari(i,riviNro,paikkojenLkm);
                }
                if (kirjain != '#' && kirjain != '.') {
                    baarit[paikkojenLkm] = new Baari(i, riviNro,paikkojenLkm);
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
     * Palauttaa kartan taulukkomuodossa.
     * @return
     */
    public char[][] getKartta() {
        return kartta;
    }
    
    /**
     * Palauttaa aloituspaikan,lopetuspaikan ja baarien lukumaaran summan.
     * @return
     */
    public int getPaikkojenLkm() {
        return paikkojenLkm;
    }
    
    /**
     * Palauttaa taulukon kartan Baari-olioista.
     * @return
     */
    public Baari[] getBaarit() {
        return baarit;
    }
    
    /**
     * Käytetään testaamiseen.
     * @return
     */
    public String getTarkistus() {
        return tarkistus;
    }
}
