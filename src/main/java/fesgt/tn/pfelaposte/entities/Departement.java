package fesgt.tn.pfelaposte.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private Set<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private Set<Annonce> annonces;

}
