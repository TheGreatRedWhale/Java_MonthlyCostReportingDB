// IMPORTS_____________________________________________________________________
// import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The DBList class containing an inventory of InventoryItems.
 *
 * Project 11a
 * 
 * @author Jared Whaley
 * @version 11-20-2020
 */
public class DBList {

   // Instance variables (can be used within the class)
   private DB[] dbArray;
   private String[] invalidRecordArray;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "DBList" class.
    *     Accepts no parameters.
    */
   public DBList() {
      dbArray = new DB[0];
      invalidRecordArray = new String[0];
   }
   
   // METHODS__________________________________________________________________
   /**
    * Method for obtaining the object's internal array of databases.
    *
    * @return - Returns the object's internal array of databases.
    */
   public DB[] getDBArray() {
      return dbArray;
   }
   
   /**
    * Method for obtaining the object's internal array of failed imports.
    *
    * @return - Returns the object's internal array of failed imports.
    */
   public String[] getInvalidRecordsArray() {
      return invalidRecordArray;
   }
   
   /**
    * Increments the size of the dbArray and adds a DB object to it.
    *
    * @param dbIn - The DB object to be added to the dbArray.
    */
   public void addDB(DB dbIn) {
      DB[] newDBArray = new DB[dbArray.length + 1];
      for (int i = 0; i < dbArray.length; i++) {
         newDBArray[i] = dbArray[i];
      }
      newDBArray[newDBArray.length - 1] = dbIn;
      dbArray = newDBArray;
   }
   
   /**
    * Increments the size of the invalidRecordArray and adds an
    *     InvalidRecord object to it.
    *
    * @param invalidRecordIn - The InvalidRecord String to be added to the
    *     invalidRecordArray.
    */
   public void addInvalidRecord(String invalidRecordIn)
   {
      String[] newInvalidRecordArray =
         new String[invalidRecordArray.length + 1];
      for (int i = 0; i < invalidRecordArray.length; i++) {
         newInvalidRecordArray[i] = invalidRecordArray[i];
      }
      newInvalidRecordArray[newInvalidRecordArray.length - 1] =
         invalidRecordIn;
      invalidRecordArray = newInvalidRecordArray;
   }
   
   /**
    * Reads input in from a file and stores it within the dbArray.
    *
    * @param filepath - The filepath as a string of the file being read.
    * 
    * @throws FileNotFoundException - Thrown when the supplied filepath
    *     points to a non-existent file.
    */
   public void readFile(String filepath) throws FileNotFoundException {
      File fileIn = new File(filepath);
      Scanner fileReader = new Scanner(fileIn);
      String line;
      Scanner lineReader;
      String nameIn;
      double baseCostIn, dbStorageIn, costPerUserIn, licenseIn;
      int numberOfUsersIn;
         
      while (fileReader.hasNextLine()) {
         line = fileReader.nextLine(); 
         lineReader = new Scanner(line);
         lineReader.useDelimiter(",");
         char dbType = lineReader.next().charAt(0);
         try {
            switch(dbType) {
               case 'C':
                  nameIn = lineReader.next();
                  baseCostIn = Double.parseDouble(lineReader.next());
                  dbStorageIn = Double.parseDouble(lineReader.next());
                  licenseIn = Double.parseDouble(lineReader.next());
                  CentralizedDB newCDB = new CentralizedDB(
                     nameIn, baseCostIn,
                     dbStorageIn, licenseIn);
                  addDB(newCDB);
                  break;
               case 'D':
                  nameIn = lineReader.next();
                  baseCostIn = Double.parseDouble(lineReader.next());
                  dbStorageIn = Double.parseDouble(lineReader.next());
                  numberOfUsersIn = Integer.parseInt(lineReader.next());
                  costPerUserIn = Double.parseDouble(lineReader.next());
                  DistributedDB newDDB = new DistributedDB(nameIn,
                     baseCostIn, dbStorageIn,
                     numberOfUsersIn, costPerUserIn);
                  addDB(newDDB);
                  break;
               case 'H':
                  nameIn = lineReader.next();
                  baseCostIn = Double.parseDouble(lineReader.next());
                  dbStorageIn = Double.parseDouble(lineReader.next());
                  numberOfUsersIn = Integer.parseInt(lineReader.next());
                  costPerUserIn = Double.parseDouble(lineReader.next());
                  HomogeneousDB newHDB = new HomogeneousDB(nameIn,
                     baseCostIn, dbStorageIn,
                     numberOfUsersIn, costPerUserIn);
                  addDB(newHDB);
                  break;
               case 'E':
                  nameIn = lineReader.next();
                  baseCostIn = Double.parseDouble(lineReader.next());
                  dbStorageIn = Double.parseDouble(lineReader.next());
                  numberOfUsersIn = Integer.parseInt(lineReader.next());
                  costPerUserIn = Double.parseDouble(lineReader.next());
                  HeterogeneousDB newEDB = new HeterogeneousDB(nameIn,
                     baseCostIn, dbStorageIn,
                     numberOfUsersIn, costPerUserIn);
                  addDB(newEDB);
                  break;
               default:
                  throw new InvalidCategoryException(String.valueOf(dbType));
            }
         }
         
         catch (InvalidCategoryException e) {
            String output = line + "\n" + e.toString();
            addInvalidRecord(output);
         }
         
         catch (NumberFormatException e) {
            String output = line + "\n" + e.toString();
            addInvalidRecord(output);
         }
         
         catch (NoSuchElementException e) {
            String output = line + "\n" + e.toString()
               + ": For missing input data";
            addInvalidRecord(output);
         }
      }
   }
   
   /**
    * Processes the DB array using the original order from the file to
       *     produce the Monthly Database Report and then returns the report
       *     as String.
    *
    * @return - Returns the formatted output string.
    */
   public String generateReport() {
      String output = ""
         + "-------------------------------\n"
         + "Monthly Database Report\n"
         + "-------------------------------\n";
      // Arrays.sort(dbArray);
      for (int i = 0; i < dbArray.length; i++) {
         output += (dbArray[i].toString() + "\n\n");
      }
      return output;
   }
   
   /**
    * Processes the DB array using alphabetical order from the file to
       *     produce the Monthly Database Report and then returns the report
       *     as String.
    *
    * @return - Returns the formatted output string.
    */
   public String generateReportByName() {
      String output = ""
         + "-----------------------------------------\n"
         + "Monthly Database Report (by Name)\n"
         + "-----------------------------------------\n";
      Arrays.sort(dbArray);
      for (int i = 0; i < dbArray.length; i++) {
         output += (dbArray[i].toString() + "\n\n");
      }
      return output;
   }
   
   /**
    * Processes the DB array using alphabetical order from the file to
       *     produce the Monthly Database Report and then returns the report
       *     as String.
    *
    * @return - Returns the formatted output string.
    */
   public String generateReportByMonthlyCost() {
      String output = ""
         + "-------------------------------------------------\n"
         + "Monthly Database Report (by Monthly Cost)\n"
         + "-------------------------------------------------\n";
      Arrays.sort(dbArray, new MonthlyCostComparator());
      for (int i = 0; i < dbArray.length; i++) {
         output += (dbArray[i].toString() + "\n\n");
      }
      return output;
   }
   
   /**
    * Processes the Invalid Records Array using the original order from
    *     the file to produce the Invalid Records Report and then returns
    *     the report as a String.
    *
    * @return - Returns the formatted output string.
    */
   public String generateInvalidRecordsReport() {
      String output = ""
         + "----------------------\n"
         + "Invalid Records Report\n"
         + "----------------------\n";
      // Arrays.sort(dbArray);
      for (int i = 0; i < invalidRecordArray.length; i++) {
         output += (invalidRecordArray[i] + "\n\n");
      }
      return output;
   }
}