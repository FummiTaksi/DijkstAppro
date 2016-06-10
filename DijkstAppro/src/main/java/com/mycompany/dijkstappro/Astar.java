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
 * Luokan tehtavana suorittaa aStar-algoritmi halutulle kartalle.
 *
 * @author mustonea
 */
public class Astar {

    private int[][] vierailu;
    private int[][] etaisyysAlusta;
    private Minimikeko keko;
    private Koordinaatti[][] parent;
    private Kartta kartta;
    private int[][] manhattan;      //ensin y, sitten x kuten muissakin taulukoissa.

    public Astar(Kartta kartta) {
        this.kartta = kartta;
    }

   
    public Kartta getKartta() {
        return kartta;
    }
    
    public void setKartta(Kartta uusiKartta) {
        this.kartta = uusiKartta;
    }

    public int aStar(Koordinaatti alku, Koordinaatti loppu) {
//        System.out.println("alku " + alku);
//        System.out.println("loppu " + loppu);
        this.vierailu = new int[100][100];
        this.etaisyysAlusta = new int[100][100];
        this.keko = new Minimikeko();
        this.parent = new Koordinaatti[100][100];
        this.manhattan = new int[100][100];
        for (int leveys = 0; leveys < kartta.getKartta().length; leveys++) {
            for (int korkeus = 0; korkeus < kartta.getKartta()[0].length; korkeus++) {
                char kirjain = kartta.getKartta()[korkeus][leveys];
                if (kirjain != '#') {
                    manhattan[korkeus][leveys] = Math.abs(loppu.getX() - leveys) + Math.abs(loppu.getY() - korkeus);
                }
            }

        }
//        System.out.println("manhattan alustettu");

//        System.out.println("alkuX " + alku.getX() + " alkuY " + alku.getY());
//        System.out.println("loppuX " + loppu.getX() + " loppuY " + loppu.getY());
        vieraile(alku.getX(), alku.getY(), 0, alku);
        while (vierailu[loppu.getY()][loppu.getX()] != 2) {
//            System.out.println("loop");
            Koordinaatti lahin = keko.poistaPienin();
//            System.out.println("Lähin " + lahin);
            vierailu[lahin.getY()][lahin.getX()] = 2;
            vieraile(lahin.getX() - 1, lahin.getY() - 1, 14, lahin);
            vieraile(lahin.getX(), lahin.getY() - 1, 10, lahin);
            vieraile(lahin.getX() + 1, lahin.getY() - 1, 14, lahin);
            vieraile(lahin.getX() - 1, lahin.getY(), 10, lahin);
            vieraile(lahin.getX() + 1, lahin.getY(), 10, lahin);
            vieraile(lahin.getX() - 1, lahin.getY() + 1, 14, lahin);
            vieraile(lahin.getX(), lahin.getY() + 1, 10, lahin);
            vieraile(lahin.getX() + 1, lahin.getY() + 1, 14, lahin);
        }

//        System.out.println("loppukoordinaatti löydetty");
        int palautus = 0;
        while (!loppu.equals(alku)) {
//            System.out.println("x " + loppu.getX() + " y " + loppu.getY());
            Koordinaatti seuraava = parent[loppu.getY()][loppu.getX()];
            int liike = Math.abs(seuraava.getX() - loppu.getX()) + Math.abs(seuraava.getY() - loppu.getY());
            if (liike == 1) {
                palautus += 10;
            } else if (liike == 2) {
                palautus += 14;
            }
            loppu = seuraava;
        }

        return palautus;
    }

    /**
     * Lisaa koordinaatin (x,y) vierailluksi.
     *
     * @param x
     * @param y
     * @param arvo
     * @param mista
     */
    public void vieraile(int x, int y, int arvo, Koordinaatti mista) {

//        System.out.println("y " + y + " x " + x);
//        
        if (kartta.getKartta()[y][x] != '#' && vierailu[y][x] != 2) {
            if (vierailu[y][x] == 0) {
                //System.out.println("lisätään openListaan alkio x " + x + " y " + y);
                etaisyysAlusta[y][x] = etaisyysAlusta[mista.getY()][mista.getX()] + arvo;
                keko.lisaa(new Koordinaatti(x, y, manhattan[y][x] + etaisyysAlusta[y][x]));

                vierailu[y][x] = 1;
//                System.out.println("x " + x + " y " + y + " parent on " + mista);
                parent[y][x] = mista;
            }
            Koordinaatti jalkelainen = parent[mista.getY()][mista.getX()];
            if (etaisyysAlusta[jalkelainen.getY()][jalkelainen.getX()] > etaisyysAlusta[y][x]) {
//                System.out.println("tsekkaus");
//                System.out.println("mista: " + mista);
//                System.out.println("menossa :  x " + x + " y " + y);
                parent[mista.getY()][mista.getX()] = new Koordinaatti(x, y, manhattan[y][x] + etaisyysAlusta[y][x]);
            }

        }

    }

}
