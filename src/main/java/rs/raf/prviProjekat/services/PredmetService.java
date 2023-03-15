package rs.raf.prviProjekat.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.prviProjekat.model.PredispitneObaveze;
import rs.raf.prviProjekat.model.Predmet;
import rs.raf.prviProjekat.model.Student;
import rs.raf.prviProjekat.repositories.PredmetRepository;


import java.util.*;

@Service
public class PredmetService {
    private final PredmetRepository predmetRepository;

    public PredmetService(PredmetRepository predmetRepository) {
        this.predmetRepository = predmetRepository;
    }

    public <P extends Predmet> P save(P predmet){
        return predmetRepository.save(predmet);
    }

    public Optional<Predmet> findById(Integer predmetId){
        return predmetRepository.findById(predmetId);
    }

    public List<Predmet> findAll(){
        return (List<Predmet>) predmetRepository.findAll();
    }

    public void deleteById(Integer predmetId){
        predmetRepository.deleteById(predmetId);
    }

    public Predmet findByNazivPredmeta(String predmet) {
        for (Predmet p : predmetRepository.findAll()){
            if (p.getNaziv().equals(predmet)){
                return p;
            }
        }
        return null;
    }


    @Transactional
    public Predmet dodajPredispitne(Integer id_predmet, PredispitneObaveze predispitneObaveze){
        Optional<Predmet> optionalPredmet = this.findById(id_predmet);
        if(optionalPredmet.isPresent()){
            Predmet predmet = optionalPredmet.get();
            if(predmet.getObaveze() == null){
                predmet.setObaveze(new ArrayList<>());
            }
            predmet.dodajPredispitne(predispitneObaveze);
            predmetRepository.save(predmet);
            return predmet;
        }
        return null;
    }

    public List<Student> findStudents(Integer id_predmeta) {
        Optional<Predmet> optionalPredmet = findById(id_predmeta);
        if(optionalPredmet.isPresent()){
            Predmet predmet = optionalPredmet.get();
            return predmet.getStudenti();
        }
        return null;
    }


}
