
package com.company.RodzajeRozgrywek;

import com.company.Sedziowie.*;


public abstract class Mecz {

    protected Sedzia sedzia;
    // Zmienne logiczne ktore przechowuja informacje o tym kto wygral dany mecz.
    // wynikA to zmienna ktora przechowuje  informacje o wygranej(true) druzyny A lub porazce(false) druzyny A,
    // z druzyna B jest analogicznie. Wstepnie te wartosci sa ustawione na false.
    protected boolean wynikA, wynikB;
    // Data meczu
    protected String miesiac;
    protected int dzien, rok;

    // Kazda z druzyn ma swoja skutecznosc w danym meczu
    protected float skutecznoscA = 0, skutecznoscB = 0;


    public Mecz()//Konstruktor bezparametrowy
    {

    }


    public Sedzia getSedzia() {
        return sedzia;
    }

    public boolean getWynikA() {
        return wynikA;
    }

    public boolean getWynikB() {
        return wynikB;
    }

    public float getSkutecznoscA() {
        return skutecznoscA;
    }

    public float getSkutecznoscB() {
        return skutecznoscB;
    }


    public int getDzien() {
        return dzien;
    }

    public String getMiesiac() {
        return miesiac;
    }

    ;

    public int getRok() {
        return rok;
    }

    ;

    public abstract void skutecznosc();//Metoda  abstrakcyjna w  zaleznosci od dyscypliny liczy skutecznosc w danym meczu dla kazdej druzyny


}
    

     

