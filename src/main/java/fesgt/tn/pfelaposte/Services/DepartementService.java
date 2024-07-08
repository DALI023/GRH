package fesgt.tn.pfelaposte.Services;


import fesgt.tn.pfelaposte.entities.Departement;
import fesgt.tn.pfelaposte.repositorys.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementService implements IdepartementService{
    private DepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement dep){return departementRepository.save(dep);}

    @Override
    public Departement getDepartementById(long id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement>getAllDepartements(){return departementRepository.findAll();}

    @Override
    public Departement updateDepartement(Departement dep) {
        return departementRepository.save(dep);
    }

    @Override
    public void deleteDepartementById(long id) {
         departementRepository.deleteById(id);

    }




}
