package model;

/**
 * Classe abstracta per representar un producte
 */
public abstract class Producte {
    protected String nom;
    protected double preu;
    protected String codiBarres;

    public Producte(String nom, double preu, String codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    public String getNom() {

        return nom;
    }

    public double getPreu() {

        return preu;
    }

    public String getCodiBarres() {

        return codiBarres;
    }


    public abstract double calcularPreu();

    @Override
    public String toString() {

        return "Nom: " + nom + ", Preu: " + preu + ", Codi de barres: " + codiBarres;
    }
}
