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
                    }
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
