package model;

/**
 * Classe per representar un producte electrònic.
 *
 * Aquesta classe és una extensió de la classe Producte.
 */
public class Electronica extends Producte {
    // Nùmero de dies de garantia que té el producte.
    private int diesGarantia;

    /**
     * Constructor de la classe Electronica.
     *
     * @param nom variable de la classe pare Producte.
     * @param preu variable de la classe pare Producte.
     * @param codiBarres variable de la classe pare Producte.
     * @param diesGarantia dies de garantia guardará els dies totals de garantia del producte.
     */
    public Electronica(String nom, double preu, String codiBarres, int diesGarantia) {
        super(nom, preu, codiBarres);
        this.diesGarantia = diesGarantia;
    }


    /**
     * Calcula el preu final del producte electronic amb els dies de garantía que ens queden.
     * Amb la fórmula proporcionada per l'exercici.
     * @return el preu calculat amb la garantía que queda.
     */
    @Override
    public double calcularPreu() {
        double preuFinal = preu;
        try {
            //Calcular el preu final afegint un increment basat en els dies de garantía.
            preuFinal = preu + preu * (diesGarantia / 365.0) * 0.1;
        }catch(Exception e){
            // Si hi ha algun error, es mostra el missatge i es retorna el preu base.
            System.out.println("Error al calcular el preu del producte electrònic: " + e.getMessage());
            preuFinal = preu;
        }
        return preuFinal;
    }
}
