
import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Tobias on 06.01.18.
 */
public class DBNav{


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


            ArrayList<Integer> vertragsnummern= new ArrayList<>();
            ArrayList<String> firmen = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
                while (rs.next()) {
                    vertragsnummern.add(rs.getInt("vertrags_nr"));
                }


            ResultSet rs2 = stmt.executeQuery("SELECT * FROM hausverwaltungsfirma");
                while(rs2.next()){
                    firmen.add(rs2.getString("name"));
                }


                if (!firmen.contains(erstellt_von)||vertragsnummern.contains(vertrags_nr)) {
                    if (!firmen.contains(erstellt_von)) {
                        System.out.println("Firma nicht vorhanden: " + erstellt_von);
                    }
                    if (vertragsnummern.contains(vertrags_nr)) {
                        System.out.println("Vertragsnummer schon vorhanden: " + vertrags_nr);
                    }
                }else stmt.execute("INSERT INTO " + table + " VALUES ('" + vertrags_nr + "','" + vertragsdauer + "','" + erstellt_von + "')");

        } catch (SQLException e){
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




/*
    public void createSet(String table, int vertrags_nr, int vertragsdauer, String erstellt_von) throws SQLException {
        try {
            ArrayList<Integer> vertragsnummern= new ArrayList<>();
            dbcon = DriverManager.getConnection(db_url, username, password);

            stmt = dbcon.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            while(rs.next()) {
                int vertrags_nummer = rs.getInt("vertrags_nr");
                vertragsnummern.add(vertrags_nummer);
            }

            if (vertragsnummern.contains(vertrags_nr)){
                System.out.println("Vertragsnummer schon vorhanden: "+ vertrags_nr);
            }else stmt.execute("INSERT INTO "+table+" VALUES ('"+ vertrags_nr+"','"+vertragsdauer+"','"+erstellt_von+"')");

        } catch (SQLException e){
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

    */

    /*public int navTable(String table, boolean nPressed, boolean pPressed, int current) throws SQLException {
        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumCount = rsmd.getColumnCount();


            System.out.println("Current: "+current);
            System.out.println("Lines:   "+totalColumCount);

            for(int i=1; i<= totalColumCount;i++) {
                System.out.println(rs.getInt("vertrags_nr") + "\t" + rs.getInt("vertragsdauer") + "\t" + rs.getString("erstellt_von"));
            }

            if (nPressed) {
                System.out.println("<");
                rs.next();
                current++;
            }
            if (pPressed) {
                System.out.println("<");

                rs.previous();
                current--;
            }




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
        return current;
    }*/

    public int navTable(String table, boolean nPressed, boolean pPressed, int current) throws SQLException {
        try {
            dbcon = DriverManager.getConnection(db_url, username, password);
            stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            rs.last();
            int last = rs.getRow();
            rs.first();
            int first = rs.getRow();


            if (nPressed) {
                for(int i=first; i<current; i++){
                    rs.next();
                }

                System.out.println(rs.getInt("vertrags_nr") + "\t" + rs.getInt("vertragsdauer") + "\t" + rs.getString("erstellt_von"));
                current++;
                if(last < current){
                    current = first;
                }

            }
            if (pPressed) {
                for(int i=first; i<current; i++){
                    rs.next();
                }

                System.out.println(rs.getInt("vertrags_nr") + "\t" + rs.getInt("vertragsdauer") + "\t" + rs.getString("erstellt_von"));
                current--;
                if(first > current){
                    current = last;
                }

            }


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
        return current;
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

    public void deleteSet(String table,String primaryKey, int vertrags_nr) throws SQLException {

        try {
            ArrayList<Integer> vertragsnummern= new ArrayList<>();
            dbcon = DriverManager.getConnection(db_url, username, password);

            stmt = dbcon.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            while(rs.next()) {
                int vertrags_nummer = rs.getInt("vertrags_nr");
                vertragsnummern.add(vertrags_nummer);
            }

            //System.out.println("Vorhandene Vertragsnummern: " +vertragsnummern.toString());
            //System.out.println("Vertragsnummer: " + vertrags_nr + " vorhanden? - "+ vertragsnummern.contains(vertrags_nr));



            if(vertragsnummern.contains(vertrags_nr)){
                stmt.execute("DELETE FROM "+ table + " WHERE "+ primaryKey+ " = " + "'"+vertrags_nr+"'");
                System.out.println("Vertragsnummer geloescht.");
                System.lineSeparator();
            }

            if (!vertragsnummern.contains(vertrags_nr)){
                System.out.println("Vertragsnummer nicht vorhanden: "+ vertrags_nr);
            }


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
