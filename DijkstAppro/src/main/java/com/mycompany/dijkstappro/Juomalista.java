/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dijkstappro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mustonea
 */
public class Juomalista {
    Minimikeko keko;
    
    public Juomalista(String tiedostonNimi) {
        this.keko = new Minimikeko();
    }
    
    public void alustaLista(String tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(new File(tiedosto),"UTF-8");
        while(lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] taulukko = rivi.split(" ");
            
        }
    }
}
