package fesgt.tn.pfelaposte.Controller;


import fesgt.tn.pfelaposte.Services.IdemandeService;
import fesgt.tn.pfelaposte.entities.Demande;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
@RestController
@AllArgsConstructor
@RequestMapping("/demande")
@Validated
public class DemandeController {
    IdemandeService demandeService;

    @PostMapping("/addDemande")
    public ResponseEntity<Demande> addDemande(@Valid @RequestBody Demande d) {
        Demande savedDemande = demandeService.addDemande(d);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }
    @GetMapping("/getAllDemandes")
    public ResponseEntity<List<Demande>> getAllDemandes() {
        List<Demande> demandes = demandeService.getAllDemandes();
        return new ResponseEntity<>(demandes, HttpStatus.OK);
    }
    /*public List<Demande> getAllDemandes(){return demandeService.getAllDemandes();}
*/
    @GetMapping("getDemandeById/{idDemande}")
    public ResponseEntity<Demande> findById(@PathVariable long idDemande) {
        Demande demande = demandeService.getDemandeById(idDemande);
        if (demande != null) {
            return new ResponseEntity<>(demande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   /* public Demande findById(@PathVariable long idDemande){return demandeService.getDemandeById(idDemande);}
*/
      @PutMapping("/updateDemande")
      public ResponseEntity<Demande> updateDemande(@Valid @RequestBody Demande d) {
          Demande updatedDemande = demandeService.updateDemande(d);
          return new ResponseEntity<>(updatedDemande, HttpStatus.OK);
      }

      /*public Demande updateDemande(@RequestBody Demande d){return demandeService.updateDemande(d);}
     */
    @PutMapping("/deleteDemande/{idDemande}")
    public ResponseEntity<Void> deleteDemande(@PathVariable long idDemande) {
        demandeService.deleteDemandeById(idDemande);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


   /* public void deleteDemande(@PathVariable long idDemande){demandeService.deleteDemandeById(idDemande);}
*/
}
