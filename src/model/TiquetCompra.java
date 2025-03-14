package model;

import java.time.LocalDate;
import java.util.Map;

/**
 * Classe per representar un tiquet de compra
 */
public class TiquetCompra {
    //Data on es genera el tiquet
    private LocalDate dataCompra;
    //Mapa de productes amb el seu codi de barres i la quantitat.
    private Map<String, Integer> productes;
    //Total a pagar pel conjunt de productes.
    private double total;

    /**
     * Constructor de la classe TiquetCompra.
     * @param productes Mapa de productes amb el seu codi de barres i el total.
     * @param total total a pagar pel conjunt de productes.
     */
    public TiquetCompra(Map<String, Integer> productes, double total) {
        this.dataCompra = LocalDate.now();
        this.productes = productes;
        this.total = total;
    }

    /**
     * Mètode per generar una representació en text del tiquet de compra.
     * Mostra la data, els productes i el total a pagar.
     * @return String que representa el tiquet de compra.
     */
    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Data: ").append(dataCompra).append("\n");
            sb.append("Productes:\n");

            // Utilitzarem una lambda expression per recórrer el mapa de productes.
            productes.forEach((codi, quantitat) -> {
                sb.append("Codi: ").append(codi)
                        .append(", Quantitat: ").append(quantitat).append("\n");
            });

            sb.append("Total a pagar: ").append(String.format("%.2f", total)).append("€\n");
            return sb.toString();
        }catch (Exception e) {
            return "Error en generar el tiquet de compra: " + e.getMessage();
        }
    }
}
