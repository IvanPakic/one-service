package rs.raf.prviProjekat.controllers;

import java.util.Comparator;

public class SortirajnePoPoenima implements Comparator<UpomocStudent> {

    @Override
    public int compare(UpomocStudent o1, UpomocStudent o2) {
        if (o1.getUkupniPoeni() == o2.getUkupniPoeni())
            return 0;
        if (o1.getUkupniPoeni() < o2.getUkupniPoeni())
            return 1;
        return -1;

    }
}
