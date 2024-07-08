package fesgt.tn.pfelaposte.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import fesgt.tn.pfelaposte.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByCin(long cin);
    Boolean existsUserByNom(String nom);
    Optional<User> findUserByNom(String nom);
    Boolean existsUserByCin(long cin);  // Correct method name
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}

