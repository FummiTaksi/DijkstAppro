/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.util.ArrayList;

/**
 *
 * @author mustonea
 */
public class Kartta {
    ArrayList<Baari> baarit;
    
    public Kartta() {
        this.baarit =new ArrayList();
    }
    
    public void lisaaBaari(Baari baari) {
        baarit.add(baari);
    }
    
    public ArrayList<Baari> getBaarit() {
        return baarit;
    }
}
