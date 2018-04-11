/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasy;

/**
 *
 * @author Piotr
 */
public class Zawodnik {
      protected String imie,nazwisko;
    protected  int wiek;
     
     public Zawodnik()
     {
         
     }
     
     public Zawodnik(String i,String n,int w)
     {
         imie=i;
         nazwisko=n;
         wiek=w;
         
     }     
     
     public Zawodnik(Zawodnik var)
     {
         imie=var.imie;
         nazwisko=var.nazwisko;
         wiek=var.wiek;
         
         
     }
     public void setImie(String imie){
         this.imie=imie;
     }
     public void setNazwisko(String nazwisko){
         this.nazwisko=nazwisko;
     }
     public String getImie(){
         return imie;
     }
     public String getNazwisko(){
         return nazwisko;
     }
     public int getWiek(){
         return wiek;
     }
     public  String toString()
     {
        
         return imie+" " + nazwisko + " " + wiek;
     }
    
}
