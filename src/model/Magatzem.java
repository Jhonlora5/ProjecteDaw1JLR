package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Classe per gestionar el magatzem
 */
public class Magatzem {
    private static final int MAX_PRODUCTES = 100;
    private static final int MAX_PER_TIPUS = 33;

    private List<Alimentacio> alimentacioList;
    private List<Textil> textilList;
    private List<Electronica> electronicaList;

    public Magatzem() {
        this.alimentacioList = new ArrayList<>();
        this.textilList = new ArrayList<>();
        this.electronicaList = new ArrayList<>();
    }

    /**
     * Afegeix un producte al magatzem si no se supera el màxim permès
     */
    public boolean afegirProducte(Producte producte) {
        int total = alimentacioList.size() + textilList.size() + electronicaList.size();

        if (total >= MAX_PRODUCTES) {
            System.out.println("Error: Magatzem ple. No es poden afegir més productes.");
            return false;
        }

        if (producte instanceof Alimentacio) {
            if (alimentacioList.size() < MAX_PER_TIPUS) {
                alimentacioList.add((Alimentacio) producte);
            } else {
                System.out.println("Error: Màxim de productes d'alimentació assolit.");
                return false;
            }
        } else if (producte instanceof Textil) {
            if (textilList.size() < MAX_PER_TIPUS) {
                textilList.add((Textil) producte);
            } else {
                System.out.println("Error: Màxim de productes tèxtils assolit.");
                return false;
            }
        } else if (producte instanceof Electronica) {
            if (electronicaList.size() < MAX_PER_TIPUS) {
                electronicaList.add((Electronica) producte);
            } else {
                System.out.println("Error: Màxim de productes electrònics assolit.");
                return false;
            }
        } else {
            System.out.println("Error: Tipus de producte desconegut.");
            return false;
        }

        return true;
    }

    /**
     * Retorna un producte a partir del seu codi de barres
     */
    public Producte getProductePerCodi(String codiBarres) {
        for (Producte p : alimentacioList) {
            if (p.getCodiBarres().equals(codiBarres)) return p;
        }
        for (Producte p : textilList) {
            if (p.getCodiBarres().equals(codiBarres)) return p;
        }
        for (Producte p : electronicaList) {
            if (p.getCodiBarres().equals(codiBarres)) return p;
        }
        return null; // No s'ha trobat cap producte amb aquest codi de barres
    }

    /**
     * Retorna tots els productes del magatzem
     */
    public List<Producte> getTotsElsProductes() {
        List<Producte> totsElsProductes = new ArrayList<>();
        totsElsProductes.addAll(alimentacioList);
        totsElsProductes.addAll(textilList);
        totsElsProductes.addAll(electronicaList);
        return totsElsProductes;
    }

    /**
     * Ordena la llista d'aliments per data de caducitat (els més pròxims primer)
     */
    public List<Alimentacio> ordenarPerCaducitat() {
        alimentacioList.sort(Comparator.comparing(Alimentacio::getDataCaducitat));
        return alimentacioList;
    }

    /**
     * Ordena la llista de tèxtils per composició
     */
    public List<Textil> ordenarPerComposicioTextil() {
        textilList.sort(Comparator.comparing(Textil::getComposicioTextil));
        return textilList;
    }

    public void inicialitzarProductes() {
        // Afegim 33 productes d'alimentació
        afegirProducte(new Alimentacio("Pa", 1.50, "1111111111111", LocalDate.of(2025, 3, 10)));
        afegirProducte(new Alimentacio("Llet", 0.90, "1111111111112", LocalDate.of(2025, 3, 15)));
        afegirProducte(new Alimentacio("Formatge", 3.50, "1111111111113", LocalDate.of(2025, 3, 12)));
        afegirProducte(new Alimentacio("Pasta", 2.00, "1111111111114", LocalDate.of(2025, 6, 1)));
        afegirProducte(new Alimentacio("Iogurt", 1.00, "1111111111115", LocalDate.of(2025, 3, 20)));
        afegirProducte(new Alimentacio("Carn", 5.50, "1111111111116", LocalDate.of(2025, 4, 5)));
        afegirProducte(new Alimentacio("Peix", 7.30, "1111111111117", LocalDate.of(2025, 3, 18)));
        afegirProducte(new Alimentacio("Arròs", 1.80, "1111111111118", LocalDate.of(2025, 8, 30)));
        afegirProducte(new Alimentacio("Galetes", 2.20, "1111111111119", LocalDate.of(2025, 7, 14)));
        afegirProducte(new Alimentacio("Cereals", 3.00, "1111111111120", LocalDate.of(2025, 9, 5)));
        afegirProducte(new Alimentacio("Ous", 2.50, "1111111111121", LocalDate.of(2025, 3, 25)));
        afegirProducte(new Alimentacio("Mantega", 4.00, "1111111111122", LocalDate.of(2025, 5, 10)));
        afegirProducte(new Alimentacio("Oli", 6.20, "1111111111123", LocalDate.of(2026, 1, 1)));
        afegirProducte(new Alimentacio("Mel", 8.00, "1111111111124", LocalDate.of(2026, 12, 15)));
        afegirProducte(new Alimentacio("Xocolata", 3.40, "1111111111125", LocalDate.of(2025, 11, 20)));
        afegirProducte(new Alimentacio("Tomàquet", 1.90, "1111111111126", LocalDate.of(2025, 3, 28)));
        afegirProducte(new Alimentacio("Llimona", 2.10, "1111111111127", LocalDate.of(2025, 4, 1)));
        afegirProducte(new Alimentacio("Poma", 1.80, "1111111111128", LocalDate.of(2025, 4, 2)));
        afegirProducte(new Alimentacio("Plàtan", 2.30, "1111111111129", LocalDate.of(2025, 3, 30)));
        afegirProducte(new Alimentacio("Taronja", 1.60, "1111111111130", LocalDate.of(2025, 4, 3)));
        afegirProducte(new Alimentacio("Fruits Secs", 4.50, "1111111111131", LocalDate.of(2026, 2, 10)));
        afegirProducte(new Alimentacio("Cafè", 5.20, "1111111111132", LocalDate.of(2026, 3, 15)));
        afegirProducte(new Alimentacio("Te", 3.90, "1111111111133", LocalDate.of(2026, 1, 25)));

        // Afegim 33 productes de tèxtil
        afegirProducte(new Textil("Samarreta", 12.99, "2222222222221", "Cotó 100%"));
        afegirProducte(new Textil("Pantalons", 29.99, "2222222222222", "Denim"));
        afegirProducte(new Textil("Jaqueta", 49.99, "2222222222223", "Llana"));
        afegirProducte(new Textil("Bufanda", 15.99, "2222222222224", "Acrílic"));
        afegirProducte(new Textil("Mitjons", 5.99, "2222222222225", "Cotó i Polièster"));
        afegirProducte(new Textil("Barret", 10.99, "2222222222226", "Lli"));
        afegirProducte(new Textil("Guants", 19.99, "2222222222227", "Cuero sintètic"));
        afegirProducte(new Textil("Vestit", 59.99, "2222222222228", "Seda"));
        afegirProducte(new Textil("Faldilla", 34.99, "2222222222229", "Lli i Cotó"));
        afegirProducte(new Textil("Banyador", 24.99, "2222222222230", "Nylon"));
        afegirProducte(new Textil("Bossa", 39.99, "2222222222231", "Cuero"));

        // Afegim 33 productes d'electrònica
        afegirProducte(new Electronica("Mòbil", 299.99, "3333333333331", 365));
        afegirProducte(new Electronica("Portàtil", 899.99, "3333333333332", 730));
        afegirProducte(new Electronica("Auriculars", 49.99, "3333333333333", 180));
        afegirProducte(new Electronica("Smartwatch", 199.99, "3333333333334", 365));
        afegirProducte(new Electronica("Càmera", 499.99, "3333333333335", 730));
        afegirProducte(new Electronica("Consola", 399.99, "3333333333336", 365));
        afegirProducte(new Electronica("Televisor", 999.99, "3333333333337", 1095));
        afegirProducte(new Electronica("Tablet", 599.99, "3333333333338", 730));
    }
}
