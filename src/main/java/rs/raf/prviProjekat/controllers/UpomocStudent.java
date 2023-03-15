package rs.raf.prviProjekat.controllers;

import org.jetbrains.annotations.NotNull;

public class UpomocStudent {

    private String ime;
    private String prezime;
    private String brojIndeksa;
    private int ukupniPoeni;

    public UpomocStudent(String ime, String prezime, String brojIndeksa, int ukupniPoeni) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
        this.ukupniPoeni = ukupniPoeni;
    }

    public UpomocStudent() {

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public int getUkupniPoeni() {
        return ukupniPoeni;
    }

    public void setUkupniPoeni(int ukupniPoeni) {
        this.ukupniPoeni = ukupniPoeni;
    }

}
