package controlador;

import model.CarretCompra;
import model.TiquetCompra;

import java.util.List;

/**
 * Controlador per gestionar les compres i la generació de tiquets
 */
public class ControladorCompra {
    private CarretCompra carret;
    private List<TiquetCompra> historialTiquets;

    public ControladorCompra(CarretCompra carret, List<TiquetCompra> historialTiquets) {
        this.carret = carret;
        this.historialTiquets = historialTiquets;
    }

    /**
     * Finalitza la compra i genera un tiquet
     * @return el tiquet de compra generat
     */
    public TiquetCompra passarPerCaixa() {
        TiquetCompra tiquet = new TiquetCompra(carret);
        historialTiquets.add(tiquet);
        carret.buidarCarret();
        return tiquet;
    }
}
