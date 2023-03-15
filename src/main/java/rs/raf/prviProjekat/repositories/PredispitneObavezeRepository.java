package rs.raf.prviProjekat.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.prviProjekat.model.PredispitneObaveze;

public interface PredispitneObavezeRepository extends CrudRepository<PredispitneObaveze, Integer> {
//    List<Integer> poeniPredmetIStudent(Student student, Predmet predmet);
//
//    List<Integer> poeniPredmetINalog(Student student, Predmet predmet);
//
//    void unosPoena(Student student, Predmet predmet, TipObaveze ti, int i);
//
//    void izmenaPoena(Student student, Predmet predmet, TipObaveze tip, int i);
//
//    void brisanjePoena(Student student, Predmet predmet, TipObaveze tip, int i);
//
//    void dodajNovePredispitne(List<PredispitneObaveze> obaveze, Predmet predmet);
//
//    List<Integer> ukupnoPoeniPredmet(Predmet predmet);

//    int ukupnoPoeni(List<Student> studenti, Predmet predmet);


//
//    @Query(value = "select  s.id_student, s.ime, s.prezime, sum(ob.poeni) from " +
//            "Student  s join  s.predmeti s.obaveze ob whrere p.ime like : predmet " +
//            "group by s.id_student order by s.prezime"
//    )
//
//    List<Object []> findAndSort(String predmet);
}
