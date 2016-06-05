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

//         char[][] kirjaimet = new char[10][10];
//         System.out.println("1" + kirjaimet[1][1] + "1");
          Kartta kartta = new Kartta("esim2.txt");
          Astar tahti = new Astar(kartta);
          tahti.aStar(new Koordinaatti(1,5,0), new Koordinaatti(3,1,0));
    }

}
