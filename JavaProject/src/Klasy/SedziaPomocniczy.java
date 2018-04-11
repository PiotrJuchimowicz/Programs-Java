/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasy;
import java.util.*;

/**
 *
 * @author szymo
 */
public class SedziaPomocniczy extends Sedzia
{
     public SedziaPomocniczy(String simie, String snazwisko, int iloscSedziowan)
    {
        this.simie = simie;
        this.snazwisko = snazwisko;
        this.iloscSedziowan = iloscSedziowan;
       
    }
     
     public SedziaPomocniczy()
     {
         
     }
    
    public SedziaPomocniczy(Sedzia var)
    {
        simie=var.simie;
        snazwisko=var.snazwisko;
        iloscSedziowan=var.iloscSedziowan;
    }
    
}
