package vista;

import controlador.ControladorCarret;
import controlador.ControladorMagatzem;
import controlador.ControladorCompra;
import model.Producte;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal de la vista que mostra el menú d'opcions.
 * Aquesta classe és l'element d'interacció amb l'usuari que rep les peticions
 * i la transmet als respectius controladors(pont entre la vista i model).
 */
public class VistaPrincipal {
    private ControladorCarret controladorCarret;
    private ControladorMagatzem controladorMagatzem;
    private ControladorCompra controladorCompra;
    private Scanner scanner;

    /**
     * Constructor de la classe VistaPrincipal.
     * @param controladorCarret Instancia de ControladorCarret.
     * @param controladorMagatzem Instancia de ControladorMagatzem
     * @param controladorCompra Instància de ControladorCompra
     */
    public VistaPrincipal(ControladorCarret controladorCarret, ControladorMagatzem controladorMagatzem, ControladorCompra controladorCompra) {
        //Controlador per gestionar el carret de la compra.
        this.controladorCarret = controladorCarret;
        //Controlador per gestionar el magatzem.
        this.controladorMagatzem = controladorMagatzem;
        //Controlador per gestionar les compres i generar els tiquets.
        this.controladorCompra = controladorCompra;
        //Scanner per llegir l'entrada de l'usuari des de la consola.
        this.scanner = new Scanner(System.in);
    }

    /**
     * Mostra el menú principal de l'aplicació.
     * Aquest mètode presenta diverses opcions a l'usuari mitjançant un case,
     * amb les diferents opcions e invoca al mètode corresponent.
     */
    public void mostrarMenu() {
        int opcio = -1;
        do {
            try {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Gestió Magatzem i Compres");
                System.out.println("2. Introduir producte");
                System.out.println("3. Passar per caixa");
                System.out.println("4. Mostrar carro de la compra");
                System.out.println("0. Sortir");
                System.out.print("Escull una opció: ");
                // Llegim l'opció de l'usuari, si no és un número, es capturarà amb InputMismatchException.
                opcio = scanner.nextInt();
                // Neteja el buffer
                scanner.nextLine();
                //Segons la opcio triada, es crida el mètode corresponent.
                switch (opcio) {
                    case 1:
                        mostrarMenuGestio();
                        break;
                    case 2:
                        mostrarMenuIntroduirProducte();
                        break;
                    case 3:
                        controladorCompra.passarPerCaixa();
                        break;
                    case 4:
                        mostrarCarroCompra();
                        break;
                    case 0:
                        System.out.println("Sortint de l'aplicació...");
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna-ho a intentar.");
                }
            }catch (InputMismatchException e){
                // Captura errors de format en la lectura (per exemple, si l'usuari no introdueix un número).
                System.out.println("Error: Has d'introduir un número vàlid. " + e.getMessage());
                // Neteja l'entrada errònia
                scanner.nextLine();
            }
            //Continuem el bucle fins que l'opció sigui 0.
        } while (opcio != 0);
    }

    /**
     * Mostra el menú de gestió del magatzem i compres.
     * Actualment mostra un missatge informatiu fins la implementació de les opcions a mostrar.
     */
    private void mostrarMenuGestio() {
        System.out.println("(Gestió del magatzem i compres - Opcions no implementades encara)");
    }

    /**
     * Mostra el menú per introduir productes
     */
    private void mostrarMenuIntroduirProducte() {
        System.out.println("(Introducció de productes - Opcions no implementades encara)");
    }

    /**
     * Mostra el contingut del carro de la compra
     */
    private void mostrarCarroCompra() {
        System.out.println("(Mostrar carro de la compra - Opcions no implementades encara)");
    }
}
