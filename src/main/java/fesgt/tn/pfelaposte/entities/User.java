package fesgt.tn.pfelaposte.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    private long cin;

    private String username;

    private String nom;

    private String prenom;

    private int age;

    private String sexe;

    private String img;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Conge> conges;

    @ManyToOne
    private Poste poste;

    @ManyToOne
    private Departement departement;

    // Full Constructor
    public User(long idUser, long cin, String username, String nom, String prenom, int age, String sexe, ERole role, String email, String password, Poste poste, Departement departement) {
        this.idUser = idUser;
        this.cin = cin;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.email = email;
        this.password = password;
        this.poste = poste;
        this.img=img;
        this.departement = departement;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.img=img;
    }

    // Constructor used in signUpRequest
    public User(String username, String nom, ERole role, String prenom, String email, int age, String sexe, long cin, String password) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
        this.sexe = sexe;
        this.cin = cin;
        this.password = password;
        this.img=img;
    }

    // Getters and setters
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
