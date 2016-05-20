/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

/**
 *
 * @author mustonea
 */
public class Laskija {

    private double[][] etaisyydet = new double[100][100];
    
    public Laskija() { 
        this.etaisyydet = new double[100][100];
    }

    public double laskeEtaisyys(Baari a, Baari b) {
        int xEtaisyys = b.getX() - a.getX();
        int yEtaisyys = b.getY() - a.getY();
        int nelioidenSumma = (xEtaisyys * xEtaisyys) + (yEtaisyys * yEtaisyys);
        double etaisyys = Math.sqrt(nelioidenSumma);
        etaisyydet[a.getId()][b.getId()] = etaisyys;
        etaisyydet[b.getId()][a.getId()] = etaisyys;
        return etaisyys;
    }
    
    public double[][] getEtaisyysTaulukko() {
        return etaisyydet;
    }
}
