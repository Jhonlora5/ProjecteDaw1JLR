package model;

/**
 * Classe abstracta per representar un producte.
 * Aquesta classe defineix els atributs comuns a tots els productes
 *  -nom: El nom del producte.
 *  - preu: El preu del producte.
 *  - codiBarres: El codi de barres que identifica el producte de manera única(Key o clau de HashMap).
 *
 */
public abstract class Producte {
    // Atributs protegits per ser accessibles des de les subclasses.
    protected String nom;
    protected double preu;
    protected String codiBarres;

    /**
     *
     * @param nom string del nom del producte
     * @param preu double del preu del producte.
     * @param codiBarres El codi de barres del producte, clau única.
     */
    public Producte(String nom, double preu, String codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    // Getter i setters corresponents.
    // retorna el nom del producte.
    public String getNom() {

        return nom;
    }
    // retorna preu del producte
    public double getPreu() {

        return preu;
    }
    // retorna el codi de barres del producte.
    public String getCodiBarres() {

        return codiBarres;
    }
    //Actualitza el nom del producte.
    public void setNom(String nom) {

        this.nom = nom;
    }
    //Actualitza el preu del producte.
    public void setPreu(double preu) {

        this.preu = preu;
    }
    //Actualitza el codi de barres del producte.
    public void setCodiBarres(String codiBarres) {

        this.codiBarres = codiBarres;
    }
    //Calcula cridant a la funció corresponent el calcúl del preu.
    public abstract double calcularPreu();

    @Override
    public String toString() {
        try {
            // Concatena els atributs del producte en una cadena.
            return "Nom: " + nom + ", Preu: " + preu + ", Codi de barres: " + codiBarres;
        }catch(Exception e){
            //En cas d'error retornem l'error corresponent.
            return "Error a toString() a la classe producte: " + e.getMessage();
        }

    }
}
