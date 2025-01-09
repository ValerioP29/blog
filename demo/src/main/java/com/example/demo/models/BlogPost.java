package com.example.demo.models;

import jakarta.persistence.*;


@Entity

public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private String titolo;
    private String cover;
    private int tempoDiLettura;

    @ManyToOne
    private Author autore;

    public BlogPost(String categoria, String titolo, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.tempoDiLettura = tempoDiLettura;
    }

    public void blogPost() {
        this.cover = "https://picsum.photos/200/300";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    public Author getAutore() {
        return autore;
    }

    public void setAutore(Author autore) {
        this.autore = autore;
    }
}
