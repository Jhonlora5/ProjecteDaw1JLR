package excepcions;

/**
 * Excepció llançada quan es busca un producte que no existeix al magatzem.
 */
public class ProducteNoTrobatException extends Exception {
    public ProducteNoTrobatException(String codiBarres) {
        super("Error: No s'ha trobat cap producte amb el codi de barres " + codiBarres + ".");
    }
}
