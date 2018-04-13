/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.RodzajeRozgrywek;

import com.company.Sedziowie.*;


public class PrzeciaganieLiny extends Mecz {
    // Skutecznosc bedzie tu liczona jako stosunek czasu liny po stronie A do czasu gry
    private float czaspostronieA;
    private float czaspostronieB;

    public PrzeciaganieLiny() {

    }

    public PrzeciaganieLiny(Sedzia s, boolean wynik1, boolean wynik2, float czA, float czB, int d, String m, int r) {
        sedzia = s;
        wynikA = wynik1;
        wynikB = wynik2;
        czaspostronieA = czA;
        czaspostronieB = czB;
        dzien = d;
        miesiac = m;
        rok = r;

    }

    public PrzeciaganieLiny(PrzeciaganieLiny var) {
        sedzia = new Sedzia(var.sedzia);
        wynikA = var.wynikA;
        wynikB = var.wynikB;
        czaspostronieA = var.czaspostronieA;
        czaspostronieB = var.czaspostronieB;
        dzien = var.dzien;
        miesiac = var.miesiac;
        rok = var.rok;
    }

    public void skutecznosc() {
        float czas = czaspostronieA + czaspostronieB;

        skutecznoscA = (float) czaspostronieA / czas;
        skutecznoscB = (float) czaspostronieB / czas;

    }

    public PrzeciaganieLiny(Sedzia s) {
        sedzia = s;
    }

    public float getCzasPoStronieA() {
        return czaspostronieA;
    }

    public float getCzasPoStronieB() {
        return czaspostronieB;
    }


}
