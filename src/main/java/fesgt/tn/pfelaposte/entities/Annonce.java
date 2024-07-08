package fesgt.tn.pfelaposte.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnnonce;



    private Date dateAnnonce;


    private String motif;

    private String titre;

    private String image;

    private String qrCode;

    @ManyToOne
    private Departement departement;

}