package rs.raf.prviProjekat.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.prviProjekat.model.PredispitneObaveze;
import rs.raf.prviProjekat.model.Predmet;

import java.util.List;

public interface PredmetRepository extends CrudRepository<Predmet, Integer> {
//    void dodajPredmetSaPredObavezama(Predmet predmet, PredispitneObaveze pio);
}
