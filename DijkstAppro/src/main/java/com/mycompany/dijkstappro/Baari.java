/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

/**
 * Baari-olio kartassa esiintyvalle baarille.
 * @author mustonea
 */
public class Baari {
    private int x;
    private int y;
    private int id;
    public Baari(int x, int y,int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }
    
   @Override
   public String toString() {
       return "x: " + x + " y: " + y;
   }
    
    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Baari verrattava = (Baari) o;
        return (x == verrattava.getX() && y == verrattava.getY());
    }
}
