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
public class Minimikeko {

    private Koordinaatti[] taulukko;
    private int koko;

    /**
     * Minimikeko Koordinaatti-olioille.
     */
    public Minimikeko() {
        this.taulukko = new Koordinaatti[100];
        this.koko = 0;
    }

    /**
     * Lisaa uuden koordinaatti-olion kekoon sailyttaen minimikeko-jarjestyksen.
     *
     * @param koordinaatti
     */
    public void lisaa(Koordinaatti koordinaatti) {
        koko++;
        int lasku = koko;
        taulukko[koko] = koordinaatti;
        while (lasku / 2 > 0 && taulukko[lasku].getHinta() < taulukko[lasku / 2].getHinta()) {
//            System.out.println("täällä ei pitäisi olla");
            vaihdaAlkiot(lasku / 2, lasku);
            lasku /= 2;
        }
    }
   /**
    * True jos keko on tyhjä,false jos siellä on alkioita.
    * @return 
    */
    public boolean tyhja() {
        return koko == 0;
    }


    /**
     * Poistaa ja palauttaa pienimman alkion ja pitaa jarjestyksen ylla.
     *
     * @return
     */
    public Koordinaatti poistaPienin() {
        if (koko >= 1) {
            Koordinaatti palautus = taulukko[1];
            taulukko[1] = taulukko[koko];
            koko--;
            heapify(1);
            return palautus;
        }
        
        return null;
    }

    /**
     * Palauttaa keon oikeaan jarjestykseen indeksista alaspain.
     *
     * @param indeksi
     */
    public void heapify(int indeksi) {
//        System.out.println("olemme indeksissä " + indeksi);

        if (2 * indeksi + 1 <= koko) {
            if (taulukko[2 * indeksi].getHinta() < taulukko[2 * indeksi + 1].getHinta()) {
                if (taulukko[2 * indeksi].getHinta() < taulukko[indeksi].getHinta()) {
                    vaihdaAlkiot(indeksi, 2 * indeksi);
                    heapify(2 * indeksi);
                }
            } else if (taulukko[2 * indeksi + 1].getHinta() < taulukko[indeksi].getHinta()) {
                vaihdaAlkiot(indeksi, 2 * indeksi + 1);
                heapify(2 * indeksi + 1);
            }
        } else if (2 * indeksi == koko && taulukko[2 * indeksi].getHinta() < taulukko[indeksi].getHinta()) {
            vaihdaAlkiot(indeksi, 2 * indeksi);
            heapify(2 * indeksi);
        }

    }

    /**
     * Vaihtaa taulukossa indeksissa olevien alkioiden paikkaa.
     *
     * @param pieni
     * @param iso
     */
    public void vaihdaAlkiot(int pieni, int iso) {
        Koordinaatti parent = taulukko[pieni];
        taulukko[pieni] = taulukko[iso];
        taulukko[iso] = parent;
    }

    /**
     * Palauttaa keon taulukon.
     * @return
     */
    public Koordinaatti[] getTaulukko() {
        return taulukko;
    }

    /**
     * Alustaa taulukon uudelleen. 
     * @param uusiTaulukko
     */
    public void setTaulukko(Koordinaatti[] uusiTaulukko) {
        taulukko = uusiTaulukko;
    }

    /**
     * Palauttaa monta alkiota keossa on.
     * @return
     */
    public Integer getKoko() {
        return koko;
    }

    /**
     * Asettaa koon uudelleen.
     * @param uusiKoko
     */
    public void setKoko(int uusiKoko) {
        koko = uusiKoko;
    }
    /**
     * Palauttaa täsmälleen identtisen minimikeko-olion.
     * @return 
     */
    public Minimikeko kloonaa() {
        Minimikeko klooni = new Minimikeko();
        Koordinaatti[] kopioTaulukko = new Koordinaatti[100];
        for (int i = 1; i <= koko; i++) {
            kopioTaulukko[i] = taulukko[i];
        }
        klooni.setTaulukko(kopioTaulukko);
        klooni.setKoko(koko);
       return klooni;
    }
}
