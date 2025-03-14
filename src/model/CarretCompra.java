package model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Classe per gestionar el carret de la compra
 */
public class CarretCompra {
    //Map encarregat d'associar el codi de barres amb el producte.
    private Map<String, Integer> productes;

    /**
     * Constructor per inicialitzar el carret de la compra
     */
    public CarretCompra() {

        this.productes = new HashMap<>();
    }

    /**
     * Afegeix un producte al carret de la compra, si ja existeix incrementa la quantitat.
     * @param producte el producte a afegir
     * @param quantitat quantitat del producte
     *
     */
    public void afegirProducte(Producte producte, int quantitat) {
        try {
            if (producte == null) {
                throw new IllegalArgumentException("Error: El producte no pot ser null.");
            }
            if (quantitat <= 0) {
                throw new IllegalArgumentException("Error: La quantitat ha de ser més gran que 0.");
            }
            // Afegim el producte al carret, incrementant la quantitat si ja existeix
            productes.put(producte.getCodiBarres(),
                    productes.getOrDefault(producte.getCodiBarres(), 0) + quantitat);
        } catch (IllegalArgumentException e) {
            System.out.println("Error d'inserció de producte a la classe de CarretCompra: " + e.getMessage());
        }
    }

    /**
     * Retorna el mapa de productes amb les quantitats
     * @return mapa de productes amb els codis de barra i les quantitats.
     */
    public Map<String, Integer> getProductes() {
        return productes;
    }

    /**
     * Buida tots els productes del carret
     */
    public void buidarCarret() {
        try {
            productes.clear();
            System.out.println("El carret s'ha buidat correctament.");
        } catch (Exception e) {
            System.out.println("Error en intentar buidar el carret: " + e.getMessage());
        }
    }

    /**
     * Retorna la llista de productes del carret amb els objectes reals del magatzem
     * @param magatzem magatzem on es troben els productes
     * @return llista de productes al carret
     */
    public List<Producte> obtenirProductes(Magatzem magatzem) {
        List<Producte> llistaProductes = new ArrayList<>();
        try {
            for (String codiBarres : productes.keySet()) {
                Producte producte = magatzem.getProductePerCodi(codiBarres);
                if (producte != null) {
                    llistaProductes.add(producte);
                } else {
                    System.out.println("Avís: No s'ha trobat cap producte al magatzem amb el codi de barres " + codiBarres);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en obtenir productes del carret: " + e.getMessage());
        }
        return llistaProductes;
    }
}


