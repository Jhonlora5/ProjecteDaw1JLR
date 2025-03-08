package excepcions;

/**
 * Excepció llançada quan es vol afegir un producte duplicat (mateix codi de barres).
 */
public class ProducteDuplicatException extends Exception {
    public ProducteDuplicatException(String codiBarres) {
        super("Error: El producte amb codi de barres " + codiBarres + " ja existeix al magatzem.");
    }
}
