package com.example.FinanceTracker.security;

import com.example.FinanceTracker.dto.LoginResponseDTO;
import com.example.FinanceTracker.dto.RegistrationDTO;
import com.example.FinanceTracker.person.Person;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Person registerPerson(@RequestBody RegistrationDTO registrationDTO) {

        return authenticationService.
                registerUser(registrationDTO.getUserName(), registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.loginUser(
                registrationDTO.getUserName(), registrationDTO.getPassword());

    }

}
