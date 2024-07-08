package fesgt.tn.pfelaposte.Services;


import fesgt.tn.pfelaposte.entities.Conge;
import fesgt.tn.pfelaposte.repositorys.CongeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CongeService implements IcongeService{
    private CongeRepository congeRepository;

    @Override
    public Conge addConge(Conge cng){return congeRepository.save(cng);}

    @Override
    public Conge  getCongeById(long idConge){return congeRepository.findById(idConge).orElse(null);}

    @Override
    public List<Conge> getAllConges(){return congeRepository.findAll();}

    @Override
    public  Conge updateConge(Conge cng){return congeRepository.save(cng);}

    @Override
    public void deleteCongeById(long idConge){ congeRepository.deleteById(idConge);}

    @Override
    public List<Conge> getCongesByUserId(Long id) {
        return congeRepository.findByUserIdUser(id);
    }



}
