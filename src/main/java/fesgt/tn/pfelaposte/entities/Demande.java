package fesgt.tn.pfelaposte.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Demande  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDemande;


    @ManyToOne
    @JoinColumn(name = "conge_id")
    private Conge conge;


    /*@ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "Employee ID is required")
    private User user;*/

    @NotNull(message = "Validation status is required")
    private Boolean validated;




}
