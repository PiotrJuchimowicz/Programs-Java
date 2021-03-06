package com.company.Inne;

import java.util.Arrays;
import java.util.Scanner;


public class Druzyna {
    private String nazwa;
    private Zawodnik[] zawodnicy;
    private boolean udzial;
    private int zwyciestwa = 0;//Liczba wygranych rozgrywek
    int liczba_zawodnikow;


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

    public void setUdzial(boolean x) {
        udzial = x;
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


    public void dodaj_zyciestwo() {
        zwyciestwa++;

    }

    @Override
    public String toString() {
        return "Druzyna{" +
                "nazwa='" + nazwa + '\'' +
                ", zawodnicy=" + Arrays.toString(zawodnicy) +
                ", udzial=" + udzial +
                ", zwyciestwa=" + zwyciestwa +
                ", liczba_zawodnikow=" + liczba_zawodnikow +
                '}';
    }
}
