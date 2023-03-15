package rs.raf.prviProjekat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rs.raf.prviProjekat.services.PredispitneObavezeService;
import rs.raf.prviProjekat.services.PredmetService;
import rs.raf.prviProjekat.services.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllServiceTest {

    @Autowired
    StudentService studentService;

    @Autowired
    PredmetService predmetService;

    @Autowired
    PredispitneObavezeService predispitneObavezeService;

    @Test
    public void saveAllServiceTest() throws Exception{

//        Student student1 = new Student("Misa", "Misic", "121ri");
//        Student student2 = new Student("Petar", "Petrovic", "47rn");
//        Student laza = new Student("Laza", "Lazic", "62ri");
//        Student mika = new Student("Mika", "Mikic", "29rn");
//        Student milan = new Student("Milan", "Milovanovic", "93ri");
//
//        Predmet predmet1 = new Predmet("Mikroservisne aplikacije", "6");
//        Predmet predmet2 = new Predmet("Veliki podaci", "6");
//        Predmet predmet3 = new Predmet("AOR", "8");
//
//
//        TipObaveze tipMSA1 = new TipObaveze("Kolokvijum1");
////        tipMSA1.setId_tipaObaveze(tipMSA1.getId_tipaObaveze());
//
//        TipObaveze tipMSA2 = new TipObaveze("Kolokvijum2");
////        tipMSA2.setId_tipaObaveze(tipMSA2.getId_tipaObaveze());
//
//        TipObaveze tipVP1 = new TipObaveze("Kolokvijum1");
////        tipVP1.setId_tipaObaveze(tipVP1.getId_tipaObaveze());
//
//        TipObaveze tipVP2 = new TipObaveze("Kolokvijum2");
////        tipVP2.setId_tipaObaveze(tipVP2.getId_tipaObaveze());
//
//        TipObaveze tipAOR1 = new TipObaveze("Test1");
////        tipAOR1.setId_tipaObaveze(tipAOR1.getId_tipaObaveze());
//
//        TipObaveze tipAOR2 = new TipObaveze("Test2");
////        tipAOR2.setId_tipaObaveze(tipAOR2.getId_tipaObaveze());
//
//        TipObaveze tipAOR3 = new TipObaveze("Kolokvijum1");
////        tipAOR3.setId_tipaObaveze(tipAOR3.getId_tipaObaveze());
//
//        TipObaveze tipAOR4 = new TipObaveze("Kolokvijum2");
////        tipAOR4.setId_tipaObaveze(tipAOR4.getId_tipaObaveze());




//        predmetService.save(predmet1);
//        predmetRepository.save(predmet1);
//        predmetRepository.save(predmet2);
//        tipObavezeRepository.save(tip1);

        //  Povezivanje Studenata i Predmeta

//        List<Student> studentiZaPredmet1 = new ArrayList<>();
//        studentiZaPredmet1.add(student1);
//        studentiZaPredmet1.add(student2);
//
//        List<Student> studentiZaPredmet2 = new ArrayList<>();
//        studentiZaPredmet2.add(student1);
//
//        List<Predmet> predmetiZaStudenta1 = new ArrayList<>();
//        predmetiZaStudenta1.add(predmet1);
//        predmetiZaStudenta1.add(predmet2);
//
//        List<Predmet> predmetiZaStudenta2 = new ArrayList<>();
//        predmetiZaStudenta2.add(predmet1);
//
//        student1.setPredmeti(predmetiZaStudenta1);
//        predmet1.setStudenti(studentiZaPredmet1);
//        student2.setPredmeti(predmetiZaStudenta2);
//        predmet2.setStudenti(studentiZaPredmet2);
////        studRepo.save(student1);
////        studRepo.save(student2);
//        predmetService.save(predmet1);
//        predmetService.save(predmet2);

        System.out.println("gotov je");

//        predmetService.dodajPredmetSaPredObavezama(predmet4, pio4);


//        List<PredispitneObaveze> obaveze = (List<PredispitneObaveze>) predispitneObavezeService.findAll();
//        System.out.println(obaveze);

//        predispitneObavezeService.dodajNovePredispitne(obaveze, predmet4);

//        studentService.saveAndFlush(student4);

//       predispitneObavezeService.unosPoena(student3, predmet1, tip2, 30 );

//        predispitneObavezeService.izmenaPoena(student1, predmet1, tip1, 35);

//        predispitneObavezeService.brisanjePoena(student1, predmet1, tip1, 30);

        //1.
//        List<Integer> poeni =  predispitneObavezeService.poeniPredmetINalog(student3, predmet3);
//        System.out.println(poeni);

        //2.
//        List<Predmet> predmets = predmetService.findAll();
//        List<Integer> poeniZaStudenta =  predispitneObavezeService.poeniPredmetIStudent(student1, predmet1);
//        System.out.println(poeniZaStudenta);

//        List<Integer> poeniZaStudenta = predispitneObavezeService.poeniPredmetIStudent(student1, String.valueOf(predmet1));

//        int poeniZaStudenta = predispitneObavezeService.poeniPredmetIStudent(student1, predmet1);
//        System.out.println(poeniZaStudenta);

//        List<Student> studenti = studentService.findAll();
//        int ukupno =  predispitneObavezeService.ukupnoPoeni(studenti, predmet2);
//        List<Integer> ukupno = predispitneObavezeService.ukupnoPoeni(studenti, predmet1);

//    List<Integer> ukupno = predispitneObavezeService.ukupnoPoeniPredmet(predmet1);
//        System.out.println(ukupno);
    }

}
