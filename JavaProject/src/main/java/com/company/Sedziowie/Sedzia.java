
package com.company.Sedziowie;


public class Sedzia {
    protected String simie, snazwisko;
    protected int iloscSedziowan = 0;

    public Sedzia()
    {

    }

    public Sedzia(String simie, String snazwisko, int iloscSedziowan) {
        this.simie = simie;
        this.snazwisko = snazwisko;
        this.iloscSedziowan = iloscSedziowan;

    }


    public Sedzia(Sedzia var) {
        simie = var.simie;
        snazwisko = var.snazwisko;
        iloscSedziowan = var.iloscSedziowan;
    }


    public void setImie(String simie)

    {
        this.simie = simie;
    }

    public void setNazwisko(String snazwisko) {
        this.snazwisko = snazwisko;
    }

    public void setiloscSedziowan(int iloscSedziowan) {
        this.iloscSedziowan = iloscSedziowan;
    }

    public String getImie() {
        return simie;
    }

    public String getNazwisko() {
        return snazwisko;
    }

    public int getiloscSedziowan() {
        return iloscSedziowan;
    }

    @Override
    public String toString() {
        return "Sedzia{" +
                "simie='" + simie + '\'' +
                ", snazwisko='" + snazwisko + '\'' +
                ", iloscSedziowan=" + iloscSedziowan +
                '}';
    }

    public void zwieksz_liczbe_sedziowanych_meczyoJEDEN() {
        iloscSedziowan++;
    }


}
