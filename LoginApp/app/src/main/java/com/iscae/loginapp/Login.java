package com.iscae.loginapp;

public class Login {

    private String email;
    private String password;
    private String nom;

    public Login() {
    }

    public Login(String email, String password, String nom) {
        this.email = email;
        this.password = password;
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
