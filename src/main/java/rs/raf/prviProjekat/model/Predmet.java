package rs.raf.prviProjekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "predmet")
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    private int id_predmet;

    private String naziv;
    private String brojESPB;

    @JsonIgnore
    @ManyToMany //(cascade = {CascadeType.ALL})
//    @Cascade({ CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "predmet_student",
            joinColumns=@JoinColumn(name="id_predmet"),
            inverseJoinColumns=@JoinColumn(name="id_student")
    )
    private List<Student> studenti = new ArrayList<>();

    //    @ManyToMany
 //   private List<Predmet> studenti = new ArrayList<>();


    public int getId_predmet() {
        return id_predmet;
    }

    public void setId_predmet(int id_predmet) {
        this.id_predmet = id_predmet;
    }

    //ovo je bio problem !!!
    @JsonIgnore
    @OneToMany(mappedBy = "id_obaveze")
    private List<PredispitneObaveze> obaveze;

    public Predmet() {
    }

    public Predmet(String naziv, String brojESPB) {
        this.naziv = naziv;
        this.brojESPB = brojESPB;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(String brojESPB) {
        this.brojESPB = brojESPB;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public List<PredispitneObaveze> getObaveze() {
        return obaveze;
    }

    public void setObaveze(List<PredispitneObaveze> obaveze) {
        this.obaveze = obaveze;
    }


    //za predmet
    public void dodajStudenta(Student student){
        this.studenti.add(student);
    }

    public void dodajPredispitne(PredispitneObaveze predispitneObaveze){
        this.obaveze.add(predispitneObaveze);
    }

}
