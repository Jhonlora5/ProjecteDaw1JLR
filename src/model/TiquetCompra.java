package model;

import java.time.LocalDate;
import java.util.Map;

/**
 * Classe per representar un tiquet de compra
 */
public class TiquetCompra {
    private LocalDate dataCompra;
    private Map<String, Integer> productes;
    private double total;

    public TiquetCompra(Map<String, Integer> productes, double total) {
        this.dataCompra = LocalDate.now();
        this.productes = productes;
        this.total = total;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(dataCompra).append("\n");
        sb.append("Productes:\n");
        productes.forEach((codi, quantitat) -> sb.append("Codi: ").append(codi).append(", Quantitat: ").append(quantitat).append("\n"));
        sb.append("Total a pagar: ").append(total).append("€\n");
        return sb.toString();
    }
}
