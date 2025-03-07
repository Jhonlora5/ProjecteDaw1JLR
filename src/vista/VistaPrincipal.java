package vista;

import controlador.ControladorCarret;
import controlador.ControladorMagatzem;
import controlador.ControladorCompra;
import model.Producte;

import java.util.Scanner;

/**
 * Classe principal de la vista que mostra el menú d'opcions
 */
public class VistaPrincipal {
    private ControladorCarret controladorCarret;
    private ControladorMagatzem controladorMagatzem;
    private ControladorCompra controladorCompra;
    private Scanner scanner;

    public VistaPrincipal(ControladorCarret controladorCarret, ControladorMagatzem controladorMagatzem, ControladorCompra controladorCompra) {
        this.controladorCarret = controladorCarret;
        this.controladorMagatzem = controladorMagatzem;
        this.controladorCompra = controladorCompra;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Mostra el menú principal
     */
    public void mostrarMenu() {
        int opcio;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestió Magatzem i Compres");
            System.out.println("2. Introduir producte");
            System.out.println("3. Passar per caixa");
            System.out.println("4. Mostrar carro de la compra");
            System.out.println("0. Sortir");
            System.out.print("Escull una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine(); // Neteja el buffer

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
        } while (opcio != 0);
    }

    /**
     * Mostra el menú de gestió del magatzem i compres
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
