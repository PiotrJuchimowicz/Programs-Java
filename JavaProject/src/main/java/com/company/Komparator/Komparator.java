package com.company.Komparator;

import java.util.Comparator;

import com.company.Inne.*;


public class Komparator implements Comparator<Druzyna> {
    @Override
    public int compare(Druzyna x, Druzyna y) {
        return x.getNazwa().compareTo(y.getNazwa());
    }
}
