package controlador;

import model.CarretCompra;
import model.Producte;

import java.util.Map;

/**
 * Controlador per gestionar el carret de la compra
 */
public class ControladorCarret {
    private CarretCompra carret;

    public ControladorCarret(CarretCompra carret) {
        this.carret = carret;
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
    public Map<String, Integer> mostrarCarret() {
        return carret.getProductes();
    }

    /**
     * Buida el carret de la compra
     */
    public void buidarCarret() {
        carret.buidarCarret();
    }
}
