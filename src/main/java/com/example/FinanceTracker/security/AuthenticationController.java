package com.example.FinanceTracker.security;

import com.example.FinanceTracker.dto.RegistrationDTO;
import com.example.FinanceTracker.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public Person registerPerson(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.
                registerUser(registrationDTO.getUserName(), registrationDTO.getPassword());
    }

}
