package fesgt.tn.pfelaposte.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConge;



    private Date dateDebut;

    private Date dateFin;

    private String raison;

    //private Boolean archived;

    private Status status;

    @ManyToOne
    private User user;




}
