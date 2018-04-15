
package com.company.RodzajeRozgrywek;

import com.company.Sedziowie.*;



public class Siatkowka extends Mecz {

    private SedziaPomocniczy pomocniczy1;
    private SedziaPomocniczy pomocniczy2;


    private int setyA, setyB;//Sety wygrane przez kazda z druzyn

    //Konstruktory

    public Siatkowka()
    {

    }


    public Siatkowka(Sedzia s, SedziaPomocniczy sp1, SedziaPomocniczy sp2, int d, String m, int r, int sA, int sB) {
        sedzia = s;
        pomocniczy1 = sp1;
        pomocniczy2 = sp2;
        dzien = d;
        miesiac = m;
        rok = r;
        setyA = sA;
        setyB = sB;


    }


    public Siatkowka(Siatkowka var)
    {

        sedzia = new Sedzia(var.sedzia);
        pomocniczy1 = new SedziaPomocniczy(var.pomocniczy1);
        pomocniczy2 = new SedziaPomocniczy(var.pomocniczy2);
        dzien = var.dzien;
        miesiac = var.miesiac;
        rok = var.rok;
        setyA = var.setyA;
        setyB = var.setyB;

    }





    public Sedzia GetPomocniczy1() {
        return pomocniczy1;
    }

    public Sedzia GetPomocniczy2() {
        return pomocniczy2;
    }


    public void wynik_Siatkowki()//Metoda ktora okresla zwyciezce danego meczu, w przypadku remisu nie ma zwyciezcy
    {
        if (setyA > setyB) {
            wynikA = true;
            wynikB = false;
        } else if (setyB > setyA) {
            wynikB = true;
            wynikA = false;
        } else {
            wynikA = false;
            wynikB = false;
        }

    }

    public void skutecznosc() {
        int dlugosc_gry = setyA + setyB;
        skutecznoscA = (float) setyA / dlugosc_gry;
        skutecznoscB = (float) setyB / dlugosc_gry;
    }

    public int getSetA() {
        return setyA;
    }

    public int getSetB() {
        return setyB;
    }

    @Override
    public String toString() {
        return "Siatkowka{" +
                "pomocniczy1=" + pomocniczy1 +
                ", pomocniczy2=" + pomocniczy2 +
                ", setyA=" + setyA +
                ", setyB=" + setyB +
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


