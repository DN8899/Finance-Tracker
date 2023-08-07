package com.example.FinanceTracker.security;

import com.example.FinanceTracker.dto.RegistrationDTO;
import com.example.FinanceTracker.person.Person;
import com.example.FinanceTracker.person.PersonRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final PersonRepository personRepository;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, PersonRepository personRepository) {
        this.authenticationService = authenticationService;
        this.personRepository = personRepository;
    }

    @PostMapping("/register")
    public Person registerPerson(@RequestBody RegistrationDTO registrationDTO) throws Exception {

        /*
        Makes it so the same user can't increment the userId through multiple registration attempts
         */
        if (personRepository.findByUserName(registrationDTO.getUserName()).isPresent()) {
            throw new Exception();
        }

        return authenticationService.
                registerUser(registrationDTO.getUserName(), registrationDTO.getPassword());
    }

//    @PostMapping("/login")
//    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO registrationDTO) {
//        return authenticationService.loginUser(
//                registrationDTO.getUserName(), registrationDTO.getPassword());
//
//    }

    @PostMapping("/login")
    public String getJwt(@RequestBody RegistrationDTO registrationDTO, HttpServletResponse response) {
        String token = authenticationService.loginUser(
                registrationDTO.getUserName(), registrationDTO.getPassword()).getJwt();
        response.setHeader("Cache-Control", token);
        return token;

    }

}
