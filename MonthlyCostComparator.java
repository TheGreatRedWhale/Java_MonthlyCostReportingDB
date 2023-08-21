// IMPORTS_____________________________________________________________________
import java.util.Comparator;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The MonthlyCostComparator class containing an inventory of InventoryItems.
 *
 * Project 10b
 * 
 * @author Jared Whaley
 * @version 11-13-2020
 */
public class MonthlyCostComparator implements Comparator<DB> {
   
   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "MonthlyCostComparator" class.
    *     Accepts no parameters.
    */
   public MonthlyCostComparator() { }
   
   // METHODS__________________________________________________________________
   /**
    * Compare method for functions that call this class.
    *
    * @param db1 - First supplied database being compared.
    * @param db2 - Second supplied database being compared.
    *
    * @return - Returns a negative integer if the first object's value is
    *     greater than the second, a positive if it is less, and a zero
    *     if they are equal.
    */
   public int compare(DB db1, DB db2) {
      if (db1.monthlyCost() < db2.monthlyCost()) {
         return 1;
      }
      else if (db1.monthlyCost() > db2.monthlyCost()) {
         return -1;
      }
      else {
         return 0;
      }
   }
}