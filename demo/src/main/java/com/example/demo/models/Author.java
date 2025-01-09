package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity

public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ocgnomw;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public Author(Long id, String nome, String ocgnomw, String email, String avatar, LocalDate dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.ocgnomw = ocgnomw;
        this.email = email;
        this.avatar = avatar;
        this.dataDiNascita = dataDiNascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOcgnomw() {
        return ocgnomw;
    }

    public void setOcgnomw(String ocgnomw) {
        this.ocgnomw = ocgnomw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Author(){
        this.avatar =  "https://ui-avatars.com/api/?name=Default+Author";
    }
}
