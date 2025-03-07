package vista;

import controlador.ControladorMagatzem;
import model.Producte;

import java.util.List;

/**
 * Vista per mostrar els productes del magatzem
 */
public class VistaMagatzem {
    private ControladorMagatzem controladorMagatzem;

    public VistaMagatzem(ControladorMagatzem controladorMagatzem) {
        this.controladorMagatzem = controladorMagatzem;
    }

    public void mostrarMagatzem() {
        List<Producte> productes = controladorMagatzem.mostrarMagatzem();
        System.out.println("\n--- Productes al Magatzem ---");
        for (Producte producte : productes) {
            System.out.println(producte);
        }
    }
}
