package vista;

import controlador.ControladorCarret;
import model.Producte;

import java.util.List;

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
     * mostra cada producte  calcula el total de la compra.
     */
    public void mostrarCarret() {
        try {
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

        }catch (Exception e){
            // Captura qualsevol error que es produeixi durant la recuperació o el mostratge del carret.
            System.out.println("Error en mostrar el contingut del carret a la classe VsitaCarret: " + e.getMessage());
        }
    }
}
