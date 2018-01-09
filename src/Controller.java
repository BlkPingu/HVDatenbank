import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tobias on 06.01.18.
 */
public class Controller{

    public final Scanner scanner = new Scanner(System.in);
    private DBNav dbNav =  new DBNav();
    String table = "mietvertrag";
    String primaryKey = "vertrags_nr";
    int current = 1;



    public void run() throws SQLException{
        while(true){
            printInfo();
            System.out.print("Geben Sie eine Zahl ein: ");

            int task = scanner.nextInt();
            switch (task) {
                case 1:
                    //Ausgabe
                    //String table2 = scanner.next();
                    dbNav.printTable(table);
                    break;
                case 2:
                    //Neuer Datensatz
                    System.out.print("Vertragsnummer: ");
                    int vertrags_nr = scanner.nextInt();

                    System.out.print("Vertragsdauer: ");
                    int vertragsdauer = scanner.nextInt();

                    System.out.print("Erstellt von Firma: ");
                    String erstellt_von = scanner.next();

                    dbNav.createSet(table,vertrags_nr,vertragsdauer,erstellt_von);
                    break;
                case 3:
                    //Loeschen Datensatz
                    System.out.print("VertragsNr: ");
                    int key = scanner.nextInt();

                    dbNav.deleteSet(table,primaryKey,key);
                    break;
                case 4:
                    //Navigieren
                	 String db_url = "jdbc:postgresql://db.f4.htw-berlin.de:5432/_s0549272__hausverwaltung";
                	 String username = "s0549272";
                	 String password = "8.b.gSS1";
                	 Connection dbcon = null;
                	 Statement stmt = null;
                    boolean exit = true;
                   try{
                    dbcon = DriverManager.getConnection(db_url, username, password);
                    stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
                    int i = 0;
                    List<String> vertrags_nrList = new ArrayList<String>();
                    List<String> vertragsdauerList = new ArrayList<String>();
                    List<String> erstelltVonList = new ArrayList<String>();
                   
                    while(rs.next()){
                    	vertrags_nrList.add(rs.getString(1));
                    	vertragsdauerList.add(rs.getString(2));
                    	erstelltVonList.add(rs.getString(3));
                    	i++;
                    }
                    int max = i;
                    
                    i=0;
                    System.out.println("Row " + i + ": Nr: " + vertrags_nrList.get(i) + 
                    		" Dauer: " + vertragsdauerList.get(i) + " Erstellt von: " + erstelltVonList.get(i));
                    System.out.println("Press N(next) / P(previous) /Q(quit)");                    
                    while(exit) {
                    	                    	
                        String np = scanner.next();
                        
                        
	                        if (np.equals("n") || np.equals("N")) {
	                        	System.out.println(max);
	                        	if(i<max)
	                        		i++;
	                        	if(i==max)
	                        		i=0;
	                        	System.out.println("Row " + i + ": Nr: " + vertrags_nrList.get(i) + 
	                            		" Dauer: " + vertragsdauerList.get(i) + " Erstellt von: " 
	                        			+ erstelltVonList.get(i));
	                        }
	                        if (np.equals("p") || np.equals("P")) {
	                  
	                        	if(i>0)
	                        		i--;
	                        	else if(i==0)
	                        		i=max-1;
	                        	
	                        	System.out.println("Row " + i + ": Nr: " + vertrags_nrList.get(i) + 
	                            		" Dauer: " + vertragsdauerList.get(i) + " Erstellt von: " 
	                        			+ erstelltVonList.get(i));
	                    	                        }
	                        if (np.equals("q") || np.equals("Q")) {
	                            exit = false;
	                        }
	                    }
                    
                    
                    
                   }
                   catch (SQLException e) {
                       e.printStackTrace();
                   } finally {
                       if (stmt != null) {
                           stmt.close();
                       }
                       if (dbcon != null) {
                           dbcon.close();
                       }
                   }

                   /*
                    boolean exit = true;
                    System.out.println("Press N(next) / P(previous) /Q(quit)");

                    while(exit) {


                        String np = scanner.next();

                        if (np.equals("n") || np.equals("N")) {
                            current = dbNav.navTable(table, true, false, current);
                        }
                        if (np.equals("p") || np.equals("P")) {
                            current = dbNav.navTable(table, false, true, current);

                        }
                        if (np.equals("q") || np.equals("Q")) {
                            exit = false;
                        }
                    }*/

                    break;
                case 5:
                    //Rollback
                    System.out.print("Rollback initiiert... ");
                    dbNav.rollback();
                    System.out.println("Rollback abgeschlossen. ");

                default:
                    break;
            } //END switchcase
        } // END WHILE
    }//END RUN()

    private void printInfo() {
        System.out.println(
                "Was willst du tun? \n" +
                "(1) Tabelle Ausgabe \n" +
                "(2) Eingabe neuer Datensaetze \n" +
                "(3) Loeschen von Datensaetzen \n" +
                "(4) Navigieren durch Tabelle \n" +
                "(5) Rollback auf Vanilla"
        );
    }



}
