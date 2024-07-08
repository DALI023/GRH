package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Demande;
import fesgt.tn.pfelaposte.repositorys.DemandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class DemandeService  implements  IdemandeService {

    private DemandeRepository demandeRepository;




    @Override
    public Demande addDemande(Demande d) {
        return demandeRepository.save(d);
    }

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override

    public Demande updateDemande(Demande d) {
        return demandeRepository.save(d);
    }



    @Override
    public Demande getDemandeById(long idDemande) {
        return demandeRepository.findById(idDemande).orElse(null);
    }

    @Override
    public void deleteDemandeById(long idDemande) {
        demandeRepository.deleteById(idDemande);
    }

}


