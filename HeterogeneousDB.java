// IMPORTS_____________________________________________________________________
// import java.text.DecimalFormat;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The class for Heterogeneous Databases (HeterogeneousDB).
 *     Extends the DB abstract class.
 *
 * Project 9e
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class HeterogeneousDB extends DistributedDB {

   // Constants
   /** The cost factor. **/
   public static final double COST_FACTOR = 1.3;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "HeterogeneousDB" class.
    *
    * @param nameIn - Supplied name of the HeterogeneousDB.
    * @param baseCostIn - Supplied baseCost of the HeterogeneousDB.
    * @param dbStorageIn - Supplied storage capacity in TB
    *     of the HeterogeneousDB.
    * @param numberOfUsersIn - Supplied numberOfUsers in the HeterogeneousDB.
    * @param costPerUserIn - Supplied costPerUser in the HeterogeneousDB.
    */
   public HeterogeneousDB(String nameIn, double baseCostIn,
      double dbStorageIn, int numberOfUsersIn, double costPerUserIn)
   {
      super(nameIn, baseCostIn, dbStorageIn, numberOfUsersIn, costPerUserIn);
   }

   // METHODS__________________________________________________________________
   /**
    * Method used to get the COST_FACTOR.
    *
    * @return - Returns the COST_FACTOR of the HeterogeneousDB;
    */
   @Override
   public double getCostFactor() {
      return HeterogeneousDB.COST_FACTOR;
   }
    
   /**
    * Method used to get the monthlyCost when it is
    *     required outside of the object.
    *
    * @return - Returns the monthlyCost of the HeterogeneousDB;
    */
   @Override
   public double monthlyCost() {
      return (baseCost + userCost() * HeterogeneousDB.COST_FACTOR);
   }
}