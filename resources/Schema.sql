CREATE TABLE hausverwaltungsfirma
       (name           VARCHAR(30) NOT NULL PRIMARY KEY);

CREATE TABLE mieter
       (mieter_nr      INTEGER NOT NULL PRIMARY KEY,
        nachname       VARCHAR(30) NOT NULL,
		    vorname        VARCHAR(30) NOT NULL,
        geschlecht     CHAR(1) NOT NULL CHECK (geschlecht in ('M', 'W')));
		
CREATE TABLE stadt
       (stadt_id       INTEGER NOT NULL PRIMARY KEY,
        plz            INTEGER NOT NULL ,
        name           VARCHAR(30) NOT NULL);
		
CREATE TABLE hausmeisterservice
       (name           VARCHAR(30) PRIMARY KEY,
		    stadt		   INTEGER,
		    FOREIGN KEY    (stadt) REFERENCES stadt ON DELETE SET NULL);
		
CREATE TABLE mietvertrag
       (vertrags_nr    INTEGER NOT NULL PRIMARY KEY,
        vertragsdauer  INTEGER NOT NULL ,
        erstellt_von   VARCHAR(30) NOT NULL ,
		    FOREIGN KEY    (erstellt_von) REFERENCES hausverwaltungsfirma ON DELETE SET NULL);
		
CREATE TABLE unterzeichnet
       (vertrags_nr    INTEGER NOT NULL REFERENCES mietvertrag ON DELETE SET NULL ,
        mieter_nr      INTEGER NOT NULL REFERENCES mieter ON DELETE SET NULL ,
        PRIMARY KEY    (vertrags_nr, mieter_nr));
		
CREATE TABLE objekt
       (objekt_nr      INTEGER NOT NULL PRIMARY KEY,
        strasse        VARCHAR(30) NOT NULL,
        hausnummer     VARCHAR(30) NOT NULL,
        stockwerk      INTEGER NOT NULL,
        stadt          INTEGER NOT NULL,
        FOREIGN KEY    (stadt) REFERENCES stadt ON DELETE SET NULL ,
        vermietet_durch VARCHAR(30),
        FOREIGN KEY    (vermietet_durch) REFERENCES hausverwaltungsfirma ON DELETE SET NULL);
		
CREATE TABLE beziehtsichauf
       (vertrags_nr    INTEGER NOT NULL REFERENCES mietvertrag ON DELETE SET NULL ,
        objekt_nr      INTEGER NOT NULL REFERENCES objekt ON DELETE SET NULL ,
        PRIMARY KEY    (vertrags_nr, objekt_nr));
		
CREATE TABLE mietet
       (mieter_nr    INTEGER NOT NULL REFERENCES mieter ON DELETE SET NULL ,
        objekt_nr      INTEGER NOT NULL REFERENCES objekt ON DELETE SET NULL ,
        PRIMARY KEY    (mieter_nr, objekt_nr));

CREATE TABLE auftrag
       (auftrags_nr    INTEGER NOT NULL PRIMARY KEY,
        erteilt_von    VARCHAR(30) NOT NULL ,
		    FOREIGN KEY    (erteilt_von) REFERENCES hausverwaltungsfirma ON DELETE SET NULL ,
        erteilt_an     VARCHAR(30),
        FOREIGN KEY    (erteilt_an) REFERENCES hausmeisterservice ON DELETE SET NULL );
		
CREATE TABLE enthaelt
       (auftrags_nr    INTEGER NOT NULL REFERENCES auftrag ON DELETE SET NULL ,
        objekt_nr      INTEGER NOT NULL REFERENCES objekt ON DELETE SET NULL ,
        PRIMARY KEY    (auftrags_nr, objekt_nr));