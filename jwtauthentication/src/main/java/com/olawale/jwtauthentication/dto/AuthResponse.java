package com.olawale.jwtauthentication.dto;

public class AuthResponse {
    private String jwt;

    // Constructor to set the JWT token
    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter and Setter
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
