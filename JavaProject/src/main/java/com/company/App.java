package com.company;

import com.company.Gry.*;
import com.company.Inne.*;

import com.company.RodzajeRozgrywek.*;
import com.company.Sedziowie.*;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        String imie, nazwisko, nazwa, tmpudzial;
        int lz, punkty;
        boolean udzial;
        int iloscsedziowan;
        Scanner input =null;
        input = new Scanner(System.in);
        Gra gra = new Gra();

        int wybor1, wybor2;
        do {
            try {

                System.out.println(
                        "*******************************\n"
                                + "Rozgrywki na plazy Kopakabana\n"
                                + "*******************************\n");

                System.out.println("1.Zarzadzaj sedziami.");
                System.out.println("2.Zarzadzaj druzynami.");
                System.out.println("3.Zarzadzaj rozgrywkami.");
                System.out.println("4.Zakoncz program.");

                wybor1 = input.nextInt();




                switch (wybor1) {

                    case 1:
                        System.out.println(
                                "ZARZADZANIE SEDZIAMI\n"
                                        + "1.Dodaj sedziego glownego.\n"
                                        + "2.Usun sedziego.\n"
                                        + "3.Szukaj sedziego.\n"
                                        + "4.Wyswietl wszystkich sedziow.\n"
                                        + "5.Wczytaj sedziow z pliku.\n"
                                        + "6.Zapisz sedziow do pliku.\n"
                                        + "7.Powrot do menu glownego.\n"
                                        + "8. Dodaj sedziego pomocniczego\n"
                                        + "Twoj wybor:");
                        wybor2 = input.nextInt();
                        switch (wybor2) {

                            case 1:
                                System.out.println("DODAWANIE SEDZIEGO GLOWNEGO\n"
                                        + "Podaj dane w kolejnoúci: imie, nazwisko, ilość sedziowanych meczy.");
                                imie = input.next();
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    System.out.println("Taki sedzia juz istnieje w bazie danych");
                                    return;
                                }

                                iloscsedziowan = input.nextInt();
                                Sedzia s1 = new Sedzia(imie, nazwisko, iloscsedziowan);
                                gra.dodajSedziego(s1);
                                break;

                            case 2:
                                System.out.println("USUWANIE SEDZIEGO\n"
                                        + "Podaj dane w kolejnosci imie, nazwisko.");
                                imie = input.next();
                                nazwisko = input.next();

                                for (int i = 0; i < gra.getSedziowie().size(); i++) {
                                    if (gra.getSedziowie().get(i).getNazwisko().equals(nazwisko) && gra.getSedziowie().get(i).getImie().equals(imie)) {
                                        gra.usunSedziego(gra.getSedziowie().get(i));

                                    }

                                }
                                break;
                            case 3:
                                System.out.println("WYSZUKIWANIE SEDZIEGO\n"
                                        + "Podaj  dane w kolejnosci imie,nazwisko");
                                imie = input.next();
                                nazwisko = input.next();

                                System.out.println(gra.szukajSedziego(imie, nazwisko));
                                break;
                            case 4:
                                System.out.println("LISTA WSZYSTKICH SEDZIOW:\n");
                                gra.wyswietlSedziow();
                                break;
                            case 5:
                                gra.Wczytywanie_Sedziow_z_pliku(input);
                                break;
                            case 6:
                                gra.zapisSedziowie(gra.getSedziowie());
                                break;
                            case 7:
                                break;
                            case 8:

                                System.out.println("DODAWANIE SEDZIEGO POMOCNICZEGO\n"
                                        + "Podaj dane w kolejnosci: imie, nazwisko, ilosc sedziowanych meczy.");
                                imie = input.next();
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    System.out.println("Taki sedzia juz istnieje w bazie danych");
                                    return;
                                }
                                iloscsedziowan = input.nextInt();
                                Sedzia s2 = new SedziaPomocniczy(imie, nazwisko, iloscsedziowan);
                                gra.dodajSedziego(s2);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(
                                "ZARZADZANIE DRUZYNAMI\n"
                                        + "1.Dodaj druzyne.\n"
                                        + "2.Usun druzyne.\n"
                                        + "3.Zglos druzyne do rozgrywek\n"
                                        + "4.Wycofaj druzyne z rozgrywek.\n"
                                        + "5.Szukaj druzyny.\n"
                                        + "6.Wyswietl wszystkie druzyny.\n"
                                        + "7.Wyswietl druzyny grajace.\n"
                                        + "8.Wczytywanie druzyn z pliku.\n"
                                        + "9.Zapis druzyn do pliku.\n"
                                        + "10.Powrót do menu głównego.\n"
                                        + "11.Posortuj alfabetycznie.\n"
                                        + "12.Posortuj po punktach.\n"
                                        + "Twoj wybor: ");
                        wybor2 = input.nextInt();
                        switch (wybor2) {
                            case 1:
                                System.out.println("DODAWANIE DRUĮYNY\n");
                                System.out.println("Podaj dane w kolejnosci: nazwa druzyny, czy bierze udzial w rozgrywkach(T/N), ilosc punktow (zwyciestw), liczba zawodnikow.");
                                nazwa = input.next();
                                tmpudzial = input.next();
                                if ("T".equals(tmpudzial)) udzial = true;
                                else udzial = false;
                                punkty = input.nextInt();
                                lz = input.nextInt();
                                if (gra.Czy_Istnieje_Druzyna_o_takiej_nazwie(nazwa)) {
                                    System.out.println("Druzyna o takiej nazwie istnieje juz w bazie danych");
                                    break;
                                }
                                Druzyna d1 = new Druzyna(nazwa, udzial, punkty, lz);
                                System.out.println("Dodaj zawodnikow do druzyny");
                                d1.zapełnij_miejsca_w_druzynie();
                                gra.dodajDruzyne(d1);

                                break;
                            case 2:
                                System.out.println("USUWANIE DRUZYNY\n"
                                        + "Podaj nazwe druzyny:");
                                nazwa = input.next();


                                for (int i = 0; i < gra.getDruzyny().size(); i++) {
                                    if (gra.getDruzyny().get(i).getNazwa().equals(nazwa)) {
                                        gra.usunDruzyne(gra.getDruzyny().get(i));
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("ZGLASZANIE DRUZYNY DO ROZGRYWEK\n"
                                        + "Podaj nazwe druzyny:");
                                String nazwad = input.next();
                                gra.szukajDruzyne(nazwad);
                                for (int i = 0; i < gra.getDruzyny().size(); i++) {
                                    if (gra.getDruzyny().get(i).getNazwa().equals(nazwad)) {
                                        gra.getDruzyny().get(i).setUdzial(true);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("WYCOFYWANIE DRUZYNY Z ROZGRYWEK\n"
                                        + "Podaj nazwe druzyny:");
                                String nazwaw = input.next();
                                gra.szukajDruzyne(nazwaw);
                                for (int i = 0; i < gra.getDruzyny().size(); i++) {
                                    if (gra.getDruzyny().get(i).getNazwa().equals(nazwaw)) {
                                        gra.getDruzyny().get(i).setUdzial(false);
                                    }
                                }

                                break;
                            case 5:
                                System.out.println("WYSZUKIWANIE DRUZYNY\n"
                                        + "Podaj nazwe druzyny:");
                                String nazwas = input.next();
                                System.out.println(gra.szukajDruzyne(nazwas));
                                break;
                            case 6:
                                System.out.println("LISTA WSZYSTKICH DRUZYN:\n");//Warto jeszcze zawodnikow wyswietlic do kazdej druzyny
                                gra.wyswietlWszystkieDruzyny();
                                break;
                            case 7:
                                System.out.println("LISTA DRUZYN BIORACYCH UDZIA£ W ROZGRYWKACH:\n");
                                gra.wyswietlDruzynyGrajace();
                                break;
                            case 8:
                                gra.Wczytywanie_druzyn_z_pliku(input);
                                break;
                            case 9:
                                gra.zapisDruzyny(gra.getDruzyny());
                                break;
                            case 10:
                                break;
                            case 11:
                                System.out.println("Posortowana alfabetycznie lista druzyn: \n");
                                gra.sortowanieAlfabetyczne(gra.getDruzyny());
                                gra.wyswietlWszystkieDruzyny();
                                break;
                            case 12:
                                System.out.println("Posortowana lista druzyn wg punktow: \n");
                                gra.sortowaniePunkty(gra.getDruzyny());
                                gra.wyswietlWszystkieDruzyny();
                        }

                        break;
                    case 3:
                        System.out.println(
                                "ZARZĄDZANIE ROZGRYWKAMI\n"
                                        + "1.Dodaj rozgrywkę\n"
                                        + "2.Usuń rozgrywkę.\n"
                                        + "3.Szukaj rozgrywki.\n"
                                        + "4.Wczytywanie rozgrywki z pliku\n"
                                        + "5.Zapis rozgrywki do pliku.\n"
                                        + "6.Wyswietl wszystkie rozgrywki.\n"
                                        + "7.Powrot do menu glownego.\n"
                                        + "Twój wybór:");
                        wybor2 = input.nextInt();
                        switch (wybor2) {
                            case 1:
                                String nazwaA, nazwaB;
                                System.out.println("Podaj nazwe druzyny pierwszej");
                                nazwaA = input.next();
                                System.out.println("Podaj nazwe druzyny drugiej");
                                nazwaB = input.next();
                                for (int i = 0; i < gra.GetRozgrywki().size(); i++) {
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaA) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaB)) {
                                        System.out.println("Rozgrywka miedy takimi druzynami jest juz zapisana w bazie danych");
                                        break;
                                    }
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaB) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaA)) {
                                        System.out.println("Rozgrywka miedy takimi druzynami jest juz zapisana w bazie danych");
                                        break;
                                    }
                                }
                                int liczba_zawodnikowA, liczba_zawodnikowB;
                                System.out.println("Podaj liczbe zawodnikow dla druzyny pierwszej");
                                liczba_zawodnikowA = input.nextInt();
                                System.out.println("Podaj liczbe zawodnikow dla druzyny drugiej");
                                liczba_zawodnikowB = input.nextInt();
                                Druzyna dA = new Druzyna(nazwaA, true, 0, liczba_zawodnikowA);
                                System.out.println("Dodaj zawodnikow pierwszej druzyny");
                                dA.zapełnij_miejsca_w_druzynie();
                                if (!gra.Czy_Istnieje_Druzyna_o_takiej_nazwie(nazwaA))
                                    gra.getDruzyny().add(dA);
                                Druzyna dB = new Druzyna(nazwaB, true, 0, liczba_zawodnikowB);
                                System.out.println("Dodaj zawodnikow drugiej druzyny");
                                dB.zapełnij_miejsca_w_druzynie();
                                if (!gra.Czy_Istnieje_Druzyna_o_takiej_nazwie(nazwaB))
                                    gra.getDruzyny().add(dB);

                                System.out.println("Dodaj mecze w ktorych druzyny biora udzial");
                                System.out.println("Dodajesz mecz siatkowki");
                                String miesiac;
                                int rok, dzien;
                                int atrybutA, atrybutB;

                                System.out.println("Podaj dzien");
                                dzien = input.nextInt();
                                System.out.println("Podaj miesiac");
                                miesiac = input.next();
                                System.out.println("Podaj rok");
                                rok = input.nextInt();
                                System.out.println("Podaj sety wygrane przez druzyne nr 1");
                                atrybutA = input.nextInt();
                                System.out.println("Podaj sety wygrane przez druzyne nr 2");
                                atrybutB = input.nextInt();
                                System.out.println("Dodajesz sedziego glownego");
                                String imie_sedziego, nazwisko_sedziego;
                                System.out.println("Podaj imie");
                                imie = input.next();
                                System.out.println("Podaj nazwisko");
                                nazwisko = input.next();
                                Sedzia sglowny = null, spom1 = null, spom2 = null;
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    gra.szukajSedziego(imie, nazwisko).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                                    sglowny = new Sedzia(gra.szukajSedziego(imie, nazwisko));
                                } else {
                                    sglowny = new Sedzia(imie, nazwisko, 1);
                                    gra.getSedziowie().add(sglowny);
                                }
                                System.out.println("Dodajesz sedziego pomocniczego nr 1");

                                System.out.println("Podaj imie");
                                imie = input.next();
                                System.out.println("Podaj nazwisko");
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    gra.szukajSedziego(imie, nazwisko).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                                    spom1 = new SedziaPomocniczy(gra.szukajSedziego(imie, nazwisko));
                                } else {
                                    spom1 = new SedziaPomocniczy(imie, nazwisko, 1);
                                    gra.getSedziowie().add(spom1);
                                }
                                System.out.println("Dodajesz sedziego pomocniczego nr 2");

                                System.out.println("Podaj imie");
                                imie = input.next();
                                System.out.println("Podaj nazwisko");
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    gra.szukajSedziego(imie, nazwisko).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                                    spom2 = new SedziaPomocniczy(gra.szukajSedziego(imie, nazwisko));
                                } else {
                                    spom2 = new SedziaPomocniczy(imie, nazwisko, 1);
                                    gra.getSedziowie().add(spom2);
                                }
                                SedziaPomocniczy gg;
                                SedziaPomocniczy ss = new SedziaPomocniczy(spom1);
                                gg = new SedziaPomocniczy(spom2);

                                Siatkowka mecz_siatkowki = new Siatkowka(sglowny, ss, gg, dzien, miesiac, rok, atrybutA, atrybutB);

                                System.out.println("Dodajesz mecz Przeciagania Liny");
                                System.out.println("Podaj dzien");
                                dzien = input.nextInt();
                                System.out.println("Podaj miesiac");
                                miesiac = input.next();
                                System.out.println("Podaj rok");
                                rok = input.nextInt();
                                System.out.println("Podaj czas przez ktory lina byla po stronie druzyny  1");
                                atrybutA = input.nextInt();
                                System.out.println("Podaj czas przez ktory lina byla po stronie druzyny 2");
                                atrybutB = input.nextInt();
                                boolean wygralaA = false, wygralaB = false;
                                int znak;

                                System.out.println("Podaj ktora druzyna wygrala mecz 1/2");
                                if (input.nextInt() == 1)
                                    wygralaA = true;
                                else
                                    wygralaB = true;
                                System.out.println("Dodajesz sedziego ");

                                System.out.println("Podaj imie");
                                imie = input.next();
                                System.out.println("Podaj nazwisko");
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    gra.szukajSedziego(imie, nazwisko).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                                    sglowny = new Sedzia(gra.szukajSedziego(imie, nazwisko));
                                } else {
                                    sglowny = new Sedzia(imie, nazwisko, 1);
                                    gra.getSedziowie().add(sglowny);
                                }
                                PrzeciaganieLiny mecz_przeciagania_liny = new PrzeciaganieLiny(sglowny, wygralaA, wygralaB, atrybutA, atrybutB, dzien, miesiac, rok);

                                System.out.println("Dodajesz mecz Dwoch Ogni");
                                System.out.println("Podaj dzien");
                                dzien = input.nextInt();
                                System.out.println("Podaj miesiac");
                                miesiac = input.next();
                                System.out.println("Podaj rok");
                                rok = input.nextInt();
                                System.out.println("Podaj liczbe zbic wykonanych przez druzyne nr 1  1");
                                atrybutA = input.nextInt();
                                System.out.println("Podaj liczbe zbic wykonanych przez druzyne nr  2");
                                atrybutB = input.nextInt();
                                wygralaA = false;
                                wygralaB = false;


                                System.out.println("Podaj ktora druzyna wygrala mecz 1/2");
                                if (input.nextInt() == 1)
                                    wygralaA = true;
                                else
                                    wygralaB = true;
                                System.out.println("Dodajesz sedziego ");

                                System.out.println("Podaj imie");
                                imie = input.next();
                                System.out.println("Podaj nazwisko");
                                nazwisko = input.next();
                                if (gra.czy_jest_sedzia_o_ImieniuiNaziwsku(imie, nazwisko)) {
                                    gra.szukajSedziego(imie, nazwisko).zwieksz_liczbe_sedziowanych_meczyoJEDEN();
                                    sglowny = new Sedzia(gra.szukajSedziego(imie, nazwisko));
                                } else {
                                    sglowny = new Sedzia(imie, nazwisko, 1);
                                    gra.getSedziowie().add(sglowny);
                                }
                                DwaOgnie mecz_dwoch_ogni = new DwaOgnie(sglowny, wygralaA, wygralaB, atrybutA, atrybutB, dzien, miesiac, rok);
                                Rozgrywki rozgrywka = new Rozgrywki(mecz_siatkowki, mecz_dwoch_ogni, mecz_przeciagania_liny, dA, dB);
                                rozgrywka.zwyciezca(gra.getDruzyny());
                                gra.GetRozgrywki().add(rozgrywka);

                                break;
                            case 2:
                                System.out.println("Podaj nazwy druzyn miedzy ktorymi rozgrywke chcesz usunac");
                                String nazwaPierwszej, nazwaDrugiej;
                                nazwaPierwszej = input.next();
                                nazwaDrugiej = input.next();
                                for (int i = 0; i < gra.GetRozgrywki().size(); i++) {
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaPierwszej) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaDrugiej)) {
                                        gra.usunRozgrywki(gra.GetRozgrywki().get(i));
                                        break;
                                    }
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaDrugiej) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaPierwszej)) {
                                        gra.usunRozgrywki(gra.GetRozgrywki().get(i));
                                        break;
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("Podaj nazwy druzyn miedzy ktorymi rozgrywke chcesz znalezc");
                                nazwaPierwszej = input.next();
                                nazwaDrugiej = input.next();
                                for (int i = 0; i < gra.GetRozgrywki().size(); i++) {
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaPierwszej) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaDrugiej)) {
                                        System.out.println(gra.GetRozgrywki().get(i));
                                        break;
                                    }
                                    if (gra.GetRozgrywki().get(i).getDruzynaA().getNazwa().equals(nazwaDrugiej) && gra.GetRozgrywki().get(i).getDruzynaB().getNazwa().equals(nazwaPierwszej)) {
                                        System.out.println(gra.GetRozgrywki().get(i));
                                        break;
                                    }
                                }

                                break;
                            case 4:
                                gra.Wczytywanie_Rozgrywek_z_Pliku(input);

                                break;
                            case 5:
                                gra.zapisRozgrywki(gra.GetRozgrywki());
                                break;
                            case 6:
                                gra.wyswietlRozgrywki();
                                break;
                            case 7:
                                break;
                        }
                        break;
                    case 4:
                        input.close();
                        return;
                    default:
                        System.out.println("Bledny wybor");
                        break;


                }

            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Error");
                input.nextLine();


            } catch (Exception e) {
                System.out.println("Inny error");
                input.nextLine();


            }
        }


        while (true);


    }
}
