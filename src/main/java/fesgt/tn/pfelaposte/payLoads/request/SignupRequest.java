package fesgt.tn.pfelaposte.payLoads.request;


import fesgt.tn.pfelaposte.entities.Departement;
import fesgt.tn.pfelaposte.entities.Poste;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {


    private long cin;

    private String username;

    private String nom;

    private String prenom;

    private int age;

    private String sexe;

    private Set<String> role;

    private String email;

    private String password;

    private String img;

    private Departement departement;

    private Poste poste;


}
