package fesgt.tn.pfelaposte.repositorys;

import fesgt.tn.pfelaposte.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CongeRepository extends JpaRepository<Conge,Long> {
    Conge findCongeByIdConge(long idConge);
    List<Conge> findByUserIdUser(Long idUser);

}
