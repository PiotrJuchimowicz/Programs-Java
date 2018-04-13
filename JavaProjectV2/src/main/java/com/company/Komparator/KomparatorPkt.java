/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.Komparator;

import java.util.Comparator;

import com.company.Inne.*;

/**
 * @author Qbacki
 */
public class KomparatorPkt implements Comparator<Druzyna> {
    @Override
    public int compare(Druzyna x, Druzyna y) {
        if (x.getPunkty() > y.getPunkty())
            return -1;
        else if (x.getPunkty() < y.getPunkty())
            return 1;
        return 0;
    }
}
