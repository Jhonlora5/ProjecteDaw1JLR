
package vista;

import controlador.ControladorCompra;
import model.TiquetCompra;
import model.Magatzem;
/**
 * Vista per gestionar i mostrar els tiquets de compra
 */
public class VistaCompra {
    private ControladorCompra controladorCompra;
    private Magatzem magatzem;
    public VistaCompra(ControladorCompra controladorCompra, Magatzem magatzem) {
        this.controladorCompra = controladorCompra;
        this.magatzem = magatzem;
    }

    public void generarTiquet() {
        TiquetCompra tiquet = controladorCompra.passarPerCaixa(magatzem);
        System.out.println("\n--- Tiquet de Compra ---");
        System.out.println(tiquet);
    }
}
