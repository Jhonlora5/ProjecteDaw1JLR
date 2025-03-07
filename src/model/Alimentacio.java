package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe per representar un producte d'alimentació
 */
public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public double calcularPreu() {
        long diesFalten = ChronoUnit.DAYS.between(LocalDate.now(), dataCaducitat);
        return preu - preu * (1.0 / (diesFalten + 1)) + (preu * 0.1);
    }
}

