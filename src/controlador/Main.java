package controlador;

import model.CarretCompra;
import model.Magatzem;
import model.TiquetCompra;
import model.Producte;

import vista.VistaCarret;
import vista.VistaPrincipal;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal per executar l'aplicació.
 * Aquesta classe actua com a punt d'entrada, inicialitzant els components del model,
 * els controladors i la vista, i finalment llançant el menu principal de la interfície d'usuari.
 */
public class Main {
    public static void main(String[] args) {
        try {
            //Creem una instància de Magatzem i el nou carretcompra.
            Magatzem magatzem = new Magatzem();
            // Cridem a la classe encarregada d'afegir productes.
            magatzem.inicialitzarProductes();

            //Creem una instància del carret de la compra.
            CarretCompra carret = new CarretCompra();

            // Creem una llista per emmagatzemar els tiquets de compra generats.
            List<TiquetCompra> historialTiquets = new ArrayList<>();

            // Inicialitzem els controladors amb les instàncies corresponents
            // El ControladorCarret gestiona el carret de la compra.
            ControladorCarret controladorCarret = new ControladorCarret(carret, magatzem);

            // El ControladorMagatzem gestiona els productes del magatzem.
            ControladorMagatzem controladorMagatzem = new ControladorMagatzem(magatzem);
            // El ControladorCompra s'encarrega de finalitzar la compra i generar tiquets.
            ControladorCompra controladorCompra = new ControladorCompra(carret, historialTiquets, magatzem);

            // Inicialitzem la vista principal, passant-li els controladors creats.
            VistaPrincipal vista = new VistaPrincipal(controladorCarret, controladorMagatzem, controladorCompra);
            // Mostrem el menu principal. A partir d'aquí, la vista s'encarrega de la interacció amb l'usuari.
            vista.mostrarMenu();

        }catch(Exception e) {
            // Captura qualsevol error que es produeixi durant la inicialització de l'aplicació.
            System.out.println("S'ha produït un error al mètode main: " + e.getMessage());
        }
    }
}
