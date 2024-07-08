package fesgt.tn.pfelaposte.Services;

import fesgt.tn.pfelaposte.entities.User;

import java.util.List;

public interface IUserService {
     User addUser(User u);
     List<User> getAllUsers() ;
     User getUserById(long idUser);
     void deleteUser(long idUser);
     User updateUser(User u);
}
