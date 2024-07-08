package fesgt.tn.pfelaposte.Controller;

import fesgt.tn.pfelaposte.Services.IAnnonceService;
import fesgt.tn.pfelaposte.entities.Annonce;
import fesgt.tn.pfelaposte.entities.Conge;
import fesgt.tn.pfelaposte.entities.Departement;
import fesgt.tn.pfelaposte.entities.User;
import fesgt.tn.pfelaposte.repositorys.AnnonceRepository;
import fesgt.tn.pfelaposte.repositorys.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class AnnonceController {



    IAnnonceService iAnnonceService;
    AnnonceRepository annonceRepository;
    DepartementRepository departementRepository;
    @PostMapping("/addCongeandAffectToDepartement/{idDepartement}")
    public Annonce addCongeandAffectToDepartement(@PathVariable Long idDepartement, @RequestBody Annonce annonce) {
        Departement user = departementRepository.findById(idDepartement).orElse(null);
        if (user != null) {
            annonce.setDepartement(user);
            String qrData =
                    " Date de l'annonce:" + annonce.getDateAnnonce() +
                    " , Le titre de l'annonce :" + annonce.getTitre() +
                    " , Le motif de l'annonce :" + annonce.getTitre() +
                    " , Le département de l'annonce :" + annonce.getDepartement().getLibelle();
            String qrCodeUrl = generateQRCode(qrData);
            annonce.setQrCode(qrCodeUrl);
            departementRepository.save(user);
            return annonceRepository.save(annonce);
        } else {
            return null;
        }

    }
    private String generateQRCode(String data) {
        return "http://api.qrserver.com/v1/create-qr-code/?data=" + data + "&size=100x100";
    }
    @GetMapping("/getAllAnnonces")
    public List<Annonce> getAllAnnonces(){return iAnnonceService.getAllAnnonces();}

    @DeleteMapping("/deleteAnnonceById/{idAnnonce}")
    public  void deleteAnnonceById(@PathVariable long idAnnonce){iAnnonceService.deleteAnnonceById(idAnnonce);}

}
