package com.company.Inne;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *
 * @author Piotr
 */

public class Druzyna {
    private String nazwa;
    private Zawodnik[] zawodnicy;
    private boolean udzial;
    private int zwyciestwa = 0;//Liczba wygranych rozgrywek
    int liczba_zawodnikow;

    public Druzyna()                    //konstruktory muszą być public, Panie kompilatorze
    // Szanowny Panie Gagarin,wiem ale konstruktor bezparametrowy nie moze miec parametrow
    {

    }

    public Druzyna(String nazwa, int pkt) {          //nie usuwajcie tego konstruktora :D jest potrzebny do testowania

        // Ok ale potem i tak bedziemy korzystac z tego konstruktora ktory ma wiecej parametrow

        this.nazwa = nazwa;
        zwyciestwa = pkt;
    }

    public Druzyna(Druzyna var) {
        nazwa = var.nazwa;
        udzial = var.udzial;
        zwyciestwa = var.zwyciestwa;
        liczba_zawodnikow = var.liczba_zawodnikow;

        zawodnicy = new Zawodnik[liczba_zawodnikow];
        for (int i = 0; i < var.liczba_zawodnikow; i++) {

            zawodnicy[i] = var.zawodnicy[i];
        }
    }

    public Druzyna(String n, boolean u, int z, int lz)// Jeden konstruktor  do pobierania druzyn
    {
        nazwa = n;
        udzial = u;
        zwyciestwa = z;
        liczba_zawodnikow = lz;


    }


    //gettery:

    public Zawodnik[] getZawodnicy() {
        return zawodnicy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getPunkty() {
        return zwyciestwa;
    }

    public boolean getUdzial() {
        return udzial;
    }

    public int getLiczbaZawodnikow() {
        return liczba_zawodnikow;
    }
    //settery:

    public void setUdzial(boolean x) {
        udzial = x;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setPunkty(int pkt) {
        zwyciestwa = pkt;
    }

    public void zapełnij_miejsca_w_druzynie() {

        Scanner input = new Scanner(System.in);
        zawodnicy = new Zawodnik[liczba_zawodnikow];
        for (int i = 0; i < liczba_zawodnikow; i++) {
            String im, n;
            int w;
            System.out.println("Podaj imie ");
            im = input.next();
            System.out.println("Podaj nazwisko ");
            n = input.next();
            System.out.println("Podaj wiek ");
            w = input.nextInt();


            zawodnicy[i] = new Zawodnik(im, n, w);

        }


    }

    public void zapelnij_miejsca_w_druzynie_dla_pliku(Zawodnik tablica[])//Tylko dla wczytywania z pliku, rozwiazalem tam to troche inaczej
    {
        if (liczba_zawodnikow != tablica.length) {
            System.out.println("Niepoprawny format.");
            return;
        }
        zawodnicy = new Zawodnik[liczba_zawodnikow];

        for (int i = 0; i < liczba_zawodnikow; i++)
            zawodnicy[i] = tablica[i];

    }

    public Zawodnik zwroc_o_podanym_indeksie(int indeks)//Numerujemy od zera
    {
        if (indeks >= liczba_zawodnikow) {
            System.out.println("Niepoprawny indeks");
            return null;
        } else

            return zawodnicy[indeks];
    }

    public void dodaj_zyciestwo() {
        zwyciestwa++;

    }


}
