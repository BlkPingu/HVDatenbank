import java.sql.*;

/**
 * Created by Tobias on 06.01.18.
 */
public class DBNav {


    public String db_url = "jdbc:postgresql://db.f4.htw-berlin.de:5432/_s0549272__hausverwaltung";
    public String username = "s0549272";
    public String password = "8.b.gSS1";
    public Connection dbcon = null;
    public Statement stmt = null;


    public void rollback() throws SQLException{
        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement();

            stmt.execute("TRUNCATE mieter, hausverwaltungsfirma, stadt, hausmeisterservice, mietvertrag, unterzeichnet, objekt, beziehtsichauf, mietet, auftrag, enthaelt;");
            stmt.execute("INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma1');\n" +
                    "INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma2');\n" +
                    "INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma3');\n" +
                    "INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma4');\n" +
                    "INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma5');\n" +
                    "INSERT INTO hausverwaltungsfirma(name) \n" +
                    "VALUES ('firma6');\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (1, 'lustig', 'peter', 'M');\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (2, 'lustiger', 'michelle', 'W');\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (3, 'dunkel', 'hans', 'M');\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (4, 'hell', 'frida', 'W');\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (5, 'kleber', 'klaus', 'M');\n" +
                    "INSERT INTO mieter(mieter_nr, nachname, vorname, geschlecht) \n" +
                    "VALUES (6, 'france', 'julian', 'M');\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO stadt(stadt_id, plz, name) \n" +
                    "VALUES (1, 12483, 'berlin');\n" +
                    "INSERT INTO stadt(stadt_id, plz, name) \n" +
                    "VALUES (2, 80808, 'hamburg');\n" +
                    "INSERT INTO stadt(stadt_id, plz, name) \n" +
                    "VALUES (3, 80777, 'wolfsburg');\n" +
                    "INSERT INTO stadt(stadt_id, plz, name) \n" +
                    "VALUES (4, 87654, 'paris');\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO hausmeisterservice(name, stadt) \n" +
                    "VALUES ('der beste', 1);\n" +
                    "INSERT INTO hausmeisterservice(name, stadt) \n" +
                    "VALUES ('der nicht so gute', 2);\n" +
                    "INSERT INTO hausmeisterservice(name, stadt) \n" +
                    "VALUES ('alleskoenner', 3);\n" +
                    "INSERT INTO hausmeisterservice(name, stadt) \n" +
                    "VALUES ('franzosenhausmeister', 4);\n" +
                    "\n" +
                    "INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) \n" +
                    "VALUES (1, 0, 'firma3');\n" +
                    "INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) \n" +
                    "VALUES (2, 3, 'firma2');\n" +
                    "INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) \n" +
                    "VALUES (3, 0, 'firma4');\n" +
                    "INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) \n" +
                    "VALUES (4, 0, 'firma2');\n" +
                    "INSERT INTO mietvertrag(vertrags_nr, vertragsdauer, erstellt_von) \n" +
                    "VALUES (5, 9, 'firma6');\n" +
                    "\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (1, 2);\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (2, 1);\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (3, 4);\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (3, 3);\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (4, 5);\n" +
                    "INSERT INTO unterzeichnet (vertrags_nr, mieter_nr) \n" +
                    "VALUES (5, 6);\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) \n" +
                    "VALUES (1, 'strasse', 1, 1,1, 'firma3' );\n" +
                    "INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) \n" +
                    "VALUES (2, 'kurze strasse', 6, 3,2, 'firma2' );\n" +
                    "INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) \n" +
                    "VALUES (3, 'wolfsburger str', 11, 2, 3, 'firma4' );\n" +
                    "INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) \n" +
                    "VALUES (4, 'klausstr', 16, 0,2, 'firma2' );\n" +
                    "INSERT INTO objekt (objekt_nr, strasse, hausnummer, stockwerk, stadt, vermietet_durch) \n" +
                    "VALUES (5, 'belvue', 7, 17,4, 'firma6' );\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) \n" +
                    "VALUES (1, 1);\n" +
                    "INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) \n" +
                    "VALUES (2, 2);\n" +
                    "INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) \n" +
                    "VALUES (3, 3);\n" +
                    "INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr) \n" +
                    "VALUES (4, 4);\n" +
                    "INSERT INTO beziehtsichauf (vertrags_nr, objekt_nr)\n" +
                    "VALUES (5, 5);\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (1, 2);\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (2, 1);\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (3, 3);\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (4, 3);\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (5, 4);\n" +
                    "INSERT INTO mietet(mieter_nr, objekt_nr) \n" +
                    "VALUES (6, 5);\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) \n" +
                    "VALUES (1, 'firma3', 'der beste');\n" +
                    "INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) \n" +
                    "VALUES (2, 'firma2', 'der nicht so gute');\n" +
                    "INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) \n" +
                    "VALUES (3, 'firma4', 'alleskoenner');\n" +
                    "INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) \n" +
                    "VALUES (4, 'firma2', 'der nicht so gute');\n" +
                    "INSERT INTO auftrag(auftrags_nr, erteilt_von, erteilt_an) \n" +
                    "VALUES (5, 'firma6', 'franzosenhausmeister');\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO enthaelt(auftrags_nr, objekt_nr) \n" +
                    "VALUES (1, 1);\n" +
                    "INSERT INTO enthaelt(auftrags_nr, objekt_nr) \n" +
                    "VALUES (2, 2);\n" +
                    "INSERT INTO enthaelt(auftrags_nr, objekt_nr) \n" +
                    "VALUES (3, 3);\n" +
                    "INSERT INTO enthaelt(auftrags_nr, objekt_nr) \n" +
                    "VALUES (4, 4);\n" +
                    "INSERT INTO enthaelt(auftrags_nr, objekt_nr) \n" +
                    "VALUES (5, 5);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (dbcon != null) {
                dbcon.close();
            }
        }

    }

    public void createSet(String table, int vertrags_nr, int vertragsdauer, String erstellt_von) throws SQLException {
        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement();

            stmt.execute("INSERT INTO "+table+" VALUES ('"+ vertrags_nr+"','"+vertragsdauer+"','"+erstellt_von+"')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (dbcon != null) {
                dbcon.close();
            }
        }
    }

    public void deleteSet(String table) throws SQLException {
        try {
            Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            stmt = dbcon.createStatement();

            boolean isLast = rs.isLast();
            boolean isFirst = rs.isFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (dbcon != null) {
                dbcon.close();
            }
        }
    }



    public void printTable(String table) throws SQLException {

        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement();

            ResultSet rs = stmt.executeQuery("select * from "+ table);
            DBTablePrinter.printResultSet(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (dbcon != null) {
                dbcon.close();
            }
        }
    }

    public void navTable(String table) throws SQLException {

        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement();

            //ResultSet rs = stmt.executeQuery("select * from "+ table);
            //DBTablePrinter.printResultSet(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (dbcon != null) {
                dbcon.close();
            }
        }
    }
}
