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

//        Astar tahti = new Astar(new Kartta("esim1.txt"));
//        tahti.aStar(new Koordinaatti(6,3,0), new Koordinaatti(8,3,0));
      Verkko verkko = new Verkko("esim1.txt");
      System.out.println(verkko.muodostaVerkko());

          

    }

}
