// IMPORTS_____________________________________________________________________
import java.text.DecimalFormat;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The class for Centralized Databases (CentralizedDB).
 *     Extends the DB abstract class.
 *
 * Project 9b
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class CentralizedDB extends DB {

   // Instance variables (can be used within the class)
   private double license;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "CentralizedDB" class.
    *
    * @param nameIn - Supplied name of the CentralizedDB.
    * @param baseCostIn - Supplied baseCost of the CentralizedDB.
    * @param dbStorageIn - Supplied storage capacity in TB
    *     of the CentralizedDB.
    * @param licenseIn - Supplied license number of the CentralizedDB.
    */
   public CentralizedDB(String nameIn, double baseCostIn,
      double dbStorageIn, double licenseIn)
   {
      super(nameIn, baseCostIn, dbStorageIn);
      license = licenseIn;
   }

   // METHODS__________________________________________________________________
   /**
    * Method used to get the license when it is required outside of the object.
    *
    * @return - Returns the license of the CentralizedDB;
    */
   public double getLicense() {
      return license;
   }
    
   /**
    * Method used to set the CentralizedDB license.
    *
    * @param licenseIn - The supplied license.
    */
   public void setLicense(double licenseIn) {
      license = licenseIn;
   }
    
   /**
    * Method used to get the monthlyCost when it is
    *     required outside of the object.
    *
    * @return - Returns the monthlyCost of the CentralizedDB;
    */
   public double monthlyCost() {
      return (baseCost + license);
   }
     
   /**
    * Overrides the default "toString" method to output the contained
    *    information in a more useful, human-readable format.
    *
    * @return - Returns the formatted output string.
    */
   @Override
   public String toString() {
      DecimalFormat dfStorage = new DecimalFormat("0.000");
      DecimalFormat dfCost = new DecimalFormat("$#,##0.00");
      String output = super.toString() + "\n"
         + "License: " + dfCost.format(license);
      return output;
   }
}