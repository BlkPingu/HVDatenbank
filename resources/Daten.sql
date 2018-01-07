INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma1');
INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma2');
INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma3');
INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma4');
INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma5');
INSERT INTO hausverwaltungsfirma(name) 
VALUES ('firma6');


INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (1, 'lustig', 'peter', 'M');
INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (2, 'lustiger', 'michelle', 'W');
INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (3, 'dunkel', 'hans', 'M');
INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (4, 'hell', 'frida', 'W');
INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (5, 'kleber', 'klaus', 'M');
INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) 
VALUES (6, 'france', 'julian', 'M');


INSERT INTO stadt(stadt_id, plz, name) 
VALUES (1, 12483, 'berlin');
INSERT INTO stadt(stadt_id, plz, name) 
VALUES (2, 80808, 'hamburg');
INSERT INTO stadt(stadt_id, plz, name) 
VALUES (3, 80777, 'wolfsburg');
INSERT INTO stadt(stadt_id, plz, name) 
VALUES (4, 87654, 'paris');


INSERT INTO hausmeisterservice(name, stadt) 
VALUES ('der beste', 1);
INSERT INTO hausmeisterservice(name, stadt) 
VALUES ('der nicht so gute', 2);
INSERT INTO hausmeisterservice(name, stadt) 
VALUES ('alleskoenner', 3);
INSERT INTO hausmeisterservice(name, stadt) 
VALUES ('franzosenhausmeister', 4);

INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) 
VALUES (1, 0, 'firma3');
INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) 
VALUES (2, 3, 'firma2');
INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) 
VALUES (3, 0, 'firma4');
INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) 
VALUES (4, 0, 'firma2');
INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) 
VALUES (5, 9, 'firma6');

INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (1, 2);
INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (2, 1);
INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (3, 4);
INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (3, 3);
INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (4, 5);
INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) 
VALUES (5, 6);


INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) 
VALUES (1, 'strasse', 1, 1,1, 'firma3' );
INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) 
VALUES (2, 'kurze strasse', 6, 3,2, 'firma2' );
INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) 
VALUES (3, 'wolfsburger str', 11, 2, 3, 'firma4' );
INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) 
VALUES (4, 'klausstr', 16, 0,2, 'firma2' );
INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) 
VALUES (5, 'belvue', 7, 17,4, 'firma6' );


INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) 
VALUES (1, 1);
INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) 
VALUES (2, 2);
INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) 
VALUES (3, 3);
INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) 
VALUES (4, 4);
INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr)
VALUES (5, 5);


INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (1, 2);
INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (2, 1);
INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (3, 3);
INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (4, 3);
INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (5, 4);
INSERT INTO mietet(mieter_nr, objekt_nr) 
VALUES (6, 5);


INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) 
VALUES (1, 'firma3', 'der beste');
INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) 
VALUES (2, 'firma2', 'der nicht so gute');
INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) 
VALUES (3, 'firma4', 'alleskoenner');
INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) 
VALUES (4, 'firma2', 'der nicht so gute');
INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) 
VALUES (5, 'firma6', 'franzosenhausmeister');


INSERT INTO enthaelt(auftrags_nr, objekt_nr) 
VALUES (1, 1);
INSERT INTO enthaelt(auftrags_nr, objekt_nr) 
VALUES (2, 2);
INSERT INTO enthaelt(auftrags_nr, objekt_nr) 
VALUES (3, 3);
INSERT INTO enthaelt(auftrags_nr, objekt_nr) 
VALUES (4, 4);
INSERT INTO enthaelt(auftrags_nr, objekt_nr) 
VALUES (5, 5);
