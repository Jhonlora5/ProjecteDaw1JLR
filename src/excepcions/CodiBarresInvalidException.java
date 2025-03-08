package excepcions;

/**
 * Excepció llançada quan el codi de barres no té el format correcte.
 */
public class CodiBarresInvalidException extends Exception {
    public CodiBarresInvalidException(String codiBarres) {
        super("Error: El codi de barres " + codiBarres + " no és vàlid. Ha de contenir exactament 13 dígits numèrics.");
    }
}
