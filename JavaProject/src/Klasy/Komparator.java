package Klasy;

import java.util.Comparator;

/**
 *
 * @author Qbacki
 */
public class Komparator implements Comparator<Druzyna> {
    @Override
    public int compare(Druzyna x, Druzyna y){
        return x.getNazwa().compareTo(y.getNazwa());
    }
}
