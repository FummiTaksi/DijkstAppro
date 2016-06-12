/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

/**
 * Luokan tarkoituksena kuvata  kartassa olevia pisteita ,jotka voivat olla mita vain paitsi seinaa (#).
 * @author mustonea
 */
public class Koordinaatti implements Comparable{
    private int x;
    private int y;
    private int hinta;
   

    /**
     *
     * @param x
     * @param y
     * @param hinta Hinta on Manhattan-etaisyys loppupisteeseen + etaisyys alkupisteeseen.
     */
    public Koordinaatti(int x, int y,int hinta) {
        this.x = x;
        this.y = y;
        this.hinta = hinta;
    }
    
    /**
     * Palauttaa x-koordinaatin
     * @return
     */
    public int getX() {
        return x;
    }
    
    /**
     * Palauttaa y-koordinaatin.
     * @return
     */
    public int getY() {
        return y;
    }
    
    /**
     * Palauttaa koordinaatin etäisyyshinnan.Tätä käytetään hyväksi aStar algoritmissa.
     * @return
     */
    public int getHinta() {
        return hinta;
    }
        
    @Override
    public String toString() {
        return "x " + x + " y " + y;
    }

    /**
     * Vertaa Koordinaatti olioita toisiinsa perustuen hinta-muuttujaan.
     * @param t
     * @return
     */
    @Override
    public int compareTo(Object t) {
        Koordinaatti verrattava = (Koordinaatti) t;
        return verrattava.getHinta() - hinta;
    }
    
    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Koordinaatti verrattava = (Koordinaatti) o;
        return x == verrattava.getX() && y == verrattava.getY();
    }
    
}
