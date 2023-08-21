// IMPORTS_____________________________________________________________________
import java.text.DecimalFormat;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The class for Distributed Databases (DistributedDB).
 *     Extends the DB abstract class.
 *
 * Project 9c
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class DistributedDB extends DB {

   // Instance variables (can be used within the class)
   protected int numberOfUsers;
   protected double costPerUser;
   
   // Constants
   /** The cost factor. **/
   public static final double COST_FACTOR = 1.1;
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "DistributedDB" class.
    *
    * @param nameIn - Supplied name of the DistributedDB.
    * @param baseCostIn - Supplied baseCost of the DistributedDB.
    * @param dbStorageIn - Supplied storage capacity in TB
    *     of the DistributedDB.
    * @param numberOfUsersIn - Supplied numberOfUsers in the DistributedDB.
    * @param costPerUserIn - Supplied costPerUser in the DistributedDB.
    */
   public DistributedDB(String nameIn, double baseCostIn,
      double dbStorageIn, int numberOfUsersIn, double costPerUserIn)
   {
      super(nameIn, baseCostIn, dbStorageIn);
      numberOfUsers = numberOfUsersIn;
      costPerUser = costPerUserIn;
   }

   // METHODS__________________________________________________________________
   /**
    * Method used to get the numberOfUsers when it is required outside
    *     of the object.
    *
    * @return - Returns the numberOfUsers of the DistributedDB;
    */
   public int getNumberOfUsers() {
      return numberOfUsers;
   }
    
   /**
    * Method used to set the DistributedDB numberOfUsers.
    *
    * @param numberOfUsersIn - The supplied numberOfUsers.
    */
   public void setNumberOfUsers(int numberOfUsersIn) {
      numberOfUsers = numberOfUsersIn;
   }
   
   /**
    * Method used to get the costPerUser when it is required outside
    *     of the object.
    *
    * @return - Returns the costPerUser of the DistributedDB;
    */
   public double getCostPerUser() {
      return costPerUser;
   }
    
   /**
    * Method used to set the DistributedDB costPerUser.
    *
    * @param costPerUserIn - The supplied costPerUser.
    */
   public void setCostPerUser(double costPerUserIn) {
      costPerUser = costPerUserIn;
   }
    
   /**
    * Method used to get the userCost when it is
    *     required outside of the object.
    *
    * @return - Returns the userCost of the DistributedDB;
    */
   public double userCost() {
      return (numberOfUsers * costPerUser);
   }
   
   /**
    * Method used to get the COST_FACTOR.
    *
    * @return - Returns the COST_FACTOR of the DistributedDB;
    */
   public double getCostFactor() {
      return DistributedDB.COST_FACTOR;
   }
    
   /**
    * Method used to get the monthlyCost when it is
    *     required outside of the object.
    *
    * @return - Returns the monthlyCost of the DistributedDB;
    */
   public double monthlyCost() {
      return (baseCost + userCost() * DistributedDB.COST_FACTOR);
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
         + "Number of Users: " + numberOfUsers + "\n"
         + "Cost per User: " + dfCost.format(costPerUser) + "\n"
         + "User Cost: " + dfCost.format(userCost()) + "\n"
         + "Cost Factor: " + getCostFactor();
      return output;
   }
}