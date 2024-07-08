package fesgt.tn.pfelaposte.Services;


import fesgt.tn.pfelaposte.entities.Poste;
import fesgt.tn.pfelaposte.repositorys.PosteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PosteService implements  IposteService{

    private PosteRepository posteRepository;

    @Override
    public Poste addPoste(Poste p){return posteRepository.save(p);}

    @Override
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @Override
    public Poste getPosteById(long idPoste) {
        return posteRepository.findById(idPoste).orElse(null);
    }

    @Override
    public void deletePoste(long idPoste) {
    posteRepository.deleteById(idPoste);
    }

    @Override
    public Poste updatePoste(Poste p) {
        return posteRepository.save(p);
    }






}
