package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Classe per gestionar el magatzem.
 *
 * Aquesta classe controla que el límit de productes sigui 100 (No arribarà mai),
 * i a més que cada una de les classes de producte sigui 33 (Llavors els maxim serà sempre 99).
 */
public class Magatzem {
    // Límit total de productes a magatzem.
    private static final int MAX_PRODUCTES = 100;
    // Límit total de productes per tipus.
    private static final int MAX_PER_TIPUS = 33;
    //Llistes separades de cada tipus de producte.
    private List<Alimentacio> alimentacioList;
    private List<Textil> textilList;
    private List<Electronica> electronicaList;

    /**
     * Constructor del Magatzem.
     * Inizialitza les llistes.
     */
    public Magatzem() {
        this.alimentacioList = new ArrayList<>();
        this.textilList = new ArrayList<>();
        this.electronicaList = new ArrayList<>();
    }

    /**
     * Afegeix un producte al magatzem si no és supera el límit global ni el tipus.
     * @param producte el producte del que es vol entrar.
     * @return
     */
    public boolean afegirProducte(Producte producte) {
        try {
            // Calcular el total de productes que tenim al magatzem.
            int total = alimentacioList.size() + textilList.size() + electronicaList.size();

            if (total >= MAX_PRODUCTES) {
                System.out.println("Error: Magatzem ple. No es poden afegir més productes.");
                return false;
            }
            //Afegim el producte segons el seu tipus, verificant el límit del tipus amb el .size. en els diferents tipus.
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
        }catch(Exception e){
            //Captura qualsevol error inesperat durant l'afegiment.
            System.out.println("Error en afegir producte: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Retorna un producte a partir del seu codi de barres.
     *
     * Repasem les llistes dels diferents productes per tal de revisar aquells que coincideixen amb el codi.
     * @param codiBarres objecte clau de la classe pare Producte.
     * @return retorna el producte trobat, en el cas contrari retorna null.
     */
    public Producte getProductePerCodi(String codiBarres) {
        try {
            for (Producte p : alimentacioList) {
                if (p.getCodiBarres().equals(codiBarres)) return p;
            }
            for (Producte p : textilList) {
                if (p.getCodiBarres().equals(codiBarres)) return p;
            }
            for (Producte p : electronicaList) {
                if (p.getCodiBarres().equals(codiBarres)) return p;
            }
        }catch (Exception e){
            System.out.println("Error en recuperar producte per codi: " + e.getMessage());
        }
        // Si no s'ha trobat cap producte amb aquest codi de barres
        return null;
    }

    /**
     * Retorna tots els productes del magatzem.
     *
     * @return una llista de tots els productes introduits al magatzem.
     */
    public List<Producte> getTotsElsProductes() {
        List<Producte> totsElsProductes = new ArrayList<>();
        try {
            totsElsProductes.addAll(alimentacioList);
            totsElsProductes.addAll(textilList);
            totsElsProductes.addAll(electronicaList);
        }catch(Exception e){
            System.out.println("Error en obtenir tots els productes a la classe Magatzem: " + e.getMessage());
        }
        return totsElsProductes;
    }

    /**
     * Ordena la llista d'aliments per data de caducitat (els més pròxims primer)
     *
     * @return els productes d'alimentació per ordre.
     */
    public List<Alimentacio> ordenarPerCaducitat() {
        try {
            alimentacioList.sort(Comparator.comparing(Alimentacio::getDataCaducitat));
        }catch(Exception e){
            System.out.println("Error en ordenar per caducitat a la classe Magatzem: " + e.getMessage());
        }
        return alimentacioList;
    }

    /**
     * Ordena la llista de tèxtils per composició.
     *
     * @return els productes textils per ordre.
     */
    public List<Textil> ordenarPerComposicioTextil() {
        try {
            textilList.sort(Comparator.comparing(Textil::getComposicioTextil));
        }catch (Exception e){
            System.out.println("Error al ordenar els productes textils a la classe Magatzem: " + e.getMessage());
        }
        return textilList;
    }
    //Afegim uns quants productes.
    public void inicialitzarProductes() {
        try {
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
        }catch (Exception e){
            // Captura qualsevol error que es produeixi durant la inicialització dels productes
            System.out.println("Error en inicialitzar productes: " + e.getMessage());
        }finally{
            // Aquest bloc s'executa sempre després de la inicialització
            System.out.println("Finalitzada la inicialització de productes al magatzem.");
        }
    }
}
