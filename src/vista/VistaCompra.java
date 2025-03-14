package vista;

import controlador.ControladorCompra;
import model.TiquetCompra;
import model.Magatzem;
/**
 * Vista per gestionar i mostrar els tiquets de compra.
 *
 * Aquesta classe s'encarrega de generar i mostrar per pantalla el tiquet de la compra
 * resultant del procés la finalització de la compra.
 */
public class VistaCompra {
    //Controlador que gestiona la compra i la generació de tiquets.
    private ControladorCompra controladorCompra;
    //Instància del magatzem, per recuperar els productes.
    private Magatzem magatzem;

    /**
     * Constructor de la classe.
     *
     * @param controladorCompra controladorCompra Instància de ControladorCompra.
     * @param magatzem magatzem Instància de Magatzem.
     */
    public VistaCompra(ControladorCompra controladorCompra, Magatzem magatzem) {
        this.controladorCompra = controladorCompra;
        this.magatzem = magatzem;
    }

    /**
     * Genera i mostra el tiquet de compra.
     */
    public void generarTiquet() {
        try {
            TiquetCompra tiquet = controladorCompra.passarPerCaixa(magatzem);
            System.out.println("\n--- Tiquet de Compra ---");
            System.out.println(tiquet);
        }catch (Exception e){
            // Captura qualsevol error durant la generació del tiquet i mostra un missatge d'error.
            System.out.println("Error generant el tiquet de compra a la classe VistaCompra: " + e.getMessage());
        }
        }
}
