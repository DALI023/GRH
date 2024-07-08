package fesgt.tn.pfelaposte.payLoads.request;

import fesgt.tn.pfelaposte.entities.Departement;
import fesgt.tn.pfelaposte.entities.Poste;

public class ModifyProfileRequest {
    private String nom;
    private String prenom;
    private Long cin;
    private String img;
    private int age;
    private String sexe;
    private Poste poste;
    private Departement departement;

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public ModifyProfileRequest(int age, Long cin, Departement departement, String img, String nom, Poste poste, String prenom, String sexe) {
        this.age = age;
        this.cin = cin;
        this.departement = departement;
        this.img = img;
        this.nom = nom;
        this.poste = poste;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public ModifyProfileRequest() {
    }
}

