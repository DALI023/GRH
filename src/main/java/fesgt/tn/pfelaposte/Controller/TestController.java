package fesgt.tn.pfelaposte.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('EMPLOYEE') or  hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public String moderatorAccess() {
        return "Employee Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
/*There are 4 APIs:
– /api/test/all for public access
– /api/test/user for users has ROLE_USER or  ROLE_ADMIN
– /api/test/employee for users has ROLE_EMPLOYEE
– /api/test/admin for users has ROLE_ADMIN*/
