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
         Logiikka logiikka = new Logiikka("esim1.txt");
         logiikka.tulostaReitti();
    }

}
