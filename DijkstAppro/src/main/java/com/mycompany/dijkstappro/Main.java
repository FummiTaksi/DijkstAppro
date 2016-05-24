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
    public static void main(String[] arghh) throws FileNotFoundException {
       paikkojenLkm = 0;
       baarit =new Baari[100];
       char[][] kartta = kartanAlustus("esim1.txt");          // muodostetaan tekstitiedostosta kartta taulukkoon
       int aloitusIndeksi = 0;
       while (aloitusIndeksi < paikkojenLkm) {
           
       }
       
        
    }

    public static char[][] kartanAlustus(String tiedostonNimi) throws FileNotFoundException {
        char[][] kartta = new char[100][100];
       
        Scanner lukija = new Scanner(new File(tiedostonNimi), "UTF-8");
        int riviNro = 0;
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            for (int i = 0; i < rivi.length(); i++) {
                char kirjain = rivi.charAt(i);
                if (kirjain != '#' && kirjain != '.') {
                    baarit[paikkojenLkm] = new Baari("" + kirjain,i,riviNro);
                    paikkojenLkm++;
                }
                kartta[riviNro][i] = rivi.charAt(i);
            }
            riviNro++;
        }
        return kartta;
    }

}
