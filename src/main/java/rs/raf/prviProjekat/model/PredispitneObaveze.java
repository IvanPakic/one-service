package rs.raf.prviProjekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "predispitneobaveze")
public class PredispitneObaveze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    private int id_obaveze;

    private String naziv;
    private int poeni;

    //jedan student ima vise predispitnih obaveza

//    @JsonIgnore
    @ManyToOne //(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_student")
    private Student student;

//    @JsonIgnore
    @ManyToOne //(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_predmet")
    private Predmet predmet;

//    @JsonIgnore
//    @OneToMany (mappedBy = "id_tipaObaveze")//(cascade = {CascadeType.ALL})
//    private List<TipObaveze> tipoviObaveza;



    public PredispitneObaveze() {
    }

    public PredispitneObaveze(int poeni) {
        this.poeni = poeni;
    }

    public PredispitneObaveze(String naziv, Integer poeni) {
        this.naziv = naziv;
        this.poeni = poeni;
    }

    public int getId_obaveze() {
        return id_obaveze;
    }

    public void setId_obaveze(int id_obaveze) {
        this.id_obaveze = id_obaveze;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPoeni() {
        return poeni;
    }
    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }


}
