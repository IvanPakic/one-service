package rs.raf.prviProjekat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.prviProjekat.controllers.SortirajnePoPoenima;
import rs.raf.prviProjekat.controllers.SortiranjePoIndeksu;
import rs.raf.prviProjekat.controllers.SortiranjePoPrezimenu;
import rs.raf.prviProjekat.controllers.UpomocStudent;
import rs.raf.prviProjekat.model.PredispitneObaveze;
import rs.raf.prviProjekat.model.Predmet;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.repositories.PredispitneObavezeRepository;
import rs.raf.prviProjekat.repositories.PredmetRepository;
import rs.raf.prviProjekat.repositories.StudentRepository;

import java.util.*;

@Service
public class PredispitneObavezeService {
    private final PredispitneObavezeRepository predispitneObavezeRepository;
    private final PredmetRepository predmetRepository;

    private final StudentRepository studentRepository;

    @Autowired
    private PredmetService predmetService;

    @Autowired
    private  StudentService studentService;


    public PredispitneObavezeService(PredispitneObavezeRepository predispitneObavezeRepository, PredmetRepository predmetRepository,
                                     StudentRepository studentRepository){
        this.predispitneObavezeRepository = predispitneObavezeRepository;
        this.predmetRepository = predmetRepository;
        this.studentRepository = studentRepository;
    }

    public <S extends PredispitneObaveze> S save(S predispitneObaveze){
        return predispitneObavezeRepository.save(predispitneObaveze);
    }


    public Optional<PredispitneObaveze> findById(Integer predispitneObaveze){
        return predispitneObavezeRepository.findById(predispitneObaveze);
    }

    public List<PredispitneObaveze> findAll(){
        return (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
    }

    public void deleteById(Integer predispitneObaveze){
        predispitneObavezeRepository.deleteById(predispitneObaveze);
    }

    public void savePredmet(Predmet predmet, PredispitneObaveze predispitneObaveze) {
        predispitneObaveze.setPredmet(predmet);
        this.save(predispitneObaveze);

    }
    public Predmet dajNoviPredmet(Predmet predmet, List<PredispitneObaveze> listaPredispitnih ) {
        predmet.setObaveze(new ArrayList<>());

        for(PredispitneObaveze p : listaPredispitnih){
            predmet.dodajPredispitne(p);
        }
        predmetRepository.save(predmet);
        return predmet;
    }


    public void dodajNovePredispitne(List<PredispitneObaveze> pio, Predmet predmet){
        List<Predmet> predmeti =  predmetService.findAll();
        Optional<Predmet> optionalPredmet = predmetRepository.findById(predmet.getId_predmet());

        if (optionalPredmet.isPresent()){
            List<Predmet> lista = new ArrayList<>();
            for (Predmet p : predmeti){
                if (p.getNaziv().equals(predmet.getNaziv())){
                    for(PredispitneObaveze lst : pio){
                        if (lst.getId_obaveze() == p.getId_predmet()){
                            lista.add(predmet);
                            predispitneObavezeRepository.save(lst);
                        }
                    }
                }
            }
        }

    }

    public PredispitneObaveze findByName(String tipObaveze, List<PredispitneObaveze> obaveze){
        List<PredispitneObaveze> sveObaveze = (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
        for (PredispitneObaveze tip : sveObaveze) {
            if (tip.getNaziv().equals(tipObaveze)) {
                return tip;
            }
        }
    return null;
    }

    @Transactional
    public PredispitneObaveze unosPoena(Student student, Predmet predmet, PredispitneObaveze tipObaveze, Integer poeni){
        PredispitneObaveze p = new PredispitneObaveze(poeni);
            if(student.getObaveze().isEmpty()) {
                student.setObaveze(new ArrayList<>());
            }else {
                student.dodajPredispitneStudent(p);
                studentService.save(student);
                return p;
            }
        return  null;
    }

    public PredispitneObaveze nadjiPredObavezuZaPredmet(String nazivPredispitneObaveze, Predmet predmet) {
        List<PredispitneObaveze> sveObaveze = (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
        for(PredispitneObaveze p : sveObaveze){
            if(p.getNaziv().equals(nazivPredispitneObaveze) && p.getPredmet().getId_predmet() == predmet.getId_predmet()){
                return p;
            }
        }
        return null;
    }

    //pred obaveza
    public PredispitneObaveze nadjiPredZaStudIPredmet(Student student, Predmet predmet, String nazivObaveze) {
        List<PredispitneObaveze> obaveze = this.findAll();
        for(PredispitneObaveze p : obaveze){
            if(p.getStudent() != null && student.getId_student() == p.getStudent().getId_student() && p.getNaziv().equals(nazivObaveze)
                 && p.getPredmet()!=null  && p.getPredmet().getId_predmet() == predmet.getId_predmet()){
                return p;
            }

        }
        return null;
    }
    //izmena poena
    @Transactional
    public void izmenaPoena(Student student, Predmet predmet, PredispitneObaveze tipObaveze, int poeni){
        List<Student> studenti = studentService.findAll();
        Optional<Student> optionalStudent = studentRepository.findById(student.getId_student());

        List<PredispitneObaveze> sveObaveze = new ArrayList<>();

        if (optionalStudent.isPresent()) {
            for (Student s : studenti) {

                if (s != null && s.getId_student() == student.getId_student()) {
                    List<PredispitneObaveze> pio = optionalStudent.get().getObaveze();
                    sveObaveze.addAll((Collection<? extends PredispitneObaveze>) pio);
                    for (PredispitneObaveze p : pio) {
                        //isti uslov
                        if (p != null && p.getPredmet().getId_predmet() == predmet.getId_predmet() && p.getId_obaveze() == tipObaveze.getId_obaveze()) {
                            p.setPoeni(poeni);
                            sveObaveze.add(p);
                            predispitneObavezeRepository.save(p);
                            System.out.println(sveObaveze);
                        }
                    }
                }
            }
        }


    }

    public PredispitneObaveze brisanje(PredispitneObaveze predispitnaObaveza, Integer brPoena) {
        predispitnaObaveza.setPoeni(brPoena);
        predispitneObavezeRepository.save(predispitnaObaveza);
        return predispitnaObaveza;
    }

//    //brisanje
//    @Transactional
//    public void brisanjePoena(Student student, Predmet predmet, PredispitneObaveze tipObaveze, int poeni){
//        Optional<Predmet> optionalPredmet = predmetRepository.findById(predmet.getId_predmet());
//        Optional<Student> optionalStudent = Optional.ofNullable(studentService.findStudent(student));
//
//        for(Student s : (List<Student>) studentRepository.findAll()){
//            if (optionalStudent.isEmpty())
//                break;
//        }
//
//        for(Predmet s : (List<Predmet>) predmetRepository.findAll()){
//            if (optionalPredmet.isEmpty())
//                break;
//        }
//
//        List<Student> studenti = (List<Student>) studentRepository.findAll();
//
//        List<PredispitneObaveze> pio = optionalStudent.get().getObaveze();
//        for (PredispitneObaveze p: pio){
//            if (p.getId_obaveze() == tipObaveze.getId_obaveze()) {
//                if ((Objects.equals(p.getPredmet(), predmet)))
//                    for (Student s : studenti){
//                        String nalog = String.valueOf(studentService.napraviNalog(String.valueOf(s)));
//                        String nalog1 = String.valueOf(studentService.napraviNalog(String.valueOf(p.getStudent())));
//                        if (nalog1.equals(nalog))
//                            predispitneObavezeRepository.delete(p);
//                    }
//            }
//        }
//
//    }

    //preuzimanje predispitnih poena za predmet i nalog studenta
    @Transactional
    public List<PredispitneObaveze> poeniPredmetINalog(Student student, Predmet predmet){
        List<PredispitneObaveze> poeni = new ArrayList<>();
        List<PredispitneObaveze> sveObaveze = (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
//        Optional<Student> optionalStudent = studentService.findById(student.getId_student());
            for (PredispitneObaveze p : sveObaveze){
                if (p.getPredmet()!=null && p.getPredmet().getId_predmet() == predmet.getId_predmet() && p.getStudent()!= null &&p.getStudent().getId_student() == student.getId_student())
                    poeni.add(p);
            }

        return poeni;
    }

////    preuzimanje ostvarenih poena na predispitnim obavezama na svim predmetima za jednog studenta
//    @Transactional
//    public int poeniPredmetIStudent(Student student, Predmet predmet){
//        Optional<Predmet> optionalPredmet = predmetRepository.findById(predmet.getId_predmet());
//
//        Optional<Student> optionalStudent = studentRepository.findById(student.getId_student());
////        List<Integer> poeni = new ArrayList<>();
//
//        Student st = new Student();
//        int poeni = 0;
//        if (optionalStudent.isPresent() && optionalPredmet.isPresent()){
////            for (Student s : studentRepository.findAll()) {
////                if (s!=null && optionalPredmet.get().getId_predmet() == student.getId_student() && s.getId_student() == student.getId_student() ) {
////                    st = s;
////
//////                    System.out.println("usao1" );
//////                    System.out.println(poeni);
//                    List<PredispitneObaveze> pio = optionalStudent.get().getObaveze();
//                    for (PredispitneObaveze p : pio) {
////                        System.out.println("usao2" );
//                        if (p.getStudent() != null && st.getId_student() == optionalStudent.get().getId_student() && p.getPredmet().getNaziv().equals(predmet.getNaziv())) {
//                            System.out.println("usao3" );
////                            poeni.add(p.getPoeni());
//                            poeni += p.getPoeni();
//                            System.out.println(poeni);
//                        }
//                    }
//                }
////            }
////        }
//
//        return poeni;
//    }


    //    preuzimanje ostvarenih poena na predispitnim obavezama na svim predmetima za jednog studenta
    @Transactional
    public List<PredispitneObaveze> poeniPredmetIStudent(Student student){
//        List<PredispitneObaveze> pio = (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
        List<PredispitneObaveze> poeni = new ArrayList<>();

        for (PredispitneObaveze p : predispitneObavezeRepository.findAll()) {
//                        System.out.println("usao2" );
            if (p.getStudent() != null && p.getStudent().getId_student() == student.getId_student() )
//                    System.out.println("usao3" );
                poeni.add(p);
        }


        return poeni;
    }
    //    nadji obaveze za istog studenta
    @Transactional
    public List<PredispitneObaveze> nadjiObavezuZaStudenta(Student student){
        List<PredispitneObaveze> sveObaveze = (List<PredispitneObaveze>) predispitneObavezeRepository.findAll();
        List<PredispitneObaveze> obavezaZaStudenta = new ArrayList<>();

        for(PredispitneObaveze p: sveObaveze){
            if(p.getStudent() != null && p.getStudent().getId_student() == student.getId_student())
                obavezaZaStudenta.add(p);
        }
        return obavezaZaStudenta;
    }

    //    preuzimanje ukupnog broja poena sa predispitnih obaveza sa sve studente na jednom predmetu
    @NonNull
    @Transactional
    public List<UpomocStudent> ukupnoPoeni(List<Student> studenti) {

        if (studenti.isEmpty())
            return null;

        List<UpomocStudent> upomocStudenti = new ArrayList<>();
        for (Student s : studenti) {
            System.out.println("Usao1");
            List<PredispitneObaveze> predispitneObavezes = nadjiObavezuZaStudenta(s);
            int suma = 0;
            for (PredispitneObaveze p : predispitneObavezes) {
                System.out.println("Usao2");
                if (p != null){
                    System.out.println("Usao3");
                    suma += p.getPoeni();
                    System.out.println("suma " + suma);
                    }
            }
            upomocStudenti.add(new UpomocStudent(s.getIme(), s.getPrezime(), s.getBrojIndeksa(), suma));
            System.out.println(upomocStudenti);
        }
//        final List<UpomocStudent> studentiUpomoci = predispitneObavezeService.ukupnoPoeni(studenti);


            return upomocStudenti;
    }
    @Transactional
    public <S extends PredispitneObaveze> List<S> saveAll(Iterable<S> entities) {

        List<S> result = new ArrayList<S>();

        for (S entity : entities) {
            result.add(save(entity));
        }

        return result;
    }
    public void mojSaveAll(Predmet predmet, List<PredispitneObaveze> listaPredispitnih) {
        for(PredispitneObaveze pr : listaPredispitnih){
            pr.setPredmet(predmet);
            this.save(pr);
        }

    }

}
