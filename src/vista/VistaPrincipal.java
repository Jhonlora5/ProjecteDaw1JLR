package vista;

import controlador.ControladorCarret;
import controlador.ControladorMagatzem;
import controlador.ControladorCompra;

import model.Alimentacio;
import model.Electronica;
import model.Producte;
import model.Textil;
import model.Magatzem;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal de la vista que mostra el menú d'opcions.
 * Aquesta classe és l'element d'interacció amb l'usuari que rep les peticions
 * i la transmet als respectius controladors (pont entre la vista i model).
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
     * Mostra tot el que conté el magatzem.
     */
    private void mostrarMenuGestio() {
        try {
            // Crida al submenú de gestió implementat a VistaMagatzem.
            new VistaMagatzem(controladorMagatzem).mostrarSubmenuGestio();
        } catch (Exception e) {
            System.out.println("Error en el menú de gestió: " + e.getMessage());
        }
    }

    /**
     * Mostra el menú per introduir productes
     */
    private void mostrarMenuIntroduirProducte() {
        try {
            System.out.println("\n--- Introduir Producte ---");
            System.out.println("Tria el tipus de producte a afegir:");
            System.out.println("1. Alimentació");
            System.out.println("2. Tèxtil");
            System.out.println("3. Electrònica");
            System.out.print("Opció: ");
            int tipus = scanner.nextInt();
            scanner.nextLine(); // Neteja el buffer

            switch (tipus) {
                case 1:
                    // Llegim dades per a un producte d'alimentació
                    System.out.print("Introdueix el nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Introdueix el preu: ");
                    double preu = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Introdueix el codi de barres: ");
                    String codi = scanner.nextLine();
                    System.out.print("Introdueix la data de caducitat (YYYY-MM-DD): ");
                    String dataStr = scanner.nextLine();
                    LocalDate dataCad = LocalDate.parse(dataStr);
                    Alimentacio aliment = new Alimentacio(nom, preu, codi, dataCad);
                    controladorMagatzem.afegirProducteAlMagatzem(aliment);
                    System.out.println("Producte d'alimentació afegit correctament.");
                    break;
                case 2:
                    // Llegim dades per a un producte tèxtil
                    System.out.print("Introdueix el nom: ");
                    nom = scanner.nextLine();
                    System.out.print("Introdueix el preu: ");
                    preu = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Introdueix el codi de barres: ");
                    codi = scanner.nextLine();
                    System.out.print("Introdueix la composició tèxtil: ");
                    String composicio = scanner.nextLine();
                    Textil textil = new Textil(nom, preu, codi, composicio);
                    controladorMagatzem.afegirProducteAlMagatzem(textil);
                    System.out.println("Producte tèxtil afegit correctament.");
                    break;
                case 3:
                    // Llegim dades per a un producte electrònic
                    System.out.print("Introdueix el nom: ");
                    nom = scanner.nextLine();
                    System.out.print("Introdueix el preu: ");
                    preu = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Introdueix el codi de barres: ");
                    codi = scanner.nextLine();
                    System.out.print("Introdueix els dies de garantia: ");
                    int diesGarantia = scanner.nextInt();
                    scanner.nextLine();
                    Electronica electr = new Electronica(nom, preu, codi, diesGarantia);
                    controladorMagatzem.afegirProducteAlMagatzem(electr);
                    System.out.println("Producte electrònic afegit correctament.");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } catch (Exception e) {
            System.out.println("Error en introduir el producte: " + e.getMessage());
            scanner.nextLine(); // Neteja el buffer en cas d'error
        }
    }

    /**
     * Mostra el contingut del carro de la compra
     */
    private void mostrarCarroCompra() {
        try {
            // Crida la vista del carret i mostra el seu contingut
            new VistaCarret(controladorCarret).mostrarCarroCompraAleatori();
        } catch (Exception e) {
            System.out.println("Error en mostrar el carro de la compra: " + e.getMessage());

        }
    }
}
