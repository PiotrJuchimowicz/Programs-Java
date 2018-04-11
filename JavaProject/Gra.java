package Klasy;


import Klasy.Rozgrywki;
import Klasy.Sedzia;
import Klasy.Druzyna;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Gra {
    private ArrayList<Rozgrywki> Rozgrywki;
    private ArrayList<Sedzia> Sedziowie;
    private ArrayList<Druzyna> Druzyny;
    private Rozgrywki Tablica_Polfinalow []= new Rozgrywki [2];
    private Rozgrywki Final;
    
    public void dodajSedziego(Sedzia x){                 //dodawanie sedziego
         Sedziowie.add(x);
    }
    public void usunSedziego(Sedzia x){                  //usuwanie sedziego
         Sedziowie.remove(x);
    }
    public Sedzia SzukajSedziego(Sedzia x){              //szuka i zwraca sedziego
        for(Sedzia s: Sedziowie)
            if(s.equals(x))
                return s.getSedzia();            
        return null;
    }
    public void WyswietlSedziow(){                      //wyswietla ponumerowana liste sedziow
        int i=1;
        for(Sedzia s: Sedziowie)
        {           
            System.out.println(i+"."+" "+s.getImie()+" "+s.getNazwisko()+" "+s.getMecze());
            i++;
        }
    }
    public void WyswietlWszystkieDruzyny(){              //wyswietla ponumerowana liste druzyn
        int i=1;
        for(Druzyna d: Druzyny)
        {           
            System.out.println(i+"."+" "+d.getNazwa());
            i++;
        }
    }
    public void DodajDruzyne(Druzyna x){                 //dodaje druzyne
        Druzyny.add(x);
    }
    public Druzyna SzukajDruzyne(Druzyna x){             //szuka i zwraca druzyne
        for(Druzyna d: Druzyny)
            if(d.equals(x))
                return d;            
        return null;
    }
    public void WycofajDruzyne(Druzyna x){              // wycofuje druzyne, ale nie usuwa jej
        x.setUdzial();
    }
    public void UsunDruzyne(Druzyna x){                 // usuwa druzyne
        Druzyny.remove(x);
    }
    public void DodajRozgrywki(Rozgrywki x){            //dodaje rozgrywki
        Rozgrywki.add(x);
    }
    public void UsunRozgrywki(Rozgrywki x){             //usuwa rozgrywki
        Rozgrywki.remove(x);
    }
    public Rozgrywki SzukajRozgrywki(Druzyna x, Druzyna y){                         //szuka rozgrywki na podstawie podanych druzyn
        for(Rozgrywki r: Rozgrywki)
            if((r.getDruzynaA().equals(x))&&(r.getDruzynaB().equals(y)))
                return r;
            else if((r.getDruzynaB().equals(x))&&(r.getDruzynaA().equals(y)))
                return r;
        return null;
    }
    public void OdczytZPlikuSedziowie(String filePath) throws FileNotFoundException, IOException{           //czytanie z pliku -sedziowie
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;
        do{
        textLine= bufferedReader.readLine();
        }while(textLine != null);
    }
    public void OdczytZPlikuDruzyny(String filePath) throws FileNotFoundException, IOException{           //czytanie z pliku -druzyny
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;
        do{
        textLine= bufferedReader.readLine();
        }while(textLine != null);
    }
    public void OdczytZPlikuRozgrywki(String filePath) throws FileNotFoundException, IOException{           //czytanie z pliku -rozgrywki
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;
        do{
        textLine= bufferedReader.readLine();
        }while(textLine != null);
    }
    public void ZapidDoPlikuDruzyny(String filePath,ArrayList<Druzyna> Druzyny){
        
    }
    public void ZapidDoPlikuSedziowie(String filePath,ArrayList<Sedzia> Sedziowie){
        
    }
    public void ZapidDoPlikuRozgrywki(String filePath,ArrayList<Rozgrywki> Rozgrywki){
        
    }
    public Rozgrywki GeneratorPolfinalow(ArrayList<Druzyna> Druzyny, Rozgrywki TablicaPolfinalow[]) {
        
    }
    //public Rozgrywki Sortowanie(ArrayList<Rozgrywki> Rozgrywki){}
    
}
