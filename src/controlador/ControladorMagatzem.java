package controlador;

import model.Magatzem;
import model.Producte;

import excepcions.ProducteDuplicatException;

import java.util.List;

/**
 * Controlador per gestionar el magatzem de productes
 * aquesta classe actua com a intermediari entre la vista i el model,
 * rebent peticions de la vista i cridant els mètodes del model per afegir o recuperar productes.
 */
public class ControladorMagatzem {
    //Instància de magatzem on es gestionen els productes
    private Magatzem magatzem;

    /**
     * Constructor del controlador del magatzem.
     * @param magatzem Instància de la classe Magatzem.
     */
    public ControladorMagatzem(Magatzem magatzem) {
        this.magatzem = magatzem;
    }

    public Magatzem getMagatzem() {
        return this.magatzem;
    }

    /**
     * Afegeix un producte al magatzem
     * Aquest metode crida al model per afegir el producte.
     * @param producte el producte a afegir
     * @throws ProducteDuplicatException si el producte ja existeix
     */
    public void afegirProducteAlMagatzem(Producte producte)
            throws ProducteDuplicatException {
        try {
            // Intentem afegir el producte al magatzem.
            magatzem.afegirProducte(producte);
            System.out.println("Producte afegit correctament al magatzem.");
        }catch(Exception e){
            // Captura qualsevol altra excepció inesperada.
            System.out.println("Error inesperat al afegir producte: " + e.getMessage());
        } finally {
            // Aquest bloc s'executa sempre, independentment de si hi ha error o no.
            System.out.println("Operació d'afegir producte al magatzem finalitzada.");
        }
    }

    /**
     * Mostra els productes del magatzem.
     * Aquest mètode crida al model per obtenir una llista amb tots els productes actuals.
     *
     * @return llista de productes al magatzem.
     */
    public List<Producte> mostrarMagatzem() {
        List<Producte> llista = null;
        try {
            // Sol·licitem al model que retorni tots els productes.
            llista = magatzem.getTotsElsProductes();
        }catch(Exception e){
            // Captura i mostra qualsevol error que pugui ocórrer durant aquesta operació.
            System.out.println("Error mostrant els productes del magatzem: " + e.getMessage());
        }finally{
            // Indica que l'operació de mostrar els productes ha finalitzat.
            System.out.println("Operació de mostrar magatzem finalitzada.");
        }
        return llista;
    }
}
