package model;

/**
 * Classe per representar un producte tèxtil.
 */
public class Textil extends Producte {
    //Atribut que representa la composicio del teixit, per exemple 100% cotó.
    private String composicioTextil;

    /**
     * Contructor de la classe Textil.
     *
     * @param nom variable de la classe pare Producte.
     * @param preu variable de la classe pare Producte.
     * @param codiBarres variable de la classe pare Producte.
     * @param composicioTextil string encarregat de guardar la composició del teixit.
     */
    public Textil(String nom, double preu, String codiBarres, String composicioTextil) {
        super(nom, preu, codiBarres);
        this.composicioTextil = composicioTextil;
    }
    //Realitzem el getter corresponent, retorna la composició del teixit.
    public String getComposicioTextil() {

        return composicioTextil;
    }


    @Override
    public double calcularPreu() {
        double preuFinal=preu;
        try {
            //Apliquem el preu ja calculat al preuFinal.
            preuFinal=preu;
        }catch(Exception e){
            // Captura qualsevol error i mostra un missatge.
            System.out.println("Error al calcular el preu del producte tèxtil a la classe Teixit: " + e.getMessage());
            preuFinal = preu;
        }
        return preuFinal;
    }
}
