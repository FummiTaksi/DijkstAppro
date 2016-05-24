/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author mustonea
 */
public class Main {

    static int paikkojenLkm;
    static Baari[] baarit;
    static int[][] etaisyys;
    static char[][] kartta;

    public static void main(String[] arghh) throws FileNotFoundException {
        paikkojenLkm = 0;                                      //kartassa olevien baarien määrä
        baarit = new Baari[100];
        etaisyys = new int[100][100];
//        kartta = kartanAlustus("esim1.txt");          // muodostetaan tekstitiedostosta kartta taulukkoon.
//       int aloitusIndeksi = 0;                               
//       while (aloitusIndeksi < paikkojenLkm) {                // Lasketaan A*:llä kaikkien baarien etäisyys toisiinsa.
//           
//       }
        kartanAlustus("esim1.txt");

    }

    public static int aStar(Baari lahto, Baari maali) {
        int[][] manhattan = new int[100][100];
        int maaliY = maali.getY();
        int maaliX = maali.getX();
        for (int leveys = 0; leveys < kartta.length; leveys++) {
            for (int korkeus = 0; korkeus < kartta[0].length; korkeus++) {
                char kirjain = kartta[korkeus][leveys];
                if (kirjain != '#') {
                    manhattan[korkeus][leveys] = Math.abs(maaliX - leveys) + Math.abs(maaliY - korkeus);
                }
            }

        }
        PriorityQueue<Koordinaatti> openList = new PriorityQueue();
        HashSet<Koordinaatti> closedList = new HashSet();
        Koordinaatti loppu = new Koordinaatti(maali.getX(),maali.getY(),0);
        Koordinaatti pienin = new Koordinaatti(lahto.getX(),lahto.getY(),0);
        while (!openList.contains(loppu)) {
            
        }
        
        return 0;
    }

    public static char[][] kartanAlustus(String tiedostonNimi) throws FileNotFoundException {
        char[][] kartta = new char[100][100];
        Scanner lukija = new Scanner(new File(tiedostonNimi), "UTF-8");
        int riviNro = 0;
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println(rivi);                               //testitulostus
            for (int i = 0; i < rivi.length(); i++) {
                char kirjain = rivi.charAt(i);
                if (kirjain != '#' && kirjain != '.') {
                    baarit[paikkojenLkm] = new Baari("" + kirjain, i, riviNro);
                    paikkojenLkm++;
                }
                kartta[riviNro][i] = rivi.charAt(i);
            }
            riviNro++;
        }

        return kartta;
    }

}
