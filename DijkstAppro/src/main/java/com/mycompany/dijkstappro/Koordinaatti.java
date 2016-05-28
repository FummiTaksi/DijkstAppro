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
public class Koordinaatti implements Comparable{
    private int x;
    private int y;
    private int etaisyys;
            
    public Koordinaatti(int x, int y,int etaisyys) {
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getEtaisyys() {
        return etaisyys;
    }
    
    @Override
    public String toString() {
        return "x " + x + " y " + y;
    }

    @Override
    public int compareTo(Object t) {
        Koordinaatti verrattava = (Koordinaatti) t;
        return verrattava.getEtaisyys() - etaisyys;
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
