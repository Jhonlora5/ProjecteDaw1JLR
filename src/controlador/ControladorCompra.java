package controlador;

import model.CarretCompra;
import model.TiquetCompra;
import model.Producte;
import model.Magatzem;

import java.util.List;
import java.util.Map;
/**
 * Controlador per gestionar les compres i la generació de tiquets.
 * Aquesta classe s'encarrega de finalitzar la copra, calcular el total,
 * generar un tiquet amb els productes del carret, afegir-lo a l'historial
 * i buidar el carret. Actua com a intermediari entre la vista i el model.
 */
public class ControladorCompra {
    private CarretCompra carret; // El carret de la compra
    private List<TiquetCompra> historialTiquets; // Historial dels tiquets generats.
    private Magatzem magatzem; //El magatzem on es troben els productes.

    /**
     * Constructor del carret de la compra.
     * @param carret Instancia de CarretCompra.
     * @param historialTiquets Llista d'historial de tiquets.
     */
    public ControladorCompra(CarretCompra carret, List<TiquetCompra> historialTiquets, Magatzem magatzem) {
        this.carret = carret;
        this.historialTiquets = historialTiquets;
        this.magatzem = magatzem;
    }

    /**
     * Finalitza la compra i genera un tiquet utilitzant el magatzem ja definit.
     * Aquest mètode crida el mètode amb parametre passant-hi l'objecte magatzem.
     *
     * @return tiquet de la copra generat.
     */
    public TiquetCompra passarPerCaixa(){
        return passarPerCaixa(this.magatzem);
    }

    /**
     * Finalitza la compra i genera un tiquet.
     * Aquest metode recorre tots els productes del carret
     * (Representts per un Map de codi de barres i quantitat),
     * calcula el total de la compra multiplicant el preu de cada
     * producte per la seva quantitat (recuperart des del magatzem),
     * crea un tiquet de compra amb els productes i el total.
     * @param magatzem magatzem on es troben els productes
     * @return el tiquet de compra generat
     */
    public TiquetCompra passarPerCaixa(Magatzem magatzem) {
        double total = 0.0;
        try {
            // Iterem sobre el mapa de productes del carret.
            for (Map.Entry<String, Integer> entry : carret.getProductes().entrySet()) { // Canviat carretCompra per carret
                String codiBarres = entry.getKey();
                int quantitat = entry.getValue();

                // Busquem el producte al magatzem
                Producte producte = magatzem.getProductePerCodi(codiBarres);

                if (producte != null) {
                    total += producte.getPreu() * quantitat;
                }
            }
        } catch (Exception e) {
            // Captura qualsevol error que es produeixi i mostra un missatge amb el detall.
            System.out.println("Error al passar per caixa: " + e.getMessage());
        }finally{
            // Aquest bloc s'executa sempre, però ja no buidem el carret perquè ho gestionarem per separat
            System.out.println("Finalitzada operació de passar per caixa.");
        }
        // Creem el tiquet amb el total calculat
        TiquetCompra tiquet = new TiquetCompra(carret.getProductes(), total);
        //Afegim a l'historial de tiquets.
        historialTiquets.add(tiquet);
        // Buidem el carro.
        carret.buidarCarret();
        return tiquet;

    }
}