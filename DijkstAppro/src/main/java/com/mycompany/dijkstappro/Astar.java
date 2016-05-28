/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

//import static com.mycompany.dijkstappro.Main.kartta;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author mustonea
 */
public class Astar {

    private TreeMap<Koordinaatti, Integer> openList;
    private HashSet<Koordinaatti> closedList;
    private Koordinaatti[][] parent;
    private Kartta kartta;
    private int[][] manhattan;      //ensin y, sitten x kuten muissakin taulukoissa.

    public Astar(Kartta kartta) {
        this.openList = new TreeMap();
        this.closedList = new HashSet();
        this.kartta = kartta;
        this.parent = new Koordinaatti[100][100];
        this.manhattan = new int[100][100];
    }
    
    public Kartta getKartta() {
        return kartta;
    }

    public int aStar(Koordinaatti alku, Koordinaatti loppu, char[][] kartta) {
        for (int leveys = 0; leveys < kartta.length; leveys++) {
            for (int korkeus = 0; korkeus < kartta[0].length; korkeus++) {
                char kirjain = kartta[korkeus][leveys];
                if (kirjain != '#') {
                    manhattan[korkeus][leveys] = Math.abs(loppu.getX() - leveys) + Math.abs(loppu.getY() - korkeus);
                }
            }

        }
        System.out.println("manhattan alustettu");
        
        System.out.println("alkuX " + alku.getX() + " alkuY " + alku.getY());
        System.out.println("loppuX " + loppu.getX() + " loppuY " + loppu.getY());
        addOpenList(alku.getX(), alku.getY(), 0, null);
        while (!openList.containsKey(loppu) || closedList.contains(loppu)) {
            Koordinaatti lahin = openList.firstKey();
            closedList.add(openList.pollFirstEntry().getKey());
            addOpenList(lahin.getX() - 1, lahin.getY() - 1, 14, lahin);
            addOpenList(lahin.getX(), lahin.getY() - 1, 10, lahin);
            addOpenList(lahin.getX() + 1, lahin.getY() - 1, 14, lahin);
            addOpenList(lahin.getX() - 1, lahin.getY(), 10, lahin);
            addOpenList(lahin.getX() + 1, lahin.getY(), 10, lahin);
            addOpenList(lahin.getX() - 1, lahin.getY() + 1, 14, lahin);
            addOpenList(lahin.getX(), lahin.getY() + 1, 10, lahin);
            addOpenList(lahin.getX() + 1, lahin.getY() + 1, 14, lahin);
            
            for (Koordinaatti koordinaatti : openList.keySet()) {
                System.out.println(koordinaatti);
            }
            System.out.println(openList.keySet().contains(loppu));

        }
        System.out.println("loppukoordinaatti löydetty");
        int palautus = 0;
        while (loppu != alku) {
            Koordinaatti seuraava = parent[loppu.getY()][loppu.getX()];
            int liike = Math.abs(seuraava.getX() - loppu.getX()) + Math.abs(seuraava.getY() - loppu.getY());
            if (liike == 1) {
                palautus += 10;
            }
            else if (liike == 2) {
                palautus += 14;
            }
            loppu = seuraava;
        }
        

        return palautus;
    }

    public void addOpenList(int x, int y, int arvo, Koordinaatti mista) {
        if (kartta.getKartta()[y][x] != '#' && !closedList.contains(new Koordinaatti(x, y, 0))) {
            if (!openList.containsKey(new Koordinaatti(x, y, 0))) {
                 //System.out.println("lisätään openListaan alkio x " + x + " y " + y);
                openList.put(new Koordinaatti(x, y, manhattan[y][x] + arvo), manhattan[y][x] + arvo);
                parent[y][x] = mista;  
            } 
            // nopeamman reitin tsekkaus puuttuu
        }
    }

}
