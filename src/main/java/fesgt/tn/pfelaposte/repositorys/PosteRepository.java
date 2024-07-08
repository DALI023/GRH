package fesgt.tn.pfelaposte.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import fesgt.tn.pfelaposte.entities.Poste;

public interface PosteRepository extends JpaRepository<Poste,Long> {
}
