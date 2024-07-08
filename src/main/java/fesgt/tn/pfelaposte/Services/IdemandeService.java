package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Demande;


import java.util.List;

public interface IdemandeService
{
    Demande addDemande(Demande d);
    List<Demande> getAllDemandes();
    Demande getDemandeById(long idDemande);
    Demande updateDemande(Demande d);
     void deleteDemandeById(long idDemande);
}
