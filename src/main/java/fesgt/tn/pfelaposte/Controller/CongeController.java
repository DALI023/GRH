package fesgt.tn.pfelaposte.Controller;

import fesgt.tn.pfelaposte.Services.IcongeService;
import fesgt.tn.pfelaposte.entities.Conge;
import fesgt.tn.pfelaposte.entities.User;
import fesgt.tn.pfelaposte.repositorys.CongeRepository;
import fesgt.tn.pfelaposte.repositorys.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conge")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class CongeController {
    IcongeService congeService;
    CongeRepository congeRepository;
    UserRepository userRepository;
   @PostMapping("/addConge")
    public Conge addConge(@RequestBody Conge cng){return congeService.addConge(cng);}

    @GetMapping("/getCongeById/{idConge}")
    public Conge getCongeById(@PathVariable long idConge){return congeService.getCongeById(idConge);}

    @GetMapping("getAllConges")
    public List<Conge> getAllConges(){return congeService.getAllConges();}

    @PutMapping("/updateConge")
    public   Conge updateConge(@RequestBody Conge cng){return congeService.updateConge(cng);}

    @DeleteMapping("deleteCongeById/{idConge}")
    public  void deleteCongeById(@PathVariable long idConge){congeService.deleteCongeById(idConge);}


@PostMapping("/addCongeandAffectToUser/{idUser}")
 public Conge addCongeAndAssignCongeToUser(@PathVariable Long idUser,@RequestBody Conge conge) {
  User user = userRepository.findById(idUser).orElse(null);
  if (user != null) {
   conge.setUser(user);
   userRepository.save(user);
   return congeRepository.save(conge);
  } else {
   return null;
  }
 }
 @GetMapping("/getMyConges/{idUser}")
 public List<Conge> getCongesByUserId(@PathVariable Long idUser){return congeService.getCongesByUserId(idUser);}

}
