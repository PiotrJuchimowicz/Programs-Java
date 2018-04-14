package com.company.Gry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import com.company.Sedziowie.*;
import com.company.Inne.*;
import com.company.RodzajeRozgrywek.*;
import com.company.Komparator.*;

public class Gra {
    private ArrayList<Rozgrywki> Rozgrywki = new ArrayList<Rozgrywki>();
    private ArrayList<Sedzia> Sedziowie = new ArrayList<Sedzia>();
    private ArrayList<Druzyna> Druzyny = new ArrayList<Druzyna>();

    public ArrayList<Druzyna> getDruzyny() {
        return Druzyny;
    }

    public void dodajSedziego(Sedzia x) {
        Sedziowie.add(x);
    }

    public void usunSedziego(Sedzia x) {
        Sedziowie.remove(x);
    }

    public Sedzia szukajSedziego(String imie, String nazwisko) {
        for (Sedzia s : Sedziowie)
            if (s.getImie().equals(imie) && s.getNazwisko().equals(nazwisko))
                return s;
        return null;
    }

    public ArrayList<Sedzia> getSedziowie() {
        return Sedziowie;
    }

    public void wyswietlRozgrywki() {
        for (Rozgrywki r : Rozgrywki) {
            System.out.println(r.getDruzynaA().getNazwa() + "-" + r.getDruzynaB().getNazwa() + "\n");
        }
    }

    public boolean czy_Istnieje_Sedzia(Sedzia s) {
        if (Sedziowie.contains(s))
            return true;
        else
            return false;
    }

    public boolean czy_jest_sedzia_o_ImieniuiNaziwsku(String imie, String nazwisko) {
        for (int i = 0; i < Sedziowie.size(); i++) {
            if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko))
                return true;
        }
        return false;
    }

    public void wyswietlSedziow() {
        int i = 1;
        for (Sedzia s : Sedziowie) {
            System.out.println(i + "." + " " + s.getImie() + " " + s.getNazwisko() + " " + s.getiloscSedziowan());
            i++;
        }
    }

    public void wyswietlWszystkieDruzyny() {
        int i = 1;
        for (Druzyna d : Druzyny) {
            System.out.println(i + "." + " " + d.getNazwa() + " " + d.getPunkty());
            i++;
        }
    }

    public void wyswietlDruzynyGrajace() {
        int i = 1;
        for (Druzyna d : Druzyny) {
            if (d.getUdzial()) {
                System.out.println(i + "." + " " + d.getNazwa() + " " + d.getPunkty());
                i++;
            }
        }
    }

    public void dodajDruzyne(Druzyna x) {
        Druzyny.add(x);
    }

    public Druzyna szukajDruzyne(String x) {             //szuka i zwraca druzyne
        for (Druzyna d : Druzyny)

            if (d.getNazwa().equals(x))
                return d;

        return null;
    }

    public boolean Czy_Istnieje_Druzyna_o_takiej_nazwie(String nazwa) {
        for (int i = 0; i < Druzyny.size(); i++) {
            if (Druzyny.get(i).getNazwa().equals(nazwa))
                return true;
        }
        return false;
    }

    public void wycofajDruzyne(Druzyna x) {              //wycofuje druzyne, ale nie usuwa jej
        x.setUdzial(false);
    }

    public void usunDruzyne(Druzyna x) {                 // usuwa druzyne
        Druzyny.remove(x);
    }

    public void dodajRozgrywki(Rozgrywki x) {            //dodaje rozgrywki
        Rozgrywki.add(x);
    }

    public void usunRozgrywki(Rozgrywki x) {             //usuwa rozgrywki
        Rozgrywki.remove(x);
    }

    public ArrayList<Rozgrywki> GetRozgrywki() {
        return Rozgrywki;
    }

    public Rozgrywki szukajRozgrywki(Druzyna x, Druzyna y) {                         //szuka rozgrywki na podstawie podanych druzyn
        for (Rozgrywki r : Rozgrywki) {
            if ((r.getDruzynaA().equals(x)) && (r.getDruzynaB().equals(y)))
                return r;
            else if ((r.getDruzynaB().equals(x)) && (r.getDruzynaA().equals(y)))
                return r;
        }
        return null;
    }


    public void Wczytywanie_druzyn_z_pliku(Scanner input) throws FileNotFoundException// Doda konkretna druzyne do bazy danych tylko wtedy gdy jeszcze jej tam nie ma
    {
        LinkedList<Druzyna> lista_druzyn = new LinkedList<Druzyna>();
        String nazwa_pliku;


        System.out.println("Podaj nazwe pliku");
        nazwa_pliku = input.next();

        File plik = new File(nazwa_pliku);
        Scanner skaner = new Scanner(plik);

        int liczba;
        String udzial, napis;


        Scanner wykrywacz = new Scanner(plik);//Pomocniczy Scanner ktory slozy do wykrywania konca pliku  badz konca danej druzyny
        while (true) //Wczytuje do napotkania napisu koniec
        {
            if (wykrywacz.next().equals("koniec"))
                break;
            napis = skaner.next();
            wykrywacz.nextInt();
            liczba = skaner.nextInt();//Wczytuje liczbe punktow(Liczba wygranych rozgrywek)
            if (wykrywacz.next().equals("koniec"))
                break;
            udzial = skaner.next();//Wczytuje informacje o udziale w rozgrywkach
            // Przetwarza informacje o rozgrywkach na typ logiczny
            boolean udzial_logiczny;
            if (udzial.equals("tak"))
                udzial_logiczny = true;
            else
                udzial_logiczny = false;

            String im, nazw;//Zmienne pomocnicze do przechowywania imienia i nazwiska zawodnika
            int w;//Zmienna pomocnicza do przechowywania wieku
            LinkedList<Zawodnik> lista_pomocnicza = new LinkedList<Zawodnik>();//Tworze liste pomocnicza z zawodnikami


            while (true)//Wczytuje do Druzyny
            {
                if (wykrywacz.next().equals("koniec")) {
                    skaner.next();// Ta linijka musi byc poniewaz skaner bez niej pozostaje przy wczytywaniu wieku zawodnika
                    // a my chcemy wczytywac nazwe druzyny. Bez niej pierwsza operacja na skanerze bedzie wczytywala napis koniec
                    break;
                }

                im = skaner.next();//Wczytuje imie

                if (wykrywacz.next().equals("koniec"))
                    break;
                nazw = skaner.next();//Wczytuje nazwisko

                wykrywacz.nextInt();
                w = skaner.nextInt();//Wczytuje wiek


                String pom;

                Zawodnik pomocniczy_zawodnik = new Zawodnik(im, nazw, w);//Tworze zmienna pomocnicza klasy Zawodnik

                lista_pomocnicza.add(pomocniczy_zawodnik);//Dodaje ja do listy zawodnikow

            }


            Zawodnik[] tablica = new Zawodnik[lista_pomocnicza.size()]; //Tworze tablice do przechowania zawodnikow
            for (int i = 0; i < lista_pomocnicza.size(); i++)//Uzupelniam te tablice zawodnikami z listy pomocniczej
                tablica[i] = lista_pomocnicza.get(i);

            Druzyna d = new Druzyna(napis, udzial_logiczny, liczba, lista_pomocnicza.size());//Tworze obiekt klasy druzyna
            d.zapelnij_miejsca_w_druzynie_dla_pliku(tablica);


            lista_druzyn.add(d);//Dodaje druzyne do listy druzyn


        }
        skaner.close();
        wykrywacz.close();


        przenies_wczytane_druzyny_z_pliku(lista_druzyn);


    }

    public void przenies_wczytane_druzyny_z_pliku(LinkedList<Druzyna> lista)//Metoda przenosi wczytane druzyny z pliku do glownej listy
    {
        for (int i = 0; i < lista.size(); i++) {
            if (!Druzyny.contains(lista.get(i)))//Obiekty sa dodawane jesli ich nie ma wcznesniej na tej liscie
                Druzyny.add(lista.get(i));
        }
    }

    public void Wczytywanie_Sedziow_z_pliku(Scanner inputt) throws FileNotFoundException {

        String nazwa_pliku;

        System.out.println("Podaj nazwe pliku");
        nazwa_pliku = inputt.next();
        File plik = new File(nazwa_pliku);//Tworze obiekty kasy Scanner do czytania z pliku
        Scanner skaner = new Scanner(plik);
        String im, nazw, typ;//Tu beda przechowywane atrybuty sedziego
        int liczba;//TU bedzie przechowywane ile meczy sedziowal


        while (true) {
            //Wczytuje atrybuty sedziow do napotaknia napisu koniec oznaczajacego koniec pliku
            im = skaner.next();
            if (im.equals("koniec"))
                break;

            nazw = skaner.next();

            liczba = skaner.nextInt();

            typ = skaner.next();
            //Rozrozniam sedziego glownego od pomocniczego
            if (typ.equals("glowny")) {
                Sedzia sg = new Sedzia(im, nazw, liczba);
                if (!Sedziowie.contains(sg))// Obiekty sa dodawane jesli ich nie ma wcznesniej na tej liscie
                    Sedziowie.add(sg);
            } else if (typ.equals("pomocniczy")) {
                Sedzia sp = new SedziaPomocniczy(im, nazw, liczba);
                if (!Sedziowie.contains(sp))// Obiekty sa dodawane jesli ich nie ma wcznesniej na tej liscie

                    Sedziowie.add(sp);
            }
        }


        skaner.close();

    }

    public void Wczytywanie_Rozgrywek_z_Pliku(Scanner input) throws FileNotFoundException {

        String nazwa_pliku;
        System.out.println("Podaj nazwe pliku");
        nazwa_pliku = input.next();
        File plik = new File(nazwa_pliku);
        Scanner skaner = new Scanner(plik);
        String nazwaA, nazwaB;
        int pom = 0, ile_rozgrywek;
        System.out.println("Podaj ile jest rozgrywek zapisanych w pliku");
        ile_rozgrywek = input.nextInt();
        while (pom < ile_rozgrywek) {

            nazwaA = skaner.next();//

            nazwaB = skaner.next();//
            boolean czyjestA, czyjestB;
            czyjestA = Czy_Istnieje_Druzyna_o_takiej_nazwie(nazwaA);
            czyjestB = Czy_Istnieje_Druzyna_o_takiej_nazwie(nazwaB);
            if (czyjestA) {
                System.out.println("W bazie danych istnieje druzyna o nazwie " + nazwaA);
                for (int j = 0; j < Druzyny.size(); j++) {
                    if (Druzyny.get(j).getNazwa().equals(nazwaA))
                        Druzyny.get(j).setUdzial(true);
                }
            } else {
                System.out.println("W bazie danych nie istnieje druzyna o nazwie " + nazwaA);
                System.out.println("Stworz ta druzyne");
                int liczba_zawodnikow;
                System.out.println("Podaj ilu zawodnikow liczy druzyna");
                liczba_zawodnikow = input.nextInt();
                Druzyna d = new Druzyna(nazwaA, true, 0, liczba_zawodnikow);
                d.zapełnij_miejsca_w_druzynie();
                Druzyny.add(d);

            }
            if (czyjestB) {
                System.out.println("W bazie danych istnieje druzyna o nazwie " + nazwaB);
                for (int j = 0; j < Druzyny.size(); j++) {
                    if (Druzyny.get(j).getNazwa().equals(nazwaB))
                        Druzyny.get(j).setUdzial(true);
                }

            } else {
                System.out.println("W bazie danych nie istnieje druzyna o nazwie " + nazwaB);
                System.out.println("Stworz ta druzyne");
                int liczba_zawodnikow;
                System.out.println("Podaj ilu zawodnikow liczy druzyna");
                liczba_zawodnikow = input.nextInt();
                Druzyna d = new Druzyna(nazwaB, true, 0, liczba_zawodnikow);
                d.zapełnij_miejsca_w_druzynie();
                Druzyny.add(d);

            }

            skaner.next();
            int dzien, rok;
            String miesiac;
            dzien = skaner.nextInt();
            miesiac = skaner.next();
            rok = skaner.nextInt();

            Sedzia glowny = null;
            SedziaPomocniczy pomocniczy1 = null, pomocniczy2 = null;
            skaner.next();
            String imie, nazwisko;
            imie = skaner.next();
            nazwisko = skaner.next();

            if (!czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {

                Sedzia sg = new Sedzia(imie, nazwisko, 1);
                Sedziowie.add(sg);
            } else {
                for (int i = 0; i < Sedziowie.size(); i++) {
                    if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko)) {
                        Sedziowie.get(i).zwieksz_liczbe_sedziowanych_meczyoJEDEN();

                    }
                }
            }
            for (int u = 0; u < Sedziowie.size(); u++) {
                if (Sedziowie.get(u).getImie().equals(imie) && Sedziowie.get(u).getNazwisko().equals(nazwisko))
                    glowny = new Sedzia(Sedziowie.get(u));

            }
            skaner.next();
            imie = skaner.next();
            nazwisko = skaner.next();


            if (!czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {

                Sedzia sp1 = new SedziaPomocniczy(imie, nazwisko, 1);
                Sedziowie.add(sp1);
            } else {
                for (int i = 0; i < Sedziowie.size(); i++) {
                    if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko)) {
                        Sedziowie.get(i).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                    }
                }
            }
            for (int u = 0; u < Sedziowie.size(); u++) {
                if (Sedziowie.get(u).getImie().equals(imie) && Sedziowie.get(u).getNazwisko().equals(nazwisko))
                    pomocniczy1 = new SedziaPomocniczy(Sedziowie.get(u));

            }

            skaner.next();
            imie = skaner.next();
            nazwisko = skaner.next();


            if (!czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {

                Sedzia sp2 = new SedziaPomocniczy(imie, nazwisko, 1);
                Sedziowie.add(sp2);
            } else {
                for (int i = 0; i < Sedziowie.size(); i++) {
                    if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko)) {
                        Sedziowie.get(i).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                    }
                }
            }
            int wynikA, wynikB;
            for (int u = 0; u < Sedziowie.size(); u++) {
                if (Sedziowie.get(u).getImie().equals(imie) && Sedziowie.get(u).getNazwisko().equals(nazwisko))
                    pomocniczy2 = new SedziaPomocniczy(Sedziowie.get(u));

            }

            skaner.next();

            wynikA = skaner.nextInt();

            skaner.next();
            wynikB = skaner.nextInt();

            Siatkowka ms = new Siatkowka(glowny, pomocniczy1, pomocniczy2, dzien, miesiac, rok, wynikA, wynikB);

            skaner.next();
            skaner.next();
            skaner.next();


            dzien = skaner.nextInt();
            miesiac = skaner.next();
            rok = skaner.nextInt();
            imie = skaner.next();
            nazwisko = skaner.next();

            if (!czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                System.out.println("Sedzia " + imie + " " + nazwisko + " nie istnieje w bazie danych");
                System.out.println("Zostanie dodany");
                Sedzia sg = new Sedzia(imie, nazwisko, 1);
                Sedziowie.add(sg);
            } else {
                for (int i = 0; i < Sedziowie.size(); i++) {
                    if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko)) {
                        Sedziowie.get(i).zwieksz_liczbe_sedziowanych_meczyoJEDEN();

                    }
                }
            }
            for (int u = 0; u < Sedziowie.size(); u++) {
                if (Sedziowie.get(u).getImie().equals(imie) && Sedziowie.get(u).getNazwisko().equals(nazwisko))
                    glowny = new Sedzia(Sedziowie.get(u));

            }

            skaner.next();
            float wynikAA, wynikBB;
            wynikAA = skaner.nextFloat();
            skaner.next();
            wynikBB = skaner.nextFloat();
            int numer_wygranej;
            numer_wygranej = skaner.nextInt();
            boolean zwyciestwoA = false, zwyciestwoB = false;
            if (wynikA == 1)
                zwyciestwoA = true;
            else
                zwyciestwoB = true;

            PrzeciaganieLiny mpl = new PrzeciaganieLiny(glowny, zwyciestwoA, zwyciestwoB, wynikAA, wynikBB, dzien, miesiac, rok);

            skaner.next();
            skaner.next();
            skaner.next();


            dzien = skaner.nextInt();
            miesiac = skaner.next();
            rok = skaner.nextInt();
            imie = skaner.next();
            nazwisko = skaner.next();

            if (!czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {

                Sedzia sg = new Sedzia(imie, nazwisko, 1);
                Sedziowie.add(sg);
            } else {
                for (int i = 0; i < Sedziowie.size(); i++) {
                    if (Sedziowie.get(i).getImie().equals(imie) && Sedziowie.get(i).getImie().equals(nazwisko)) {
                        Sedziowie.get(i).zwieksz_liczbe_sedziowanych_meczyoJEDEN();

                    }
                }
            }
            for (int u = 0; u < Sedziowie.size(); u++) {
                if (Sedziowie.get(u).getImie().equals(imie) && Sedziowie.get(u).getNazwisko().equals(nazwisko))
                    glowny = new Sedzia(Sedziowie.get(u));

            }

            skaner.next();
            int wynikAAA, wynikBBB;
            wynikAAA = skaner.nextInt();
            skaner.next();
            wynikBBB = skaner.nextInt();

            numer_wygranej = skaner.nextInt();
            zwyciestwoA = false;
            zwyciestwoB = false;
            if (wynikA == 1)
                zwyciestwoA = true;
            else
                zwyciestwoB = true;

            DwaOgnie mdo = new DwaOgnie(glowny, zwyciestwoA, zwyciestwoB, wynikAAA, wynikBBB, dzien, miesiac, rok);
            Druzyna dA = null, dB = null;
            for (int j = 0; j < Druzyny.size(); j++) {
                if (Druzyny.get(j).getNazwa().equals(nazwaA))
                    dA = new Druzyna(Druzyny.get(j));
            }

            for (int j = 0; j < Druzyny.size(); j++) {
                if (Druzyny.get(j).getNazwa().equals(nazwaB))
                    dB = new Druzyna(Druzyny.get(j));
            }


            Rozgrywki r = new Rozgrywki(ms, mdo, mpl, dA, dB);
            r.zwyciezca(getDruzyny());
            Rozgrywki.add(r);
            pom++;
        }
        skaner.close();


    }




    public void sortowanieAlfabetyczne(ArrayList<Druzyna> Druzyny) {                     //sortowania
        Collections.sort(Druzyny, new Komparator());
    }

    public void sortowaniePunkty(ArrayList<Druzyna> Druzyny) {
        Collections.sort(Druzyny, new KomparatorPkt());
    }

    public void zapisDruzyny(ArrayList<Druzyna> Druzyny) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("Druzyny_zapisane.txt");
        for (Druzyna d : Druzyny) {
            zapis.println(d.getNazwa());
            zapis.println(d.getPunkty());
            if (d.getUdzial())
                zapis.println("tak");
            for (int i = 0; i < d.getZawodnicy().length; i++) {
                zapis.println(d.getZawodnicy()[i].getImie());
                zapis.println(d.getZawodnicy()[i].getNazwisko());
                zapis.println(d.getZawodnicy()[i].getWiek());
            }
            zapis.println("koniec");
        }
        zapis.println("koniec");
        zapis.close();
    }

    public void zapisSedziowie(ArrayList<Sedzia> Sedziowie) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("Sedziowie_zapisani.txt");
        for (Sedzia s : Sedziowie) {
            zapis.println(s.getImie());
            zapis.println(s.getNazwisko());
            zapis.println(s.getiloscSedziowan());
            if (s instanceof SedziaPomocniczy)
                zapis.println("pomocniczy");
            else
                zapis.println("glowny");
        }
        zapis.println("koniec");
        zapis.close();
    }


    public void zapisRozgrywki(ArrayList<Rozgrywki> Rozgrywki) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("Rozgrywki_zapisane.txt");
        for (Rozgrywki r : Rozgrywki) {
            zapis.println(r.getDruzynaA().getNazwa());
            zapis.println(r.getDruzynaB().getNazwa());
            zapis.println("Siatkowka");
            zapis.println(r.getMeczSiatkowki().getDzien());
            zapis.println(r.getMeczSiatkowki().getMiesiac());
            zapis.println(r.getMeczSiatkowki().getRok());
            zapis.println("glowny");
            zapis.println(r.getMeczSiatkowki().getSedzia().getImie());
            zapis.println(r.getMeczSiatkowki().getSedzia().getNazwisko());
            zapis.println("pomocniczy");
            zapis.println(r.getMeczSiatkowki().GetPomocniczy1().getImie());
            zapis.println(r.getMeczSiatkowki().GetPomocniczy1().getNazwisko());
            zapis.println("pomocniczy");
            zapis.println(r.getMeczSiatkowki().GetPomocniczy2().getImie());
            zapis.println(r.getMeczSiatkowki().GetPomocniczy2().getNazwisko());
            zapis.println("SetyA");
            zapis.println(r.getMeczSiatkowki().getSetA());
            zapis.println("SetyB");
            zapis.println(r.getMeczSiatkowki().getSetB());
            zapis.println("koniec");
            zapis.println("Przeciaganie liny");
            zapis.println(r.getMeczPzeciaganieLiny().getDzien());
            zapis.println(r.getMeczPzeciaganieLiny().getMiesiac());
            zapis.println(r.getMeczPzeciaganieLiny().getRok());
            zapis.println(r.getMeczPzeciaganieLiny().getSedzia().getImie());
            zapis.println(r.getMeczPzeciaganieLiny().getSedzia().getNazwisko());
            zapis.println("czasA");
            zapis.println(r.getMeczPzeciaganieLiny().getCzasPoStronieA());
            zapis.println("czasB");
            zapis.println(r.getMeczPzeciaganieLiny().getCzasPoStronieB());
            if (r.getMeczPzeciaganieLiny().getWynikA())
                zapis.println("1");
            else
                zapis.println("2");
            zapis.println("koniec");
            zapis.println("Dwa ognie");
            zapis.println(r.getMeczDwaOgnie().getDzien());
            zapis.println(r.getMeczDwaOgnie().getMiesiac());
            zapis.println(r.getMeczDwaOgnie().getRok());
            zapis.println(r.getMeczDwaOgnie().getSedzia().getImie());
            zapis.println(r.getMeczDwaOgnie().getSedzia().getNazwisko());
            zapis.println("zbiciA");
            zapis.println(r.getMeczDwaOgnie().getZbiciA());
            zapis.println("zbiciB");
            zapis.println(r.getMeczDwaOgnie().getZbiciB());
            if (r.getMeczDwaOgnie().getWynikA())
                zapis.println("1");
            else
                zapis.println("2");
        }
        zapis.close();
    }
}
