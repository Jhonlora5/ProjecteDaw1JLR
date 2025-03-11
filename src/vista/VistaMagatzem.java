package vista;

import controlador.ControladorMagatzem;
import model.Producte;

import java.util.List;

/**
 * Vista per mostrar els productes del magatzem.
 *
 * Aquesta classe s'encarrega de recuperar i mostrar per pantalla la llista de productes
 * actuals del magatzem, utilitzant el controlador corresponent.
 */
public class VistaMagatzem {
    //Controlador que gestiona els productes del magatzem.
    private ControladorMagatzem controladorMagatzem;

    /**
     * Constructor de la classe VistaMagatzem.
     *
     * @param controladorMagatzem Instància de ControladorMagatzem.
     */
    public VistaMagatzem(ControladorMagatzem controladorMagatzem) {
        this.controladorMagatzem = controladorMagatzem;
    }

    /**
     * Mostra per pantalla la llista de productes actuals del magatzem.
     */
    public void mostrarMagatzem() {
        try {
            List<Producte> productes = controladorMagatzem.mostrarMagatzem();
            System.out.println("\n--- Productes al Magatzem ---");

            // Si la llista és null o buida, informem a l'usuari.
            if (productes == null || productes.isEmpty()) {
                System.out.println("No hi ha productes disponibles al magatzem.");
                return;
            }
            //Iniciem el bucle per tal de printar cada producte.
            for (Producte producte : productes) {
                System.out.println(producte);
            }
        }catch (Exception e){
            // Captura qualsevol error durant la recuperació de la llista de productes.
            System.out.println("Error al mostrar els productes del magatzem a la classe VistaMagatzem: " + e.getMessage());
        }
    }
}
