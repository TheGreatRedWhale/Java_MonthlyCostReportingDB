// IMPORTS_____________________________________________________________________
import java.io.FileNotFoundException;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The DB Driver class containing the main method.
 *
 * Project 11z
 * 
 * @author Jared Whaley
 * @version 11-20-2020
 */
public class DBPart3 {
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "DBPart3" class.
    *     Accepts no parameters, and is effectively empty.
    *     Only exists for testing purposes
    */
   public DBPart3() { }
   
   // MAIN METHOD______________________________________________________________
   /**
    * Main Method of our DB class and subclasses.
    *     Creates a number of Databases.
    *
    * @param args - Unused/Unmodified.
    * 
    * @throws FileNotFoundException - Thrown when the supplied filepath
    *     points to a non-existent file.
    */
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println(""
            + "File name expected as command line argument.\n"
            + "Program ending.");
      } else {
         try {
            DBList dbList = new DBList();
            dbList.readFile(args[0]);
            System.out.print(dbList.generateReport());
            System.out.print(dbList.generateReportByName());
            System.out.print(dbList.generateReportByMonthlyCost());
            System.out.print(dbList.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e) {
            String output = ("*** Attempted to read file: " + args[0]
               + " (No such file or directory)\n");
            System.out.print(output);
         }
      }
   }
}