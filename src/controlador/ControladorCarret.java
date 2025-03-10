package controlador;

import model.CarretCompra;
import model.Producte;
import model.Magatzem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controlador per gestionar el carret de la compra
 */
public class ControladorCarret {
    private CarretCompra carret;
    private Magatzem magatzem;

    public ControladorCarret(CarretCompra carret) {
        this.carret = carret;
        this.magatzem = magatzem;
    }

    /**
     * Afegeix un producte al carret
     * @param producte el producte a afegir
     * @param quantitat quantitat del producte
     */
    public void afegirProducteAlCarret(Producte producte, int quantitat) {
        carret.afegirProducte(producte, quantitat);
    }

    /**
     * Mostra el contingut del carret
     * @return llista de productes al carret
     */
    public List<Producte> mostrarCarret() {
        List<Producte> llistaProductes = new ArrayList<>();
        Map<String, Integer> productes = carret.getProductes();

        for (String codiBarres : productes.keySet()) {
            Producte producte = magatzem.getProductePerCodi(codiBarres);
            if (producte != null) {
                llistaProductes.add(producte);
            }
        }

        return llistaProductes;
    }

    /**
     * Buida el carret de la compra
     */
    public void buidarCarret() {
        carret.buidarCarret();
    }
}
