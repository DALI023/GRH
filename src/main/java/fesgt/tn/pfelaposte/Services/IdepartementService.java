package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Departement;

import java.util.List;

public interface IdepartementService {
    Departement addDepartement(Departement dep);

    Departement getDepartementById(long id);

    List<Departement>getAllDepartements();

    Departement updateDepartement(Departement dep);

    void deleteDepartementById(long id);


}
