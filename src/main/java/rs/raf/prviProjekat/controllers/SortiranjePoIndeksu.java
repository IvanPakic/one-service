package rs.raf.prviProjekat.controllers;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class SortiranjePoIndeksu implements Comparator<UpomocStudent> {

    @Override
    public int compare(UpomocStudent o1, UpomocStudent o2) {
        return o1.getBrojIndeksa().compareTo(o2.getBrojIndeksa());
    }
}

