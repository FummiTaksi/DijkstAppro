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

    public static void main(String[] arghh) throws FileNotFoundException {
        Minimikeko keko = new Minimikeko();
        Koordinaatti[] taulukko = new Koordinaatti[10];
        taulukko[1] = new Koordinaatti(7, 7, 7);
        taulukko[2] = new Koordinaatti(2, 2, 2);
        taulukko[3] = new Koordinaatti(1, 1, 1);
        taulukko[4] = new Koordinaatti(5, 5, 5);
        taulukko[5] = new Koordinaatti(6, 6, 6);
        taulukko[6] = new Koordinaatti(4, 4, 4);
        keko.setTaulukko(taulukko);
        keko.setKoko(6);
        keko.heapify(1);
    }

}
