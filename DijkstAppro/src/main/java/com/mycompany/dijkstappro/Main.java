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

        Koordinaatti yksi = new Koordinaatti(1,1,1);
        Koordinaatti kaksi = new Koordinaatti(1,1,2);
        TreeMap<Koordinaatti,Integer> testi =new TreeMap();
        testi.put(yksi,5);
        System.out.println(testi.containsKey(kaksi));
//        System.out.println(yksi.equals(kaksi));
//        Kartta kartta = new Kartta("esim1.txt");          // muodostetaan tekstitiedostosta kartta taulukkoon.
//        Astar tahti = new Astar(kartta);
//        System.out.println("pitäisi olla 10 " + tahti.aStar(new Koordinaatti(1,1,0), new Koordinaatti(2,1,0), kartta.getKartta()));

    }

}
