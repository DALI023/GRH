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
public class Poste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPoste;

    private String libPoste;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "poste")
    private Set<User> userS;
}
