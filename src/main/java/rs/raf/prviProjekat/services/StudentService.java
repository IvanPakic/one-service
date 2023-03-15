package rs.raf.prviProjekat.services;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import rs.raf.prviProjekat.model.Predmet;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.repositories.StudentRepository;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public <S extends Student> S save(S student){
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Integer studentId){
        return studentRepository.findById(studentId);
    }

    public List<Student> findAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public void deleteById(Integer studentId){
        studentRepository.deleteById(studentId);
    }

   public <S extends Student> S saveAndFlush(S student){
        return studentRepository.save(student);
   }

   public Predmet dajNazivPredmeta(Student student, String naziv){

      List<Predmet> predmets = student.getPredmeti();
      for (Predmet p : predmets){
          if (p.getNaziv().equals(naziv)){
            return p;
          }
      }
        return null;
    }

    public Student findStudent(Student student){
        for (Student s : studentRepository.findAll()){
            if (s.getId_student() == student.getId_student()){
                return s;
            }
        }
        return null;
    }

    @NonNull
    public Student napraviNalog(String student){
        List<Student> studenti = this.findAll();
        for (Student s : studenti){
            String ime = String.valueOf(s.getIme().toLowerCase().charAt(0));
            String prezime = s.getPrezime().toLowerCase();
            String brojIndeksa = s.getBrojIndeksa().toLowerCase();
            if (s.getIme().equals(ime) && s.getPrezime().equals(prezime) &&s.getBrojIndeksa().equals(brojIndeksa)){
                return s;
            }
        }
        return null;
    }

}
