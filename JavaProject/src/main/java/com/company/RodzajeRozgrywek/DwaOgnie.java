/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.RodzajeRozgrywek;

import com.company.Sedziowie.*;


public class DwaOgnie extends Mecz {
    // Liczby zbitych przez kazda z druzyn
    private int liczba_zbitychA;
    private int liczba_zbitychB;


    public DwaOgnie() {

    }


    public DwaOgnie(Sedzia x1, boolean wynik1, boolean wynik2, int lA, int lB, int d, String m, int r)
    {
        sedzia = x1;
        wynikA = wynik1;
        wynikB = wynik2;
        liczba_zbitychA = lA;
        liczba_zbitychB = lB;
        dzien = d;
        miesiac = m;
        rok = r;
    }

    public DwaOgnie(DwaOgnie var) {
        sedzia = new Sedzia(var.sedzia);
        wynikA = var.wynikA;
        wynikB = var.wynikB;
        liczba_zbitychA = var.liczba_zbitychA;
        liczba_zbitychB = var.liczba_zbitychB;
        dzien = var.dzien;
        miesiac = var.miesiac;
        rok = var.rok;
    }


    // Tu skutecznosc bedzie liczona jako liczba zbitych przez jedna druzyne do wszystkich zbić
    public void skutecznosc() {

        int zbicia = liczba_zbitychA + liczba_zbitychB;//Liczba wszystkich zbic
        skutecznoscA = (float) liczba_zbitychA / zbicia;
        skutecznoscB = (float) liczba_zbitychB / zbicia;
    }

    public int getZbiciA() {
        return liczba_zbitychA;
    }

    public int getZbiciB() {
        return liczba_zbitychB;
    }

    public DwaOgnie(Sedzia s) {
        sedzia = s;
    }

    @Override
    public String toString() {
        return "DwaOgnie{" +
                "liczba_zbitychA=" + liczba_zbitychA +
                ", liczba_zbitychB=" + liczba_zbitychB +
                ", sedzia=" + sedzia +
                ", wynikA=" + wynikA +
                ", wynikB=" + wynikB +
                ", miesiac='" + miesiac + '\'' +
                ", dzien=" + dzien +
                ", rok=" + rok +
                ", skutecznoscA=" + skutecznoscA +
                ", skutecznoscB=" + skutecznoscB +
                '}';
    }
}
