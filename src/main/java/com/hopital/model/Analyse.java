package com.hopital.model;

public class Analyse {
    private int quantite;
    private String designation;
    private double prixunitaire;
    private double montant;

    public Analyse() {
    }

    public Analyse(int quantite, String designation, double prixunitaire, double montant) {
        this.quantite = quantite;
        this.designation = designation;
        this.prixunitaire = prixunitaire;
        this.montant = montant;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
