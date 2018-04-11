
package Klasy;

import java.util.ArrayList;

/**
 *
 * @author Piotr
 */
public class Rozgrywki
{
    
    private Siatkowka mecz_siatkowki;
    private DwaOgnie mecz_dwochogni;
    private PrzeciaganieLiny mecz_przeciaganialiny;
    private Druzyna druzynaA;
    private Druzyna druzynaB;
     private float wspolczynnik_ilosciowy;
    public Rozgrywki()
    {
        
    }
    
    // Bez sensu 2 takie same rozgrywki z tymi samymi druzynami
    // wiec nie ma konstruktora kopiujacego
    
    //settery:
    public void setRozgrywki(Siatkowka x1,DwaOgnie x2,PrzeciaganieLiny x3,Druzyna x, Druzyna y){
        druzynaA=x;
        druzynaB=y;
    }
    
    public  Rozgrywki(Siatkowka x1,DwaOgnie x2,PrzeciaganieLiny x3,Druzyna x4,Druzyna x5)
    {
        mecz_siatkowki = new Siatkowka(x1);
        mecz_dwochogni = new DwaOgnie(x2);
        mecz_przeciaganialiny= new PrzeciaganieLiny(x3);
        druzynaA= new Druzyna(x4);
        druzynaB=new Druzyna(x5);
        
    }
    
    public Siatkowka getMeczSiatkowki()
    {
        return mecz_siatkowki;
    }
    
    public DwaOgnie getMeczDwaOgnie()
    {
        return mecz_dwochogni;
    }
    
    public PrzeciaganieLiny getMeczPzeciaganieLiny()
    {
        return mecz_przeciaganialiny;
    }
    
    public Druzyna getDruzynaA()
    {
        return druzynaA;
    }
    
    public Druzyna getDruzynaB()
    {
        return druzynaB;
    }
    
public void wspolczynnik()
{
    wspolczynnik_ilosciowy=(float)druzynaA.liczba_zawodnikow/druzynaB.liczba_zawodnikow;
}
    
    public Druzyna zwyciezca(ArrayList<Druzyna> lista)//Wylaniamy zwyciezce danych Rozgrywek(tych 3 meczy) 1 wygrana w meczu to 1 pkt
    {
        wspolczynnik();
        float punktyA=0;
        float punktyB=0;
        if(mecz_siatkowki.getWynikA()==true)
        {
             punktyA=1+punktyA;
            
        }
           
        else if(mecz_siatkowki.getWynikB()==true)
        {
            punktyB=1+punktyB;
            
        }
            
        
         if(mecz_dwochogni.getWynikA()==true)
            {
             punktyA=1+punktyA;
             
        }

       else  if(mecz_dwochogni.getWynikB()==true)
             {
            punktyB=1+punktyB;
            
        }

        if(mecz_przeciaganialiny.getWynikA()==true)
           {
             punktyA=1+punktyA;
             
        }

       else  if(mecz_przeciaganialiny.getWynikB()==true)
            {
            punktyB=1+punktyB;
            
        }

       //Uwzgledniam wspolczynnik ilosciowy

        if(wspolczynnik_ilosciowy!=1)
        {
            punktyB=(float) punktyB*wspolczynnik_ilosciowy;
            punktyA=(float) punktyA*(1/(float)wspolczynnik_ilosciowy);
        }

        if(punktyA>punktyB)
        {
            //druzynaA.dodaj_zyciestwo();
          for(int y=0;y<lista.size();y++)
          {
              if(lista.get(y).getNazwa().equals(druzynaA.getNazwa()))
                  lista.get(y).dodaj_zyciestwo();
          }
           
            return druzynaA;
            
        }
            
            
        

        else if(punktyB>punktyA)
        {
            for(int y=0;y<lista.size();y++)
          {
              if(lista.get(y).getNazwa().equals(druzynaB.getNazwa()))
                  lista.get(y).dodaj_zyciestwo();
          }
            //druzynaB.dodaj_zyciestwo();
            
            return druzynaB;
        }

             
        else
        {
            
            return null;
        }
    }
    
    public Druzyna najwieksza_skutecznosc()
    {
        float calkowita_skutecznoscA=0;
        float calkowita_skutecznoscB=0;

        calkowita_skutecznoscA=mecz_dwochogni.getSkutecznoscA()+mecz_przeciaganialiny.getSkutecznoscA()+mecz_siatkowki.getSkutecznoscA();
        calkowita_skutecznoscB=mecz_dwochogni.getSkutecznoscB()+mecz_przeciaganialiny.getSkutecznoscB()+mecz_siatkowki.getSkutecznoscB();

        if(calkowita_skutecznoscA>calkowita_skutecznoscB)
            return druzynaA;

        else if(calkowita_skutecznoscB>calkowita_skutecznoscA)
            return druzynaB;

        else
        {
            return null;// Tu pewnie znowu wyjatek trzeba bedzie
        }

    }
    
    

    
}
