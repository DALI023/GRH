package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.Annonce;

import java.util.List;

public interface IAnnonceService {


    List<Annonce> getAllAnnonces();

    void deleteAnnonceById(long idAnnonce);
}
