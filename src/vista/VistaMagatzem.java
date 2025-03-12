package vista;

import controlador.ControladorMagatzem;
import model.Alimentacio;
import model.Producte;
import model.Textil;

import java.util.List;
import java.util.Scanner;
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
    /**
     * Mostra el submenú de gestió del magatzem i compres.
     * Aquest mètode permet:
     *  1. Ordenar l'alimentació per ordre de caducitat.
     *  2. Ordenar els productes tèxtils per composició.
     *  3. Cercar un producte per codi de barres.
     *  4. Tornar al menú principal.
     */
    public void mostrarSubmenuGestio() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;
        do {
            try {
                System.out.println("\n--- Gestió del Magatzem i Compres ---");
                System.out.println("1. Ordenar alimentació per ordre de caducitat");
                System.out.println("2. Ordenar productes tèxtils per composició");
                System.out.println("3. Cercar producte per codi de barres");
                System.out.println("0. Tornar al menú principal");
                System.out.print("Escull una opció: ");
                opcio = scanner.nextInt();
                scanner.nextLine(); // Neteja el buffer

                switch (opcio) {
                    case 1:
                        // Ordenem la llista d'alimentació per caducitat i la mostrem.
                        List<Alimentacio> alimentsOrdenats = controladorMagatzem.getMagatzem().ordenarPerCaducitat();
                        System.out.println("\n--- Alimentació ordenada per caducitat ---");
                        if (alimentsOrdenats.isEmpty()) {
                            System.out.println("No hi ha productes d'alimentació disponibles.");
                        } else {
                            for (Alimentacio a : alimentsOrdenats) {
                                System.out.println(a);
                            }
                        }
                        break;
                    case 2:
                        // Ordenem la llista de productes tèxtils per composició i la mostrem.
                        List<Textil> textilsOrdenats = controladorMagatzem.getMagatzem().ordenarPerComposicioTextil();
                        System.out.println("\n--- Productes tèxtils ordenats per composició ---");
                        if (textilsOrdenats.isEmpty()) {
                            System.out.println("No hi ha productes tèxtils disponibles.");
                        } else {
                            for (Textil t : textilsOrdenats) {
                                System.out.println(t);
                            }
                        }
                        break;
                    case 3:
                        // Demanem el codi de barres i cerquem el producte.
                        System.out.print("Introdueix el codi de barres del producte a cercar: ");
                        String codi = scanner.nextLine();
                        Producte producteTrob = controladorMagatzem.getMagatzem().getProductePerCodi(codi);
                        if (producteTrob != null) {
                            System.out.println("Producte trobat: " + producteTrob);
                        } else {
                            System.out.println("No s'ha trobat cap producte amb aquest codi de barres.");
                        }
                        break;
                    case 0:
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna-ho a intentar.");
                }
            } catch (Exception e) {
                System.out.println("Error en el submenú de gestió: " + e.getMessage());
                scanner.nextLine();
            }
        } while (opcio != 0);
    }
}
