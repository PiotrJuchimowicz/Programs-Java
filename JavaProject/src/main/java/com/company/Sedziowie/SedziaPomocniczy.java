
package com.company.Sedziowie;


public class SedziaPomocniczy extends Sedzia {
    public SedziaPomocniczy(String simie, String snazwisko, int iloscSedziowan) {
        this.simie = simie;
        this.snazwisko = snazwisko;
        this.iloscSedziowan = iloscSedziowan;

    }

    public SedziaPomocniczy() {

    }

    public SedziaPomocniczy(Sedzia var) {
        simie = var.simie;
        snazwisko = var.snazwisko;
        iloscSedziowan = var.iloscSedziowan;
    }

    @Override
    public String toString() {
        return "SedziaPomocniczy{" +
                "simie='" + simie + '\'' +
                ", snazwisko='" + snazwisko + '\'' +
                ", iloscSedziowan=" + iloscSedziowan +
                '}';
    }
}
