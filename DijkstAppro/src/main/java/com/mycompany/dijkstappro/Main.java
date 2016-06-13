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
//        Reittiopas opas = new Reittiopas(new Kartta("vaikea1.txt"));
//        opas.haeReitti();
//        System.out.println(opas);

          Suorituskyky testi = new Suorituskyky();
          System.out.println("aikaa kului " + testi.reitinHaku("vaikea1.txt"));
  
          
    }

}
