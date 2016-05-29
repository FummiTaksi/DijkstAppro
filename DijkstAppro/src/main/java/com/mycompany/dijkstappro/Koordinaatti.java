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
    private int etaisyysAlusta;

    /**
     *
     * @param x
     * @param y
     * @param hinta Hinta on Manhattan-etaisyys loppupisteeseen + etaisyys alkupisteeseen.
     * @param etaisyysAlusta Etaisyys aloituspisteesta.
     */
    public Koordinaatti(int x, int y,int hinta,int etaisyysAlusta) {
        this.x = x;
        this.y = y;
        this.hinta = hinta;
        this.etaisyysAlusta = etaisyysAlusta;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getHinta() {
        return hinta;
    }
    
    public int getEtaisyysAlusta() {
        return etaisyysAlusta;
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
