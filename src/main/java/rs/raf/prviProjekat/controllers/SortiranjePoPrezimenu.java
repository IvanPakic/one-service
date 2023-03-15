package rs.raf.prviProjekat.controllers;

import java.util.Comparator;

public class SortiranjePoPrezimenu implements Comparator<UpomocStudent> {

    @Override
    public int compare(UpomocStudent o1, UpomocStudent o2) {
        return o1.getPrezime().compareTo(o2.getPrezime());
    }
}
