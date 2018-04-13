/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.Sedziowie;

/**
 * @author szymo
 */
public class Sedzia {
    protected String simie, snazwisko;
    protected int iloscSedziowan = 0;

    public Sedzia() {

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

    public String toString() {
        return simie + " " + snazwisko + " ilość sędziowanych meczy:  " + iloscSedziowan;
    }

    public void zwieksz_liczbe_sedziowanych_meczyoJEDEN() {
        iloscSedziowan++;
    }


}
