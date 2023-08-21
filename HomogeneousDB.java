// IMPORTS_____________________________________________________________________
// import java.text.DecimalFormat;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The class for Homogeneous Databases (HomogeneousDB).
 *     Extends the DB abstract class.
 *
 * Project 9d
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class HomogeneousDB extends DistributedDB {

   // Constants
   /** The cost factor. **/
   public static final double COST_FACTOR = 1.2;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "HomogeneousDB" class.
    *
    * @param nameIn - Supplied name of the HomogeneousDB.
    * @param baseCostIn - Supplied baseCost of the HomogeneousDB.
    * @param dbStorageIn - Supplied storage capacity in TB
    *     of the HomogeneousDB.
    * @param numberOfUsersIn - Supplied numberOfUsers in the HomogeneousDB.
    * @param costPerUserIn - Supplied costPerUser in the HomogeneousDB.
    */
   public HomogeneousDB(String nameIn, double baseCostIn,
      double dbStorageIn, int numberOfUsersIn, double costPerUserIn)
   {
      super(nameIn, baseCostIn, dbStorageIn, numberOfUsersIn, costPerUserIn);
   }

   // METHODS__________________________________________________________________
   /**
    * Method used to get the COST_FACTOR.
    *
    * @return - Returns the COST_FACTOR of the HomogeneousDB;
    */
   @Override
   public double getCostFactor() {
      return HomogeneousDB.COST_FACTOR;
   }
    
   /**
    * Method used to get the monthlyCost when it is
    *     required outside of the object.
    *
    * @return - Returns the monthlyCost of the HomogeneousDB;
    */
   @Override
   public double monthlyCost() {
      return (baseCost + userCost() * HomogeneousDB.COST_FACTOR);
   }
}