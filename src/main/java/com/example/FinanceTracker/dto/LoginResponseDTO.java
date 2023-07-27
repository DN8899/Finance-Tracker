package com.example.FinanceTracker.dto;

import com.example.FinanceTracker.person.Person;

public class LoginResponseDTO {
    private Person person;
    private String jwt;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(Person person, String jwt) {
        this.person = person;
        this.jwt = jwt;
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
