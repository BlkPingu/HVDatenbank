import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Tobias on 06.01.18.
 */
public class Controller{

    public final Scanner scanner = new Scanner(System.in);
    private DBNav dbNav =  new DBNav();
    String table = "mietvertrag";
    String primaryKey = "vertrags_nr";



    public void run() throws SQLException{
        while(true){
            printInfo();
            int task = scanner.nextInt();
            switch (task) {
                case 1:
                    //Ausgabe
                    //String table2 = scanner.next();
                    dbNav.printTable(table);
                    break;
                case 2:
                    int vertrags_nr = scanner.nextInt();
                    int vertragsdauer = scanner.nextInt();
                    String erstellt_von = scanner.next();
                    dbNav.createSet(table,vertrags_nr,vertragsdauer,erstellt_von);
                    break;
                case 3:
                    //Neuer Datensatz
                    String key = scanner.next();
                    dbNav.deleteSet("'"+key+"'",table,primaryKey);
                    break;
                case 4:
                    //Navigieren
                    break;
                case 5:
                    dbNav.rollback();
                    default:
                    break;
            } //END switchcase
        } // END WHILE
    }//END RUN()

    private void printInfo() {
        System.out.println("Willkommen in der Matrix \n" +
                "Was willst du tun? \n" +
                "(1) Tabelle Ausgabe \n" +
                "(2) Eingabe neuer Datensaetze \n" +
                "(3) Loeschen von Datensaetzen \n" +
                "(4) Navigieren durch Tabelle \n" +
                "(5) Rollback auf Vanilla"
        );
    }



}
