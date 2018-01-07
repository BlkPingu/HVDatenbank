/*5 a)*/

MINUS-OPERATOR = "EXCEPT"

SELECT name
FROM hausverwaltungsfirma
EXCEPT
SELECT vermietet_durch
FROM objekt;

/*Hier werden alle Firmen angezeigt die kein Objekt vermieten.
------------------------------------------------------------------------------*/

/*VEREINIGUNGSMENGE = "UNION"*/

SELECT name
FROM stadt
UNION
SELECT name 
FROM hausmeisterservice;

/*Hier werden alle Städtenamen und Hausmeisterservicenamen angezeigt.
------------------------------------------------------------------------------

SCHNITTMENGE = "INTERSECT"*/

SELECT erteilt_von
FROM auftrag
INTERSECT
SELECT name 
FROM hausverwaltungsfirma; 

/*Zeigt alle Firmennamen an die einem Hausmeisterservice einen Auftrag erteilt haben.


5 b)

Karthesisches Produkt 1:*/

SELECT hs.name as HS_Firmennamen, st.name as Stadt, st.plz
FROM hausmeisterservice hs, stadt st
WHERE hs.stadt =  st.stadt_id;

/*Hier wird das karthesische Produkt aus tabellen "hausmeisterservice"
und "stadt" gebildet. 
Angezeigt wird in welcher Stadt sich der Hausmeisterservice befindet.

"AS": Gibt der Spalte einen Alias in der Ergebnisausgabe


Karthesisches Produkt 2:*/

SELECT DISTINCT obj.vermietet_durch AS firma, st.name
FROM stadt st, objekt obj
WHERE obj.stadt = st.stadt_id;

/*Hier wird das karthesische Produkt aus tabellen "objekt"
und "stadt" gebildet.

Hier wird angezeigt welche Firma in welcher Stadt Objekte vermietet.

"DISTINCT": Sorgt dafür dass Duplikate im Ergebnis nur einmal angezeigt werden -> Falls
eine Firma in einer Stadt 2 Objekte hat => Nur ein Ergebnis. 


ALTERNATIV: */
SELECT * 
FROM Hausverwaltungsfirma, stadt;
SELECT * 
FROM auftrag, mieter;


/*5 c)*/

SELECT * FROM objekt
WHERE vermietet_durch IN ('firma 2', 'firma 3');

/*Zeigt alle Infos der Objekte die durch firma 2 und firma 3 vermietet werden.
------------------------------------------------------------------------------*/
SELECT mieter.vorname, mieter.nachname FROM mieter
WHERE geschlecht NOT IN ('M');

/*Zeigt Namen aller weiblichen Mieter.

5 d)*/

SELECT COUNT(objekt_nr) AS anzahl_der_objekte, obj.vermietet_durch
FROM objekt obj
GROUP BY obj.vermietet_durch;

/*Zeigt an wieviele Objekte jeweils von einer Firma vermietet werden.

------------------------------------------------------------------------------*/

SELECT MAX(obj.stockwerk) AS hoechstes_stockwerk, obj.vermietet_durch
FROM objekt obj
GROUP BY obj.vermietet_durch;

/*Hier wird das höchste Stockwerk angezeigt in dem eine Wohnung einer Firma vermietet wird.

5 e)*/

SELECT COUNT(objekt_nr) AS anzahl_der_objekte, obj.vermietet_durch
FROM objekt obj
GROUP BY obj.vermietet_durch
HAVING COUNT(objekt_nr) > 1;

/*
Zeigt alle Firmen an die mehr als ein Objekt vermieten und die Anzahl ihrer Objekte.
*/
