
package vista;

import controlador.ControladorCompra;
import model.TiquetCompra;

/**
 * Vista per gestionar i mostrar els tiquets de compra
 */
public class VistaCompra { private ControladorCompra controladorCompra;
    public VistaCompra(ControladorCompra controladorCompra) {
        this.controladorCompra = controladorCompra;
    }

    public void generarTiquet() {
        TiquetCompra tiquet = controladorCompra.passarPerCaixa();
        System.out.println("\n--- Tiquet de Compra ---");
        System.out.println(tiquet);
    }
}
