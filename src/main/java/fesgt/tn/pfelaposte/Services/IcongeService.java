package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Conge;

import java.util.List;

public interface IcongeService {
    //CRUD
    Conge  addConge(Conge cng);
    Conge  getCongeById(long IdConge);
    List<Conge> getAllConges();
    Conge updateConge(Conge cng);
    void deleteCongeById(long idConge);
    public List<Conge> getCongesByUserId(Long id);

}
