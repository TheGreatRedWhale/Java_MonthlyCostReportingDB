// IMPORTS_____________________________________________________________________
import java.text.DecimalFormat;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The abstract class outline for Databases (DB).
 *
 * Project 9a
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public abstract class DB implements Comparable<DB> {

   // Instance variables (can be used within the class)
   protected String name = "";
   protected double baseCost = 0.0;
   protected double dbStorage = 0.0;
   
   // Class variables
   protected static int count = 0;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "DB" class.
    *
    * @param nameIn - Supplied name of the DB.
    * @param baseCostIn - Supplied baseCost of the DB.
    * @param dbStorageIn - Supplied storage capacity in TB of the DB.
    */
   public DB(String nameIn, double baseCostIn, double dbStorageIn) {
      name = nameIn;
      baseCost = baseCostIn;
      dbStorage = dbStorageIn;
      count++;
   }

   // METHODS__________________________________________________________________
   /**
    * Method used to get the name when it is required outside of the object.
    *
    * @return - Returns the name of the DB;
    */
   public String getName() {
      return name;
   }
    
   /**
    * Method used to set the DB name.
    *
    * @param nameIn - The supplied name of the DB.
    */
   public void setName(String nameIn) {
      name = nameIn;
   }
    
   /**
    * Method used to get the baseCost when it is required outside of the object.
    *
    * @return - Returns the baseCost of the DB;
    */
   public double getBaseCost() {
      return baseCost;
   }
    
   /**
    * Method used to set the DB baseCost.
    *
    * @param baseCostIn - The supplied baseCost.
    */
   public void setBaseCost(double baseCostIn) {
      baseCost = baseCostIn;
   }
    
   /**
    * Method used to get the dbStorage when it is
    *     required outside of the object.
    *
    * @return - Returns the dbStorage of the DB;
    */
   public double getDbStorage() {
      return dbStorage;
   }
    
   /**
    * Method used to set the DB dbStorage.
    *
    * @param dbStorageIn - The supplied dbStorage in TB;
    */
   public void setDbStorage(double dbStorageIn) {
      dbStorage = dbStorageIn;
   }
    
   /**
    * Method used to get the count when it is required outside of the class.
    *
    * @return - Returns the count of the DB;
    */
   public static int getCount() {
      return count;
   }
    
   /**
    * Method used to reset the DB count to 0.
    */
   public static void resetCount() {
      count = 0;
   }
   
   /**
    * Overwrites the default "toString" method to output the contained
    *    information in a more useful, human-readable format.
    *
    * @return - Returns the formatted output string.
    */
   public String toString() {
      DecimalFormat dfStorage = new DecimalFormat("0.000");
      DecimalFormat dfCost = new DecimalFormat("$#,##0.00");
      String output = ""
         + name + " (" + this.getClass() + ") Monthly Cost: "
         + dfCost.format(monthlyCost()) + "\n"
         + "Storage: " + dfStorage.format(dbStorage) + " TB\n"
         + "Base Cost: " + dfCost.format(baseCost);
      return output;
   }
    
   /**
    * Method used to compare DB objects to one another.
    *
    * @return - Returns an integer value; compares the objects by utilizing
    *     The String.compareToIgnoreCase() method on the object names.
    *
    * @param dbIn - The DB object whose name is being compared.
    */
   public int compareTo(DB dbIn) {
      int output =
         this.getName().compareToIgnoreCase(dbIn.getName());
      return output;
   }
   
   // ABSTRACT METHODS_________________________________________________________
   /**
    * Method used to get the monthlyCost when it is
    *     required outside of the object.
    *
    * @return - Returns the monthlyCost of the DB;
    */
   public abstract double monthlyCost();
}