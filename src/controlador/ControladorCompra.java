package controlador;

import model.CarretCompra;
import model.TiquetCompra;
import model.Producte;
import model.Magatzem;

import java.util.List;
import java.util.Map;
/**
 * Controlador per gestionar les compres i la generació de tiquets
 */
public class ControladorCompra {
    private CarretCompra carret;
    private List<TiquetCompra> historialTiquets;
    private Magatzem magatzem;

    public ControladorCompra(CarretCompra carret, List<TiquetCompra> historialTiquets) {
        this.carret = carret;
        this.historialTiquets = historialTiquets;
        this.magatzem = magatzem;
    }

    public TiquetCompra passarPerCaixa(){
        return passarPerCaixa(this.magatzem);
    }

    /**
     * Finalitza la compra i genera un tiquet
     * @param magatzem magatzem on es troben els productes
     * @return el tiquet de compra generat
     */
    public TiquetCompra passarPerCaixa(Magatzem magatzem) {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : carret.getProductes().entrySet()) { // Canviat carretCompra per carret
            String codiBarres = entry.getKey();
            int quantitat = entry.getValue();

            // Busquem el producte al magatzem
            Producte producte = magatzem.getProductePerCodi(codiBarres);

            if (producte != null) {
                total += producte.getPreu() * quantitat;
            }
        }

        // Creem el tiquet amb el total calculat
        TiquetCompra tiquet = new TiquetCompra(carret.getProductes(), total);
        historialTiquets.add(tiquet);
        carret.buidarCarret(); // Buidem el carret després de finalitzar la compra
        return tiquet;
    }
}