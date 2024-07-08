package fesgt.tn.pfelaposte.repositorys;

import fesgt.tn.pfelaposte.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
}
