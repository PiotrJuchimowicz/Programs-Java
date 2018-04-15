
package com.company.Inne;


public class Zawodnik {
    protected String imie, nazwisko;
    protected int wiek;

   
    public Zawodnik(String i, String n, int w) {
        imie = i;
        nazwisko = n;
        wiek = w;

    }


    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Zawodnik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
