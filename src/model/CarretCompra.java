package model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Classe per gestionar el carret de la compra
 */
public class CarretCompra {
    private Map<String, Integer> productes;

    public CarretCompra() {
        this.productes = new HashMap<>();
    }

    /**
     * Afegeix un producte al carret de la compra
     * @param producte el producte a afegir
     * @param quantitat quantitat del producte
     */
    public void afegirProducte(Producte producte, int quantitat) {
        if (producte == null || quantitat <= 0) {
            System.out.println("Error: Producte no vàlid o quantitat incorrecta.");
            return;
        }
        productes.put(producte.getCodiBarres(),
                productes.getOrDefault(producte.getCodiBarres(), 0) + quantitat);
    }

    /**
     * Retorna el mapa de productes amb les quantitats
     * @return mapa de productes
     */
    public Map<String, Integer> getProductes() {
        return productes;
    }

    /**
     * Buida tots els productes del carret
     */
    public void buidarCarret() {
        productes.clear();
    }

    /**
     * Retorna la llista de productes del carret amb els objectes reals del magatzem
     * @param magatzem magatzem on es troben els productes
     * @return llista de productes al carret
     */
    public List<Producte> obtenirProductes(Magatzem magatzem) {
        List<Producte> llistaProductes = new ArrayList<>();
        for (String codiBarres : productes.keySet()) {
            Producte producte = magatzem.getProductePerCodi(codiBarres);
            if (producte != null) {
                llistaProductes.add(producte);
            }
        }
        return llistaProductes;
    }
}


