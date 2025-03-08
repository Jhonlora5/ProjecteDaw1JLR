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

        System.out.println("\n===== Contingut del Carret =====");

        if (productes.isEmpty()) {
            System.out.println("El carret està buit.");
            return;
        }

        double total = 0.0;
        for (Producte producte : productes) {
            System.out.println("- " + producte);
            total += producte.getPreu();
        }

        System.out.println("\n💰 Total de la compra: " + String.format("%.2f", total) + " €");
        System.out.println("===================================");
    }
}
