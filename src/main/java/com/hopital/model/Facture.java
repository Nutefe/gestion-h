package com.hopital.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {
    private String numero;
    private String nom;
    private String prenom;
    List<Analyse> analyses = new ArrayList<>();
    private Date datejour;

    public Facture() {
    }

    public Facture(String numero, String nom, String prenom, List<Analyse> analyses, Date datejour) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.analyses = analyses;
        this.datejour = datejour;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Analyse> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analyse> analyses) {
        this.analyses = analyses;
    }

    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }
}
