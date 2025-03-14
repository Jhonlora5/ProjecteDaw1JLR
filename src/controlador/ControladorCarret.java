package controlador;

import model.CarretCompra;
import model.Producte;
import model.Magatzem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controlador per gestionar el carret de la compra.
 * Aquesta classe actua com a intermediari entre la vista i el model
 * gestionant la lògica per afegir productes al carret, mostrar-ne el contingut i buidar-lo.
 */
public class ControladorCarret {
    private CarretCompra carret;
    private Magatzem magatzem; //Instància del magatzem per recuperar els productes reals

    /**
     * Constructor del controlador del carret.
     * @param carret instància del carret de la compra.
     */
    public ControladorCarret(CarretCompra carret, Magatzem magatzem) {
        this.carret = carret;
        this.magatzem = magatzem;
    }

    public Magatzem getMagatzem() {
        return this.magatzem;
    }

    /**
     * Afegeix un producte al carret.
     * Aquest mètode valida que el producte no sigui null i que la quantitat sigui major que 0.
     * @param producte el producte a afegir
     * @param quantitat quantitat del producte
     */
    public void afegirProducteAlCarret(Producte producte, int quantitat) {
        try {
            // Validem els paràmetres d'entrada que no estiguin buits.
            if (producte == null) {
                throw new IllegalArgumentException("El producte no pot ser null.");
            }
            // Revisem que la quantitat no sigui inferior o igual a 0.
            if (quantitat <= 0) {
                throw new IllegalArgumentException("La quantitat ha de ser major que 0.");
            }
            // Si tot va bé afegim el producte al carret.
            carret.afegirProducte(producte, quantitat);
            System.out.println("Producte afegit correctament al carret.");
        } catch (Exception e) {
            // Captura i mostra qualsevol error que sorgeixi.
            System.out.println("Error afegint producte al carret: " + e.getMessage());
        } finally {
            // Aquest bloc s'executa SEMPRE, independentment si hi ha error o no.
            System.out.println("Operació afegir producte finalitzada.");
        }
    }

    /**
     * Retorna la llista de productes que hi ha al carret.
     * Es converteix el MAp de codis de barres i quantitats en una llista d'objectes Producte.
     * Si algun producte no es troba al magatzem, es llença una excepció.
     * Mostra el contingut del carret
     * @return llista de productes al carret
     */
    public List<Producte> mostrarCarret() {
        List<Producte> llistaProductes = new ArrayList<>();
        Map<String, Integer> productes = carret.getProductes();

        try {
            // Iterem sobre cada codi de barres del Map.
            for (String codiBarres : productes.keySet()) {
                // Recuperem el producte real a partir del codi de barres.
                Producte producte = magatzem.getProductePerCodi(codiBarres);
                if (producte != null) {
                    llistaProductes.add(producte);
                } else {
                    // Si no es troba, llençem una excepció. Aquí podríem utilitzar ProducteNoTrobatException si la tinguéssim.
                    throw new Exception("Producte amb codi de barres " + codiBarres + " no trobat al magatzem.");
                }
            }
        } catch (Exception e) {
            // Captura qualsevol error durant la conversió i mostra el missatge.
            System.out.println("Error mostrant el carret: " + e.getMessage());
        } finally {
            // Finalment, es pot registrar que s'ha finalitzat l'operació.
            System.out.println("Operació mostrar carret finalitzada.");
        }
        return llistaProductes;
    }

    /**
     * Buida el carret de la compra
     */
    public void buidarCarret() {
        try {
            carret.buidarCarret();
            System.out.println("El carret s'ha buidat correctament.");
        } catch (Exception e) {
            System.out.println("Error buidant el carret: " + e.getMessage());
        } finally {
            System.out.println("Operació buidar carret finalitzada.");
        }
    }
}
