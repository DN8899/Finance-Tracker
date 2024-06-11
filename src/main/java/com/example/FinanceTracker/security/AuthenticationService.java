package com.example.FinanceTracker.security;

import com.example.FinanceTracker.dto.LoginResponseDTO;
import com.example.FinanceTracker.person.Person;
import com.example.FinanceTracker.person.PersonRepository;
import com.example.FinanceTracker.role.Role;
import com.example.FinanceTracker.role.RoleRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @Autowired
    public AuthenticationService(PersonRepository personRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenService tokenService) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    public Person registerUser(String userName, String password) {
        Long userId = 1L;
        while (personRepository.findByUserId(userId).isPresent()) {
            ++userId;
        }

        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);


        return personRepository.save(new Person(userId, userName, encodedPassword, authorities));
    }


    public LoginResponseDTO loginUser(String userName, String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userName, password)
            );

            String token = tokenService.generateJwt(authentication);

            return new LoginResponseDTO(personRepository
                    .findByUsername(userName).get(), token);

        } catch (AuthenticationException e) {
            AccessDeniedException accessDeniedException = null;
            return new LoginResponseDTO(null);
        }
    }

}
