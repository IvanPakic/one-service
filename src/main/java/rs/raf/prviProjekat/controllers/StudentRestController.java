package rs.raf.prviProjekat.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rs.raf.prviProjekat.model.PredispitneObaveze;
import rs.raf.prviProjekat.model.Predmet;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.services.PredispitneObavezeService;
import rs.raf.prviProjekat.services.PredmetService;
import rs.raf.prviProjekat.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/api"})
public class StudentRestController {


    private final StudentService studentService;
    private final PredmetService predmetService;
    private final PredispitneObavezeService predispitneObavezeService;

    public StudentRestController(StudentService studentService, PredmetService predmetService, PredispitneObavezeService predispitneObavezeService) {
        this.studentService = studentService;
        this.predmetService = predmetService;
        this.predispitneObavezeService = predispitneObavezeService;
    }

    @GetMapping(value = "/predmet/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Predmet> getAllPredmets() {
        return predmetService.findAll();
    }

    @GetMapping(value = "/student/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // 1 stavka
    @NonNull
    @PostMapping(value = "/predmetSaObavezama", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Predmet dodajPredmetSaPredObavezama(@RequestBody Predmet predmet) {



//        Predmet pred = predispitneObavezeService.dajNoviPredmet(predmet, listaPredispitneObaveze);
//
//        PredispitneObaveze predispitneObaveze = new PredispitneObaveze();
//
//        predispitneObaveze.setNaziv(nazivPredmeta);
//        predispitneObavezeService.mojSaveAll(pred, listaPredispitneObaveze);


//        predmetService.save(pred);
//        predispitneObavezeService.saveAll(listaPredispitneObaveze);

        return predmetService.save(predmet);


    }

    // 2 stavka
    @PutMapping(value = "/predmet/nove/predispitneObaveze/{id_predmet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Predmet dodajNovePredispitne(@PathVariable Integer id_predmet, @RequestParam String naziv) {
        PredispitneObaveze predispitneObaveze = new PredispitneObaveze(0);
        predispitneObaveze.setNaziv(naziv);
        Predmet predmet = predmetService.dodajPredispitne(id_predmet, predispitneObaveze);
        predispitneObavezeService.savePredmet(predmet, predispitneObaveze);

        return predmet;
    }

    // 3 stavka unosim studenta
    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student unosStudenta(@RequestBody Student student) {
        return studentService.save(new Student(student.getIme(), student.getPrezime(), student.getBrojIndeksa()));
    }

    //4.1 unosim poene studenta na predispitnoj obavezi
    @PostMapping(value = "/student/predispitneObaveze/poeni", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student dodajPredispitneZaStudenta(@RequestParam String nalog,
                                              @RequestParam String predmet,
                                              @RequestParam String tip,
                                              @RequestParam Integer poeni) {

        Student student = studentService.napraviNalog(nalog);
        Predmet predmet1 = predmetService.findByNazivPredmeta(predmet);
        PredispitneObaveze pio = predispitneObavezeService.nadjiPredObavezuZaPredmet(tip, predmet1);
        if (predmet == null) {
            return null;
        }
       PredispitneObaveze predispitneObaveze = predispitneObavezeService.unosPoena(student, predmet1, pio, poeni);
        predispitneObaveze.setStudent(student);
        predispitneObaveze.setPredmet(predmet1);
//        predispitneObavezeService.save(predispitneObaveze);

        return student;
    }

    //4.2
    @PutMapping(value = "/student/predispitneObaveze/student/izmeniPoene", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student izmeniPredispitneZaStudenta(@RequestParam String nalogStudenta,
                                               @RequestParam String nazivPredmeta,
                                               @RequestParam String nazivPredispitneObaveze,
                                               @RequestParam Integer brPoena) {
        Student student = studentService.napraviNalog(nalogStudenta);
        Predmet predmet = predmetService.findByNazivPredmeta(nazivPredmeta);
        PredispitneObaveze pio = predispitneObavezeService.nadjiPredZaStudIPredmet(student, predmet, nazivPredispitneObaveze);
        if (predmet == null || pio == null)
            return null;

        predispitneObavezeService.izmenaPoena(student, predmet, pio, brPoena);

        return student;
    }

    // 4.3
    @PostMapping(value = "/student/predispitneObaveze/obrisi/poene", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student obrisiPredispitneZaStudenta(@RequestParam String nalogStudenta,
                                               @RequestParam String nazivPredmeta,
                                               @RequestParam String obaveza) {
        Student student = studentService.napraviNalog(nalogStudenta);
        Predmet predmet = predmetService.findByNazivPredmeta(nazivPredmeta);
        PredispitneObaveze pio = predispitneObavezeService.nadjiPredZaStudIPredmet(student, predmet, obaveza);
        if (predmet == null || pio == null)
            return null;

        PredispitneObaveze obavezePred = predispitneObavezeService.brisanje(pio, 0);
        obavezePred.setStudent(student);
        obavezePred.setPredmet(predmet);
        predispitneObavezeService.save(obavezePred);
//        predispitneObavezeService.setAll(student, predmet, obavezePred);
        return student;
    }

    //5 stavka
    @GetMapping(value = "/predispitneObaveze/poeni/predmet", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PredispitneObaveze> getPoeniPredmetINalog(@RequestParam String nalog, @RequestParam String predmet) {
        Student student = studentService.napraviNalog(nalog);
        Predmet pred = studentService.dajNazivPredmeta(student, nalog);
        if ( predmet == null || student == null) {
            return null;
        }
        return predispitneObavezeService.poeniPredmetINalog(student, pred);
    }


    //6 stavka
    @GetMapping(value = "/predispitneObaveze/poeni/studentima", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PredispitneObaveze> getPoeniPredmetIStudent(@RequestBody String student) {
        Student st = studentService.napraviNalog(student);
        if (student == null) {
            return null;
        }
        return predispitneObavezeService.poeniPredmetIStudent(st);
    }
    //7 stavka
    @Transactional
//    @RequestMapping(value="/predispitneObavezePoeni/predmet/{id_predmet}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/predispitneObavezePoeni/predmet/sortiranje/{id_predmet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UpomocStudent> getUkupniPoeni(@PathVariable Integer id_predmet,
                                              @RequestBody  String tipSortiranja) {
        List<Student> studenti = predmetService.findStudents(id_predmet);

        if (studenti.isEmpty()) {
            System.out.println("Nesto zeza");
            return null;
        }

        ArrayList<UpomocStudent> studentiUpomoci = (ArrayList<UpomocStudent>) predispitneObavezeService.ukupnoPoeni(studenti);

        if (studentiUpomoci == null) {
            return null;
        } else if (tipSortiranja.equals("")) {
            return null;
        }else{
            switch (tipSortiranja) {
                case "indeksi":
//                    System.out.println("Nesto zeza1");
                    studentiUpomoci.sort(new SortiranjePoIndeksu());
                    break;
                case "prezimena":
//                    System.out.println("Nesto zeza2");
                    studentiUpomoci.sort(new SortiranjePoPrezimenu());
                    break;
                case "poenima" :
//                    System.out.println("Nesto zeza3");
                    studentiUpomoci.sort(new SortirajnePoPoenima());
                    break;
            }

        }

        return studentiUpomoci;
    }

}
