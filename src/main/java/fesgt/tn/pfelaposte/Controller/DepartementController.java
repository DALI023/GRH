package fesgt.tn.pfelaposte.Controller;


import fesgt.tn.pfelaposte.Services.IdepartementService;

import fesgt.tn.pfelaposte.entities.Departement;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class DepartementController {

    IdepartementService departementService;
    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement dep){return departementService.addDepartement(dep); }

    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementById(@PathVariable long id){return departementService.getDepartementById(id);}

    @GetMapping("/getAllDepartements")
    public List<Departement>getAllDepartements(){return departementService.getAllDepartements();}

    @PutMapping("/updateDepartement")
    public Departement updateDepartement(Departement dep){return  departementService.updateDepartement(dep);}

    @DeleteMapping("/deleteDepartementById/{id}")

    void deleteDepartementById(@PathVariable long id){departementService.deleteDepartementById(id);}
}
