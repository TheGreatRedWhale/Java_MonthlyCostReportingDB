// IMPORTS_____________________________________________________________________

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * InvalidCategoryException Class for throwing ICE exception in DBList.
 *
 * Project 11b
 *
 * @author Jared Whaley
 * @version 11-20-2020
 */
public class InvalidCategoryException extends Exception {

   // CONSTRUCTOR______________________________________________________________
   /**
    * Constructs new instances of the "InvalidCategoryException" exception.
    *
    * @param categoryIn - The invalid category.
    */
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   }
}