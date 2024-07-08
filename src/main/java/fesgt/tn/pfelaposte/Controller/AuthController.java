package fesgt.tn.pfelaposte.Controller;

import fesgt.tn.pfelaposte.Services.UserDetailsImpl;
import fesgt.tn.pfelaposte.entities.ERole;
import fesgt.tn.pfelaposte.entities.Role;
import fesgt.tn.pfelaposte.entities.User;
import fesgt.tn.pfelaposte.payLoads.request.ModifyProfileRequest;
import fesgt.tn.pfelaposte.payLoads.request.SigninRequest;
import fesgt.tn.pfelaposte.payLoads.request.SignupRequest;
import fesgt.tn.pfelaposte.payLoads.response.MessageResponse;
import fesgt.tn.pfelaposte.payLoads.response.UserInfoResponse;
import fesgt.tn.pfelaposte.repositorys.RoleRepository;
import fesgt.tn.pfelaposte.repositorys.UserRepository;
import fesgt.tn.pfelaposte.security.jwt.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity
                .ok(new UserInfoResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getImg(),userDetails.getNom(),userDetails.getPrenom(),userDetails.getDepartement(),userDetails.getPoste(),userDetails.getSexe(),userDetails.getAge(),userDetails.getCin(),roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
                user.setNom(signUpRequest.getNom());
                user.setPrenom(signUpRequest.getPrenom());
                user.setCin(signUpRequest.getCin());
                user.setImg(signUpRequest.getImg());
                user.setAge(signUpRequest.getAge());
                user.setSexe(signUpRequest.getSexe());
                user.setPoste(signUpRequest.getPoste());
                user.setDepartement(signUpRequest.getDepartement());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }




  /*signOut*/
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
    @GetMapping("/getallusers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @DeleteMapping("/supprimerUser/{idUser}")
    public void deleteUser(@PathVariable long idUser) {
        userRepository.deleteById(idUser);
    }

    @PutMapping("/modifyMyProfile/{idUser}")
    public ResponseEntity<?> modifyUserProfile(@PathVariable Long idUser, @Valid @RequestBody ModifyProfileRequest modifyRequest) {
        Optional<User> userData = userRepository.findById(idUser);

        if (userData.isPresent()) {
            User user = userData.get();


            user.setNom(modifyRequest.getNom());
            user.setPrenom(modifyRequest.getPrenom());
            user.setCin(modifyRequest.getCin());
            user.setImg(modifyRequest.getImg());
            user.setAge(modifyRequest.getAge());
            user.setSexe(modifyRequest.getSexe());
            user.setPoste(modifyRequest.getPoste());
            user.setDepartement(modifyRequest.getDepartement());

            userRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User profile updated successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User not found."));
        }
    }
    @GetMapping("/getUserById/{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable Long idUser) {
        Optional<User> userData = userRepository.findById(idUser);

        if (userData.isPresent()) {
            User user = userData.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
/*This controller provides APIs for register and login, logout actions.

– /api/auth/signup

check existing username/email
create new User (with ROLE_USER if not specifying role)
save User to database using UserRepository
– /api/auth/signin

authenticate { username, pasword }
update SecurityContext using Authentication object
generate JWT
get UserDetails from Authentication object
response contains JWT and UserDetails data
– /api/auth/signout: clear the Cookie.*/

