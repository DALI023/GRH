package fesgt.tn.pfelaposte.repositorys;

import fesgt.tn.pfelaposte.entities.ERole;
import fesgt.tn.pfelaposte.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}