
package com.company.RodzajeRozgrywek;

import com.company.Sedziowie.*;

/**
 * @author Piotr
 */
//Klasa abstrakcyjna Mecz, Nie mozna tworzyc jej obiektow
public abstract class Mecz {

    protected Sedzia sedzia;//Sedzia,ktory jest atrybutem kazdej z klas ktore dziedzicza z klasy mecz
    // Zmienne logiczne ktore przechowuja informacje o tym kto wygral dany mecz.
    // wynikA to zmienna ktora przechowuje  informacje o wygranej(true) druzyny A lub porazce(false) druzyny A,
    // z druzyna B jest analogicznie. Wstepnie te wartosci sa ustawione na false.
    protected boolean wynikA, wynikB;
    // Data meczu
    protected String miesiac;
    protected int dzien, rok;

    // Kazda z druzyn ma swoja skutecznosc w danym meczu(Mozna bedzie tez zrobic skutecznosc ogolna ze wszystkich meczy)
    protected float skutecznoscA = 0, skutecznoscB = 0;// W uproszczeniu stosunek zwyciestw do dlugosci gry. Skutecznosc jest liczona z pozimu metody abstrakcyjnej


    public Mecz()//Konstruktor bezparametrowy
    {

    }
    // Inne konstruktory niz bezparametrowy nie sa potrzebne
    // nie bedziemy tworzyc obiektow tej klasy


    //Settery:
    public void setSedzia(Sedzia ss) {

        sedzia = ss;


    }

    public void setData(int d, String m, int r) {
        dzien = d;
        miesiac = m;
        rok = r;
    }

    public void setWynikA(boolean b) {
        wynikA = b;
    }

    public void setWynikB(boolean b) {
        wynikB = b;
    }

    //Gettery:
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
    

     

