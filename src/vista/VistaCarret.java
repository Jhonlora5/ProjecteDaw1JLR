package vista;

import controlador.ControladorCarret;
import model.Producte;
import model.Magatzem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/**
 * Vista per mostrar el contingut del carret de la compra.
 * Aquesta classe és responsable de mostrar per pantalla els productes que s'han afegit al carret,
 * així com calcular i mostrar el total de la compra.
 */
public class VistaCarret {
    // Controlador que gestiona la lògica del carret.
    private ControladorCarret controladorCarret;

    /**
     * Constructor de la vista del carret.
     * @param controladorCarret controladorCarret Instància de ControladorCarret
     */
    public VistaCarret(ControladorCarret controladorCarret) {
        this.controladorCarret = controladorCarret;
    }

    /**
     * Mostra el contingut del carret per pantalla.
     * Aquest mètode recupera la llista de productes mitjançant el controlador,
     * mostra cada producte i calcula el total de la compra.
     */
    public void mostrarCarroCompraAleatori() {
        try {
            //Cridem al magatzem a traves del controlador del carret de compra.
            Magatzem magatzem = controladorCarret.getMagatzem();
            // obtenim tots els productes de la funcio corresponent de Magatzem.
            List<Producte> totsElsProductes = magatzem.getTotsElsProductes();
            //Per si de cas no tenim res al magatzem posarem les línies corresponents per tal de printar.
            if (totsElsProductes.isEmpty()) {
                System.out.println("El magatzem està buit. No hi ha productes per mostrar.");
                return;
            }

            //Barrejar la llista aleatòriament amb un collections shuffle.
            Collections.shuffle(totsElsProductes);

            // Seleccionar com a màxim 10 productes
            int limit = Math.min(10, totsElsProductes.size());
            List<Producte> seleccio = totsElsProductes.subList(0, limit);

            // Mostrar els productes seleccionats
            System.out.println("\n===== Contingut Aleatori del Magatzem (10 productes) =====");
            double total = 0.0;
            for (Producte p : seleccio) {
                System.out.println("- " + p);
                total += p.getPreu();
            }
            System.out.println("\nTotal parcial de la selecció: " + String.format("%.2f", total) + " €");
            System.out.println("========================================================");
        } catch (Exception e) {
            System.out.println("Error en mostrar el contingut aleatori del magatzem: " + e.getMessage());
        }
    }
}
