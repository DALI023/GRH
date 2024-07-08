package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Annonce;
import fesgt.tn.pfelaposte.repositorys.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AnnonceService implements IAnnonceService{

    AnnonceRepository annonceRepository;

     @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }



    @Override
    public void deleteAnnonceById(long idAnnonce) {
            annonceRepository.deleteById(idAnnonce);
    }
}
