package com.example.FinanceTracker.dto;

import com.example.FinanceTracker.person.Person;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.nio.file.AccessDeniedException;

public class LoginResponseDTO {
    private Person person;
    private String jwt;
    private AccessDeniedException accessDeniedException;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(Person person, String jwt) {
        this.person = person;
        this.jwt = jwt;
    }

    public LoginResponseDTO(AccessDeniedException accessDeniedException) {
        this.accessDeniedException = accessDeniedException;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
