package rs.raf.prviProjekat.bootstrap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.raf.prviProjekat.model.PredispitneObaveze;
import rs.raf.prviProjekat.model.Predmet;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.repositories.PredispitneObavezeRepository;
import rs.raf.prviProjekat.repositories.PredmetRepository;
import rs.raf.prviProjekat.repositories.StudentRepository;

import java.util.ArrayList;


@Component
public class BootstrapData implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final PredmetRepository predmetRepository;

    private final PredispitneObavezeRepository predispitneObavezeRepository;


    @Autowired
    public BootstrapData(StudentRepository studentRepository, PredmetRepository predmetRepository, PredispitneObavezeRepository predispitneObavezeRepository) {
        this.studentRepository = studentRepository;
        this.predmetRepository = predmetRepository;
        this.predispitneObavezeRepository = predispitneObavezeRepository;
    }

    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");

        PredispitneObaveze tipMsa1 = new PredispitneObaveze( 0);
//        tipMsa1.setNaziv("Kolokvijum1");
        PredispitneObaveze tipMsa2 = new PredispitneObaveze( 0);
//        tipMsa2.setNaziv("Kolokvijum2");
        PredispitneObaveze tipMsa3 = new PredispitneObaveze(0);
//        tipMsa3.setNaziv("Test");

        PredispitneObaveze tipVp1 = new PredispitneObaveze(0);
//        tipVp1.setNaziv("Kolokvijum1");
        PredispitneObaveze tipVp2 = new PredispitneObaveze(0);
//        tipVp2.setNaziv("Kolokvijum2");
        PredispitneObaveze tipVp3 = new PredispitneObaveze(0);
//        tipVp3.setNaziv("Projekat");

        PredispitneObaveze tipAOR1 = new PredispitneObaveze( 0);
//        tipAOR1.setNaziv("Kolokvijum1");
        PredispitneObaveze tipAOR2 = new PredispitneObaveze();
//        tipAOR2.setNaziv("Kolokvijum1");
        PredispitneObaveze tipAOR3 = new PredispitneObaveze();
//        tipAOR3.setNaziv("Kolokvijum1");

        PredispitneObaveze pioMisa1 = new PredispitneObaveze(10);
        pioMisa1.setNaziv("Kolokvijum1");
        PredispitneObaveze pioMisa2 =  new PredispitneObaveze(15);
        pioMisa2.setNaziv("Kolokvijum2");
        PredispitneObaveze pioMisa3 = new PredispitneObaveze(0);
        pioMisa3.setNaziv("Test");

        PredispitneObaveze pioPetar1 = new PredispitneObaveze(15);
        pioPetar1.setNaziv("Kolokvijum1");
        PredispitneObaveze pioPetar2 =  new PredispitneObaveze(20);
        pioPetar2.setNaziv("Kolokvijum2");
        PredispitneObaveze pioPetar3 = new PredispitneObaveze(10);
        pioPetar3.setNaziv("Projekat");

        PredispitneObaveze pioMika1 = new PredispitneObaveze(15);
        pioMika1.setNaziv("Kolokvijum1");
        PredispitneObaveze pioMika2 =  new PredispitneObaveze(25);
        pioMika2.setNaziv("Kolokvijum2");
        PredispitneObaveze pioMika3 = new PredispitneObaveze(5);
        pioMika3.setNaziv("Projekat");

        PredispitneObaveze pioLaza1 = new PredispitneObaveze(15);
        pioLaza1.setNaziv("Kolokvijum1");
        PredispitneObaveze pioLaza2 =  new PredispitneObaveze(15);
        pioLaza2.setNaziv("Kolokvijum12");
        PredispitneObaveze pioLaza3 = new PredispitneObaveze(20);
        pioLaza3.setNaziv("Test");

        PredispitneObaveze pioMilan1 = new PredispitneObaveze(10);
        pioMilan1.setNaziv("Kolokvijum1");
        PredispitneObaveze pioMilan2 =  new PredispitneObaveze(15);
        pioMilan2.setNaziv("Kolokvijum2");
        PredispitneObaveze pioMilan3 = new PredispitneObaveze(10);
        pioMilan3.setNaziv("Test");

        Student misa = new Student("Misa", "Misic", "121ri");
        Student petar = new Student("Petar", "Petrovic", "47rn");
        Student laza = new Student("Laza", "Lazic", "62ri");
        Student mika = new Student("Mika", "Mikic", "29rn");
        Student milan = new Student("Milan", "Milovanovic", "93ri");

        Predmet predmet1 = new Predmet("MSA", "6");
        Predmet predmet2 = new Predmet("VP", "6");
        Predmet predmet3 = new Predmet("AOR", "8");



        //  Povezivanje tipObaveza, Predmeta i predispitne
        //iz studenta
        misa.setPredmeti(new ArrayList<>());
        misa.dodajPredmet(predmet1);
        misa.dodajPredmet(predmet2);
        misa.dodajPredmet(predmet3);

        laza.setPredmeti(new ArrayList<>());
        laza.dodajPredmet(predmet1);
        laza.dodajPredmet(predmet2);
        laza.dodajPredmet(predmet3);

        mika.setPredmeti(new ArrayList<>());
        mika.dodajPredmet(predmet1);
        mika.dodajPredmet(predmet2);
        mika.dodajPredmet(predmet3);

        milan.setPredmeti(new ArrayList<>());
        milan.dodajPredmet(predmet1);
        milan.dodajPredmet(predmet2);
        milan.dodajPredmet(predmet3);

        petar.setPredmeti(new ArrayList<>());
        petar.dodajPredmet(predmet1);
        petar.dodajPredmet(predmet2);
        petar.dodajPredmet(predmet3);

//        student1.setPredmeti(new ArrayList<>());
//        student1.dodajPredmet(predmet1);

//        student2.setPredmeti(new ArrayList<>());
//        student2.dodajPredmet(predmet2);

        tipMsa1.setPredmet(predmet1);
        tipMsa2.setPredmet(predmet1);
        tipMsa3.setPredmet(predmet1);
        tipVp1.setPredmet(predmet2);
        tipVp2.setPredmet(predmet2);
        tipVp3.setPredmet(predmet2);
        tipAOR1.setPredmet(predmet3);
        tipAOR2.setPredmet(predmet3);
        tipAOR3.setPredmet(predmet3);


        //u predmetu
        predmet1.setObaveze(new ArrayList<>());
        predmet1.dodajPredispitne(tipMsa1);
        predmet1.dodajPredispitne(tipMsa2);
        predmet1.dodajPredispitne(tipMsa3);

        predmet2.setObaveze(new ArrayList<>());
        predmet2.dodajPredispitne(tipVp1);
        predmet2.dodajPredispitne(tipVp2);
        predmet2.dodajPredispitne(tipVp3);

        predmet3.setObaveze(new ArrayList<>());
        predmet3.dodajPredispitne(tipAOR1);
        predmet3.dodajPredispitne(tipAOR2);
        predmet3.dodajPredispitne(tipAOR3);

        pioMisa1.setStudent(misa);
        pioMisa2.setStudent(misa);
        pioMisa3.setStudent(misa);

        pioLaza1.setStudent(laza);
        pioLaza2.setStudent(laza);
        pioLaza3.setStudent(laza);

        pioMika1.setStudent(mika);
        pioMika2.setStudent(mika);
        pioMika3.setStudent(mika);

        pioMilan1.setStudent(milan);
        pioMilan2.setStudent(milan);
        pioMilan3.setStudent(milan);

        pioPetar1.setStudent(petar);
        pioPetar2.setStudent(petar);
        pioPetar3.setStudent(petar);

        //u studentu
        misa.setObaveze(new ArrayList<>());
        misa.dodajPredispitneStudent(pioMisa1);
        misa.dodajPredispitneStudent(pioMisa2);
        misa.dodajPredispitneStudent(pioMisa3);

        laza.setObaveze(new ArrayList<>());
        laza.dodajPredispitneStudent(pioLaza1);
        laza.dodajPredispitneStudent(pioLaza2);
        laza.dodajPredispitneStudent(pioLaza3);

        mika.setObaveze(new ArrayList<>());
        mika.dodajPredispitneStudent(pioMika1);
        mika.dodajPredispitneStudent(pioMika2);
        mika.dodajPredispitneStudent(pioMika3);

        milan.setObaveze(new ArrayList<>());
        milan.dodajPredispitneStudent(pioMilan1);
        milan.dodajPredispitneStudent(pioMilan2);
        milan.dodajPredispitneStudent(pioMilan3);

        petar.setObaveze(new ArrayList<>());
        petar.dodajPredispitneStudent(pioPetar1);
        petar.dodajPredispitneStudent(pioPetar2);
        petar.dodajPredispitneStudent(pioPetar3);

        studentRepository.save(misa);
        studentRepository.save(laza);
        studentRepository.save(mika);
        studentRepository.save(milan);
        studentRepository.save(petar);

//        student1.setObaveze(new ArrayList<>());
//        student1.dodajPredispitneStudent(pio1);
//        student2.setObaveze(new ArrayList<>());
//        student2.dodajPredispitneStudent(pio1);

        //u predmetu setStudenti
        predmet1.setStudenti(new ArrayList<>());
        predmet1.dodajStudenta(misa);
        predmet1.dodajStudenta(petar);
        predmet1.dodajStudenta(laza);
        predmet1.dodajStudenta(milan);
        predmet1.dodajStudenta(mika);

        predmet2.setStudenti(new ArrayList<>());
        predmet2.dodajStudenta(misa);
        predmet2.dodajStudenta(petar);
        predmet2.dodajStudenta(laza);
        predmet2.dodajStudenta(milan);
        predmet2.dodajStudenta(mika);

        predmet3.setStudenti(new ArrayList<>());
        predmet3.dodajStudenta(misa);
        predmet3.dodajStudenta(petar);
        predmet3.dodajStudenta(laza);
        predmet3.dodajStudenta(milan);
        predmet3.dodajStudenta(mika);


        predmetRepository.save(predmet1);
        predmetRepository.save(predmet2);
        predmetRepository.save(predmet3);

//        tipMsa1.setPredmet(predmet1);
//        tipMsa2.setPredmet(predmet1);
//        tipMsa3.setPredmet(predmet1);
//
//        tipVp1.setPredmet(predmet2);
//        tipVp2.setPredmet(predmet2);
//        tipVp3.setPredmet(predmet2);
//
//        tipAOR1.setPredmet(predmet3);
//        tipAOR2.setPredmet(predmet3);
//        tipAOR3.setPredmet(predmet3);

        pioMisa1.setPredmet(predmet1);
        pioMisa2.setPredmet(predmet2);
        pioMisa3.setPredmet(predmet3);

        pioLaza1.setPredmet(predmet1);
        pioLaza2.setPredmet(predmet2);
        pioLaza3.setPredmet(predmet3);

        pioMika1.setPredmet(predmet1);
        pioMika2.setPredmet(predmet2);
        pioMika3.setPredmet(predmet3);

        pioMilan1.setPredmet(predmet1);
        pioMilan2.setPredmet(predmet2);
        pioMilan3.setPredmet(predmet3);

        pioPetar1.setPredmet(predmet1);
        pioPetar2.setPredmet(predmet2);
        pioPetar3.setPredmet(predmet3);

//        predispitneObavezeRepository.save(tipMsa1);
//        predispitneObavezeRepository.save(tipMsa2);
//        predispitneObavezeRepository.save(tipMsa3);
//        predispitneObavezeRepository.save(tipVp1);
//        predispitneObavezeRepository.save(tipVp2);
//        predispitneObavezeRepository.save(tipVp3);
//        predispitneObavezeRepository.save(tipAOR1);
//        predispitneObavezeRepository.save(tipAOR2);
//        predispitneObavezeRepository.save(tipAOR3);


        predispitneObavezeRepository.save(pioMisa1);
        predispitneObavezeRepository.save(pioMisa2);
        predispitneObavezeRepository.save(pioMisa3);

        predispitneObavezeRepository.save(pioMika1);
        predispitneObavezeRepository.save(pioMika2);
        predispitneObavezeRepository.save(pioMika3);

        predispitneObavezeRepository.save(pioLaza1);
        predispitneObavezeRepository.save(pioLaza2);
        predispitneObavezeRepository.save(pioLaza3);

        predispitneObavezeRepository.save(pioMilan1);
        predispitneObavezeRepository.save(pioMilan2);
        predispitneObavezeRepository.save(pioMilan3);

        predispitneObavezeRepository.save(pioPetar1);
        predispitneObavezeRepository.save(pioPetar2);
        predispitneObavezeRepository.save(pioPetar3);

        System.out.println("Data loaded!");
    }

}
