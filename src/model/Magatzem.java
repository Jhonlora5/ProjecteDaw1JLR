package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Classe per gestionar el magatzem
 */
public class Magatzem {
    private List<Producte> productes;

    public Magatzem() {
        this.productes = new ArrayList<>();
    }

    public void afegirProducte(Producte producte) {
        productes.add(producte);
    }

    public List<Producte> ordenarPerCaducitat() {
        productes.sort(Comparator.comparing(p -> {
            if (p instanceof Alimentacio) {
                return ((Alimentacio) p).getDataCaducitat();
            }
            return null;
        }, Comparator.nullsLast(Comparator.naturalOrder())));
        return productes;
    }

    public List<Producte> ordenarPerComposicioTextil() {
        productes.sort(Comparator.comparing(p -> {
            if (p instanceof Textil) {
                return ((Textil) p).getComposicioTextil();
            }
            return "";
        }));
        return productes;
    }
}
