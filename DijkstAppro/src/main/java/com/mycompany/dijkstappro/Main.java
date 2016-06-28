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
//          Kayttoliittyma liittyma = new Kayttoliittyma();    
//Kartta kartta = new Kartta();
//        System.out.println(kartta.getTarkistus());
//Kartta kartta = new Kartta();
        Suorituskyky testi  = new Suorituskyky();
        System.out.println(testi.reitinHaku());
//        Reittiopas opas = new Reittiopas(new Kartta("esim1.txt"));
//        opas.haeReittiOptimoitu();
//        System.out.println(opas.palautaReitti());

    }

    public static void lol() {
        System.out.println("lol");
    }

}
