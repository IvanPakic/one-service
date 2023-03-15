package rs.raf.prviProjekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    private int id_student;

    private String ime;
    private String prezime;

    private String brojIndeksa;

   @JsonIgnore
    @ManyToMany(mappedBy = "studenti")
  // @Cascade(org.hibernate.annotations.CascadeType.ALL)
//   @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Predmet> predmeti;

    @JsonIgnore
    @OneToMany(mappedBy = "id_obaveze")
    private List<PredispitneObaveze> obaveze;

    public Student(){

    }

    public Student(String ime, String prezime, String brojIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
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

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public List<PredispitneObaveze> getObaveze() {
        return obaveze;
    }

    public void setObaveze(List<PredispitneObaveze> obaveze) {
        this.obaveze = obaveze;
    }

    @Override
    public String toString() {
        return this.ime + this.prezime + this.brojIndeksa;
    }

    public void dodajTip(PredispitneObaveze predispitneObaveze){
        this.obaveze.add(predispitneObaveze);
    }

    //za studenta
    public void dodajPredmet(Predmet predmet){
        this.predmeti.add(predmet);
    }

    //za studente
    public void dodajPredispitneStudent(PredispitneObaveze predispitneObaveze){
        this.obaveze.add(predispitneObaveze);
    }


}
