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

    /**
     * Saa parametrikseen x ja y koordinaatin seka id:n josta sen erottaa muista baari-olioista.
     * @param x
     * @param y
     * @param id
     */
    public Baari(int x, int y,int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    /**
     * palauttaa baarin x-koordinaatin
     * @return
     */
    public int getX() {
        return x;
    }
    
    /**
     * palauttaa Baarin y-koordinaatin
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * palauttaa baarin id:n
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     * Palauttaa baarin tiedot String-muodossa.
     * @return
     */
    @Override
   public String toString() {
       return   "x: " + x + " y: " + y;
   }
    
    /**
     * Vertailee baari olioita keskenaan koordinaattien perusteella.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Baari verrattava = (Baari) o;
        return (x == verrattava.getX() && y == verrattava.getY());
    }
}
