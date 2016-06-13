/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.FileNotFoundException;

/**
 *
 * @author mustonea
 */
public class Suorituskyky {
    
    
    public Suorituskyky() {
        
    }
    
    public long reitinHaku(String kartta) throws FileNotFoundException {
        long alku = System.currentTimeMillis();
        Reittiopas opas = new Reittiopas(new Kartta(kartta));
        opas.haeReitti();
        return System.currentTimeMillis() - alku;
    }
}
