// ControladorMagatzem.java
package controlador;

import model.Magatzem;
import model.Producte;

import excepcions.ProducteDuplicatException;

import java.util.List;

/**
 * Controlador per gestionar el magatzem de productes
 */
public class ControladorMagatzem {
    private Magatzem magatzem;

    public ControladorMagatzem(Magatzem magatzem) {
        this.magatzem = magatzem;
    }

    /**
     * Afegeix un producte al magatzem
     * @param producte el producte a afegir
     * @throws ProducteDuplicatException si el producte ja existeix
     */
    public void afegirProducteAlMagatzem(Producte producte)
            throws ProducteDuplicatException {
        magatzem.afegirProducte(producte);
    }

    /**
     * Mostra els productes del magatzem
     * @return llista de productes al magatzem
     */
    public List<Producte> mostrarMagatzem() {
        return magatzem.getTotsElsProductes();
    }
}
