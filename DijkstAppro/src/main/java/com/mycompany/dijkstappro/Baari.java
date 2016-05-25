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
public class Baari {
    private int x;
    private int y;
    private String nimi;
    private int id;
    public Baari(String nimi,int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.nimi =nimi;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getId() {
        return Integer.parseInt(x + "" +  y);
    }
    @Override
    public String toString() {
        return nimi;
    }
    
    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Baari verrattava = (Baari) o;
        return (x == verrattava.getX() && y == verrattava.getY() && nimi.equals(verrattava.toString()));
    }
}
