package controlador;

import model.CarretCompra;
import model.Magatzem;
import model.TiquetCompra;

import vista.VistaPrincipal;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal per executar l'aplicació
 */
public class Main {
    public static void main(String[] args) {
        Magatzem magatzem = new Magatzem();
        magatzem.inicialitzarProductes(); //Cridem a la classe encarregada d'afegir productes.
        CarretCompra carret = new CarretCompra();
        List<TiquetCompra> historialTiquets = new ArrayList<>();

        ControladorCarret controladorCarret = new ControladorCarret(carret);
        ControladorMagatzem controladorMagatzem = new ControladorMagatzem(magatzem);
        ControladorCompra controladorCompra = new ControladorCompra(carret, historialTiquets);

        VistaPrincipal vista = new VistaPrincipal(controladorCarret, controladorMagatzem, controladorCompra);
        vista.mostrarMenu();
    }
}
