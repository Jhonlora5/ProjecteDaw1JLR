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
     * mostra cada producte calcula el total de la compra.
     */
    public void mostrarCarroCompraAleatori() {
        try {
            // Obtenim el mapa de productes actual.
            Map<String, Integer> mapaProductes = controladorCarret.getProductesMap();
            System.out.println("Nombre d'entrades al carret: " + mapaProductes.size());

            // Si el carret està buit, afegim alguns productes per prova.
            if (mapaProductes.isEmpty()) {
                System.out.println("El carret està buit. S'estan afegint productes per prova...");
                Magatzem magatzem = controladorCarret.getMagatzem();
                List<Producte> totsElsProductes = magatzem.getTotsElsProductes();
                if (!totsElsProductes.isEmpty()) {
                    // Afegeix el primer producte amb 2 unitats.
                    controladorCarret.afegirProducteAlCarret(totsElsProductes.get(0), 2);
                    // Si hi ha almenys un segon producte, afegeix 1 unitat.
                    if (totsElsProductes.size() > 1) {
                        controladorCarret.afegirProducteAlCarret(totsElsProductes.get(1), 1);
                    }
                }
                // Torna a obtenir el mapa de productes després d'afegir.
                mapaProductes = controladorCarret.getProductesMap();
                System.out.println("Nombre d'entrades al carret després d'afegir per prova: " + mapaProductes.size());
            }

            // Creem una llista on cada producte apareix tantes vegades com la seva quantitat.
            List<Producte> llistaCompleta = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : mapaProductes.entrySet()) {
                String codiBarres = entry.getKey();
                int quantitat = entry.getValue();
                // Recuperem el producte real a partir del codi.
                Producte producte = controladorCarret.getMagatzem().getProductePerCodi(codiBarres);
                for (int i = 0; i < quantitat; i++) {
                    llistaCompleta.add(producte);
                }
            }
            System.out.println("Nombre d'entrades al carret després d'afegir per prova: " + mapaProductes.size());
            // Barrejem la llista de manera aleatòria.
            Collections.shuffle(llistaCompleta);

            // Seleccionem, com a màxim, 10 productes.
            List<Producte> seleccio;
            if (llistaCompleta.size() > 10) {
                seleccio = llistaCompleta.subList(0, 10);
            } else {
                seleccio = llistaCompleta;
            }

            // Mostrem la selecció per pantalla.
            System.out.println("\n===== Contingut Aleatori del Carret (10 productes) =====");
            double total = 0.0;
            for (Producte p : seleccio) {
                System.out.println("- " + p);
                total += p.getPreu();
            }
            System.out.println("\nTotal parcial de la selecció: " + String.format("%.2f", total) + " €");
            System.out.println("========================================================");
        } catch (Exception e) {
            System.out.println("Error en mostrar el contingut del carret aleatori: " + e.getMessage());
        }
    }
}
