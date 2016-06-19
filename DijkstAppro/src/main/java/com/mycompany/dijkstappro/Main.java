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
       Kartta kartta = new Kartta("vaikea1.txt");
       Reittiopas opas = new Reittiopas(kartta);
        System.out.println("awureql " + opas.reitinHinta("awureql"));
        System.out.println("auyreql " + opas.reitinHinta("auyreql"));
        
        
        

  
          
    }
    
    public static void lol() {
        System.out.println("lol");
    }

}
