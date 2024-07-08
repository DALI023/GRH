package fesgt.tn.pfelaposte.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import fesgt.tn.pfelaposte.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
