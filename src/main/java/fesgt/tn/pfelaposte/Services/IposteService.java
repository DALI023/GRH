package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Poste;

import java.util.List;

public interface IposteService {
     Poste addPoste(Poste p);
     List<Poste> getAllPostes();
     Poste getPosteById(long idPoste);
     void deletePoste(long idPoste);
    Poste updatePoste(Poste p);


}
