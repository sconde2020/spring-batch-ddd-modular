package com.example.batch.batch.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClientProcessed {
    @Id
    private Long id;
    private String nom;
    private String email;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
