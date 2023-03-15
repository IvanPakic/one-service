package rs.raf.prviProjekat.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.services.PredispitneObavezeService;
import rs.raf.prviProjekat.services.StudentService;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//
//    @Query("select s from Student s where "
//            + "(:ime is null or lower(s.ime) like :ime) and "
//            + "(:prezime is null or lower(s.prezime) like :prezime) and "
//            + "(:brojIndeksa is null or lower(s.brojIndeksa) like :brojIndeksa)"
//    )
//    List<Student> findStudent(String ime, String prezime, String brojIndeksa);
//
//    @Query("select s from Student s where s.prezime like ?1%")
//    List<Student>  findByPrezime(String prezime, Sort sort);


}
