package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe per gestionar el carret de la compra
 */
public class CarretCompra {
    private Map<String, Integer> productes;

    public CarretCompra() {
        this.productes = new HashMap<>();
    }

    public void afegirProducte(Producte producte) {
        productes.put(producte.getCodiBarres(), productes.getOrDefault(producte.getCodiBarres(), 0) + 1);
    }

    public void buidarCarret() {
        productes.clear();
    }

    public Map<String, Integer> getProductes() {
        return productes;
    }
}

