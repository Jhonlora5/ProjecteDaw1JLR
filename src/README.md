Exercicis Acabats:

La multinacional SAPAMERCAT us demana que li dissenyeu una aplicació revolucionaria! Consisteix en fer que el carro de la compra mostri, en temps real, el preu dels productes que s'hi van introduint.

L'empresa us indica que l'aplicació, de moment, només ha de permetre gestionar les dades d'uns quants dels seus productes: alimentació, tèxtil i electrònica. Aquests productes tenen unes característiques comuns (preu, nom i codi de barres) i un conjunt de característiques específiques de cada tipus de producte:

Alimentació: data de caducitat.

El preu d'aquest tipus de producte varia en funció dels dies que falten per caducar, segons la fórmula:

             preu - preu*(1/(dataCaducitat-dataActual+1)) + (preu * 0.1)

Tèxtil: composició tèxtil (text)

Electrònica: dies de garantia (numèric)

El preu d'aquest tipus de producte varia en funció dels dies que té de garantia segons la fórmula:

preu + preu*(diesGarantia/365)*0.1

Llavors l'estructura creada serà:

Model:

Classe privades
Producte: variables :Nom(String), Preu(double), codiBarres(String).
|
|-> Alimentació: variables: dataCaducitat(Localdate)
|       Funció calcularPreu que fara el calcul revisant la data de caducitat del producte.
|
|
|-> Tèxtil: variables: composicioTextil(String)
|       Funció calcularPreu retorna preu de l'article.
|
|
|-> Electronica: variables: diesGarantia(int)
|       Funció calcularPreu retorna preu de l'article calculat per dies de garantía.

On tenim que la classe principal serà Producte. 
Alimentació, Tèxtil i Electronica són extensions de la classe Productes.

Aquestes, són les encarregades de gestionar cada una de les llistes de productes.

L'aplicació que heu de fer ha de permetre gestionar tots els productes que s'hi van introduint (màxim 100 productes) i calcular-ne el preu.
Aquesta part la tenim al Magatzem (Model), on mitjançant dues variables (No pot superar la suma total de 100 productes i un màxim de 33 articles per cada producte, per tant, com a màxim sempre serà 99, no 100) 

També ha de permetre que, en passar per caixa, es generi el tiquet de compra i es buidi el carro.
passarPerCaixa és una funció que es troba a ControladorCompra.
buidarCarro és una funció que es troba a CarretCompra.

Fer un programa principal que faci ús de les classes dissenyades. La descripció del que ha de fer aquest programa s'explica a continuació. El programa ha de tenir un menú d'opcions com el següent:

1. Gestió Magatzem i Compres Consultes dels productes que trobem al magatzem i consulta de l'historial de tiquets de compra.
Aquesta opció es fa al desplegable del menu a VistaPrincipal.

1.1. Caducitat En escollir aquesta opció es llistarà els productes en funció de la seva data de caducitat (els més pròxims a caducar tindran més prioritat per ser processats primer en passar per caixa).
Al Magatzem tenim una funció anomenada ordenarPerCaducitat que s'encarrega de realitzar la consulta a la llista corresponent amb sort (Comparator.comparing)

1.2. Tiquets de compra En escollir aquesta opció guardarem un registre de les compres realitzades per poder-hi accedir més tard. Serà una estructura on afegirem nous tiquets de manera seqüencial.
El tiquet de compra es gestiona a ControladorCompra, amb una funció que recull els paràmetres pertinents, afegeix a l'historial, buida el carro i genera un arxiu on ficarà el preu i la data.

1.3. Composició tèxtil En escollir aquesta opció gestionarem els productes tèxtils per a ordenar-los per la seva composició tèxtil.  No podrem tenir dos productes amb el mateix codi de barres. Aquesta ordenació la farem servir també pels tèxtils del carret de la compra.
La funció es troba al Magatzem, on podem tovar ordenarPerComposicioTextil que s'encarregarà d'endreçar per la seva composició textil amb sort (Comparator.comparing) 

1.0. Tornar En escollir aquesta opció s'ha de tornar al menú principal.


Aquesta part la podem trobar a la VistaPrincipal--> i un subMenuGestió on es genera un submenu que permet les diverses accions a realitzar.



ESTRUCTURA TOTAL:
Controlador:

Controlador Carret
Classe publica ControladorCarret:
variables:
private CarretCompra carret
private Magatzem magatzem

            Funcions/Constructors:
            Encarregades de mostrar, esborrar, afegir al carret.

ControladorCompra
Classe publica ControladorCompra:
variables:
private CarretCompra carret
private Magatzem magatzem
private List<TiquetCompra> = historialCompra:(Encarregat de guardar la llista de tiquets generats)

            Funcions:
            Encarregada de generar el tiquet amb els productes corresponents i la suma total.
            Funció encarregada de guardar l'historial de tiquets a un fitxer i recuperar-lo per mostrar-lo a VistaCompra.

ControladorMagatzem
Classe publica ControladorMagatzem:
variables:
private Magatzem magatzem

        Funcions/Constructors:
        Encarregada d'afegir si escau productes al magatzem.
            Afegit un trow amb una excepció pròpia per si el producte ja està introduït.

Main
Classe encarregada de l'execució del programa.


Model:
Classe privades
Producte: variables :Nom(String), Preu(double), codiBarres(String).
|
|-> Alimentació: variables: dataCaducitat(Localdate)
|       Funció calcularPreu que fara el calcul revisant la data de caducitat del producte.
|
|
|-> Tèxtil: variables: composicioTextil(String)
|       Funció calcularPreu retorna preu de l'article.
|
|
|-> Electronica: variables: diesGarantia(int)
|       Funció calcularPreu retorna preu de l'article calculat per dies de garantía.


TiquetCompra: dataCompra(LocalDate), productes(HashMap), total(double).

CarretCompra: productes(HashMap).
Funció afegirProducte encarregat d'afegir el producte al nostre carret.
Funció buidaCarret encarregada de buidar tot el carro.
Funció obtenirProductes retorna una llista de productes per el seu codi de barres.

Magatzem: MAX_PRODUCTES(int), MAX_PER_TIPUS(int), alimentacioList(list), textilList(list),electronicaList(list).
Funció afegirProducte encarregada de revisar si el producte existeix,
si supera els 100 articles, endreçar per els diferents ordres, i funció per afegir productes al arrencar el programa.

vista:
VistaPrincipal:
Aquesta vista conté el menú corresponent a l'inici del programa en mode case.

VistaMagatzem:
Aquesta vista s'encarrega de visualitzar el magatzem dels productes per mostrar-los.

VistaCompra:
Aquesta vista mostra un menu per tal de comprar els diferents tipus de materials.

VistaCarret:
Aquesta vista mostra els articles, introduïts al carret amb el total.