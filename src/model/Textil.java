package model;

/**
 * Classe per representar un producte tèxtil
 */
public class Textil extends Producte {
    private String composicioTextil;

    public Textil(String nom, double preu, String codiBarres, String composicioTextil) {
        super(nom, preu, codiBarres);
        this.composicioTextil = composicioTextil;
    }

    public String getComposicioTextil() {

        return composicioTextil;
    }

    @Override
    public double calcularPreu() {
        return preu;
    }
}
