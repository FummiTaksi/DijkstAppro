/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import static com.mycompany.dijkstappro.Main.kartta;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author mustonea
 */
public class Astar {
   
    
    public Astar(Baari lahto, Baari maali,Kartta kartta) {
        aStar(lahto,maali,kartta.getKartta());
    }
    
    
    public static int aStar(Baari lahto, Baari maali,char[][] kartta) {
        int[][] manhattan = new int[100][100];
        int maaliY = maali.getY();
        int maaliX = maali.getX();
        for (int leveys = 0; leveys < kartta.length; leveys++) {
            for (int korkeus = 0; korkeus < kartta[0].length; korkeus++) {
                char kirjain = kartta[korkeus][leveys];
                if (kirjain != '#') {
                    manhattan[korkeus][leveys] = Math.abs(maaliX - leveys) + Math.abs(maaliY - korkeus);
                }
            }

        }
        PriorityQueue<Koordinaatti> openList = new PriorityQueue();
        HashSet<Koordinaatti> closedList = new HashSet();
        Koordinaatti loppu = new Koordinaatti(maali.getX(),maali.getY(),0);
        closedList.add(new Koordinaatti(lahto.getX(),lahto.getY(),0));
        while (!openList.contains(loppu)) {
            
        }
        
        return 0;
    }

}
