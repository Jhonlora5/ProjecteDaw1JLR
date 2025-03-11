package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe per representar un producte d'alimentació.
 * Per l'alimentació fem un extend de producte on afegirem a les variables que ja tenim a la classe pare,
 * la variable dataCaducitat, on intentarem fer el calcùl de la forma que diu l'exercici.
 */
public class Alimentacio extends Producte {
    //Data que conte la data de caducitat del producte.
    private LocalDate dataCaducitat;

    /**
     * Aquesta classe és una extensió de Producte.
     * @param nom variable de la classe pare Producte.
     * @param preu variable de la classe pare Producte.
     * @param codiBarres variable de la classe pare Producte.
     * @param dataCaducitat data de caducitat del producte.
     */
    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        //Realitzem la crida a les variables de la classe Pare.
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }
    //Cridem a la data de caducitat amb el getter corresponent.
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }
    //Creem el setter corresponent per si de cas en algun moment s'ha de canviar la data corresponent.
    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    //Realitzem el calcùl del preu final de l'aliment tenint en compte la data de caducitat.
    @Override
    public double calcularPreu() {
        double preuFinal = 0.0;
        try{
            //Calculem la diferencia de dies.
            long diesFalten = ChronoUnit.DAYS.between(LocalDate.now(), dataCaducitat);
            //Recollim la diferència de dies i realitzem el calcùl amb la fórmula proporcionada per l'exercici.
            preuFinal = preu - preu * (1.0 / (diesFalten + 1)) + (preu * 0.1);
        }catch(Exception e){
            // Si es produeix qualsevol error, s'imprimeix el missatge i es retorna el preu base
            System.out.println("Error calculant el preu de l'aliment: " + e.getMessage());
            preuFinal = preu;
        }
        return preuFinal;
    }
}

