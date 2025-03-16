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
Aquesta opció es fa al desplegable del menu a VistaPrincipal, el submenu es crea mitjançant una funció anomenada mostrarSubmenuGesio a la classe VistaMagatzem.

1.1. Caducitat En escollir aquesta opció es llistarà els productes en funció de la seva data de caducitat (els més pròxims a caducar tindran més prioritat per ser processats primer en passar per caixa).
Al Magatzem tenim una funció anomenada ordenarPerCaducitat que s'encarrega de realitzar la consulta a la llista corresponent amb sort (Comparator.comparing)

1.2. Tiquets de compra En escollir aquesta opció guardarem un registre de les compres realitzades per poder-hi accedir més tard. Serà una estructura on afegirem nous tiquets de manera seqüencial.
El tiquet de compra es gestiona a ControladorCompra, amb una funció que recull els paràmetres pertinents, afegeix a l'historial, buida el carro i genera un arxiu on ficarà el preu i la data.

1.3. Composició tèxtil En escollir aquesta opció gestionarem els productes tèxtils per a ordenar-los per la seva composició tèxtil.  No podrem tenir dos productes amb el mateix codi de barres. Aquesta ordenació la farem servir també pels tèxtils del carret de la compra.
La funció es troba al Magatzem, on podem tovar ordenarPerComposicioTextil que s'encarregarà d'endreçar per la seva composició tèxtil amb sort (Comparator.comparing) 

1.0. Tornar En escollir aquesta opció s'ha de tornar al menú principal.
Si es clica 0 el bucle de mostrarSubmenuGestio s'atura i tornarà al menu principal.

Aquesta part la podem trobar a la VistaPrincipal--> i un subMenuGestió on es genera un submenu que permet les diverses accions a realitzar.

2. Introduïr producte En escollir aquesta opció s'ha de mostrar un altre menú d'opcions: Quin tipus de producte vols afegir?
Aquesta opció imprimeix una llista:

Aquesta part anterior no em quedava clara si era per afegir al carro o per afegir al magatzem, s'ha realitzat per INTRODUÏR al magatzem. 

2.1. Alimentació En escollir aquesta opció s'ha de demanar que s'entri per teclat les dades d'un producte del tipus Alimentació.
Alimentació: Demanarà el nom, preu, codi de barres, data de caducitat.

2.2. Tèxtil En escollir aquesta opció s'ha de demanar que s'entri per teclat les dades d'un producte del tipus Tèxtil.
Tèxtil: Demanarà nom, preu, codi de barres, composició.

2.3. Electrònica En escollir aquesta opció s'ha de demanar que s'entri per teclat les dades d'un producte del tipus Electrònica.
Electronica: Demanarà nom, preu, codi de barres, garantia.

2.0. Tornar En escollir aquesta opció s'ha de tornar al menú principal
Afegit un bucle on amb l'opció 0 es pot tornar al menu anterior.

3. Passar per caixa En escollir aquesta opció se simula que es passen tots els productes per caixa i es genera el tiquet.

El tiquet (es mostra per pantalla) ha de mostrar una capçalera amb: data de la compra i nom del supermercat. A continuació es mostra el detall amb: nom del producte, unitats introduïdes al carro, preu unitari i preu total. Finalment ha de calcular la suma total a pagar.

Si s'han introduït dos productes iguals (tenen el mateix codi de barres i el mateix preu unitari) només es mostrarà una vegada, amb la quantitat total d'aquell producte, és a dir, les unitats.

Aquesta opció també implica buidar el carro de la compra.

4. Mostrar carro de la compra En escollir aquesta opció es mostra un llistat amb la descripció i quantitat de cada producte (sense preu) que hi ha dins el carro del a compra. En aquest cas, si hi ha productes repetits ho seran si tenen el mateix codi de barres (no cal mirar el preu unitari).

Al introduïr el 4, es guarden les tres llistes, electronica, alimentació i tèxtil en una nova llista amb una funció que tenim a magatzem getTotsElsProductes, 
aquesta funció guarda tots els productes, es realitza un shuffle per barrejar tots els productes i s'agafen els 10 primers, per imprimir el tiquet corresponent, 
la crida es realitza des de VistaCarro. 

0.Sortir En escollir aquesta opció es tanca l'aplicació.

Des del cap de departament de informàtica, el cap de projecte ens demana els següents requeriments tècnics per a que el projecte quedi el màxim d’integrat possible amb altres projectes ja desplegats al client.
·         Cal realitzar el projecte en entorn Git, realitzant els commits necessaris que facilitin saber l’evolució del vostre projecte.
Accés al git hub:

https://github.com/Jhonlora5/ProjecteDaw1JLR.git

·         Configureu el .gitignore degudament
Contingut de gitignore:
/.idea/                
/.vscode/               
/out/                 
/bin/                   
/build/                 
/target/


/.gradle/               
/.mvn/                 
*.jar                   
*.war                   
*.class


historialTiquets.txt

·         Cal dissenyar un README.md que deixi clar les vostres justificacions i decisions que heu pres.

Crec que tinc gairebé tot explicat.

·         Cal declarar en tot moment els getters i setters de cada classe

A totes les classes? i si no es necessari en algunes? es solament fer clic dret i generar el getter i el setter...

·         Cal documentar tot el codi degudament

Crec que està tot el codi comentat.

·         Ens demanen treballar amb la Collection List, sabem que tant Stack com a Vector funcionen correctament per a processos multithreading però en principi no ens cal dins del nostre context, per tant valoreu, escolliu i justifiqueu quin dels altres dos casos faríeu servir i a on?

S'han realitzat diversos collection, compare, sort, shuffle...

·         Per a poder-lo integrar amb la impressió del carret de la compra d’altres aplicacions ja desplegades, ens demanen treballar amb la Collection Map, i ens diuen que serà necessari treballar amb mètodes propis com ara containsKey o containsValue (valoreu quin dels dos casos us serà necessari). El recorregut de les dades s’haurà de fer amb lambda expressions.

S'ha utilitzat per exemple per fer cerques de productes per codi de barres, on el codi de barres el la clau i tota la resta es el valor.

·         Cal implementar la interfície Comparable amb el seu corresponent mètode en una classe que considereu que només cal fer una ordenació natural, i per tant, ens cal també implementar en una altra classe la interfície Comparator amb el seu mètode corresponent definit per vosaltres i que ens permeti comparar objectes de diferent manera a l’estàndard.
El podria definir a alimentació per que amb un Collections.sort(llistaAlimentacio) endreça automaticament el contintugut per data de caducitat.
@Override
public int compareTo(Alimentacio altre) {
return this.dataCaducitat.compareTo(altre.dataCaducitat);
}

·         Pel que fa als productes Textils, no podrem tenir dos productes al carret de la compra amb el mateix codi de barres i a més s’haurà d’ordenar segons la seva composició.

a Magatzem tenim la funcio que ordena els texits demanat a Textil que una llista per el aquest paràmetre, llavors ca un comparator.comparing de la llista.

·         Ens demanen de forma més explícita una funció que cerqui el nom del producte pel codi de barres. Per a simplificar i millorar el nostre codi, farem servir streams combinat amb expressions lambda.

A VistaPrincipal s'utilitza la introducció del codi de barres per fer la cerca a la funció getcodibarres que tenim a Magatzem.

Sobre les Excepcions:

Excepcions Estàndards:

Feu servir tantes excepcions estàndards de Java com creieu oportú, però cal almenys que treballeu amb aquestes 3 excepcions estàndards:

InputMismatchException
la podem trobar a l'hora d'introduïr una dada amb l'escaner, si l'usuari introdueix un numero o no estableix res, sortirà per pantalla l'error corresponent.

Les dues següents s'han utilitzat per a la creació de l'arxiu que emmagatzema els tiquets de compra.

FileNotFoundException

IOException

Excepcions personalitzades:

A banda de les excepcions estàndards, caldrà també que definiu excepcions personalitzades.

Aquestes excepcions s'hauran de definir en un fitxer que contindrà únicament les excepcions definides per vosaltres i que heretaran de Exception

Les excepcions que heu de definir (si no feu aquestes, podeu escollir definir tantes com creieu convenient segons el vostre programa, però almenys heu de definir 5 de diferents):

LimitProductesException: Es llançarà quan es supera un límit de productes.

DataCaducitatException: Es llançarà quan hi ha un problema amb la data de caducitat.

NegatiuException: Es llançarà quan es detecta un valor negatiu.

LimitCaracteresException: Es llançarà quan un text supera el límit de caràcters permès.

EnumFailException: Es llançarà quan hi ha un error relacionat amb un Enum.

S'han creat 3 excepcions, però solament una s'utilitza al codi.




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