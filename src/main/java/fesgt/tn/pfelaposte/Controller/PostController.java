 package fesgt.tn.pfelaposte.Controller;

import fesgt.tn.pfelaposte.Services.IposteService;
import fesgt.tn.pfelaposte.entities.Poste;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/poste")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class PostController {
    IposteService posteService;


    @PostMapping("/addPoste")
    public Poste addPoste(@RequestBody Poste p){return posteService.addPoste(p);}

    @GetMapping("/getAllPostes")
    public List<Poste> getAllPostes() {
        return posteService.getAllPostes();
    }

    @PutMapping("/modifierPoste")
    public Poste updatePoste(@RequestBody Poste p){return posteService.updatePoste(p);}

    @GetMapping("/getPoste/{idPoste}")
    public Poste findById(@PathVariable long idPoste){
        return posteService.getPosteById(idPoste);
    }

    @DeleteMapping("/supprimerPoste/{idPoste}")
    public void deletePoste(@PathVariable long idPoste){
        posteService.deletePoste(idPoste);
    }
}
