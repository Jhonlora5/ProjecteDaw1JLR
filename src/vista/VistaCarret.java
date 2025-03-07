package vista;

import controlador.ControladorCarret;
import model.Producte;

import java.util.List;

/**
 * Vista per mostrar el contingut del carret de la compra
 */
public class VistaCarret {
    private ControladorCarret controladorCarret;

    public VistaCarret(ControladorCarret controladorCarret) {
        this.controladorCarret = controladorCarret;
    }

    public void mostrarCarret() {
        List<Producte> productes = controladorCarret.mostrarCarret();
        System.out.println("\n--- Contingut del Carret ---");
        for (Producte producte : productes) {
            System.out.println(producte);
        }
    }
}
