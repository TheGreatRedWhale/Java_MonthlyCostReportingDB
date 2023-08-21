// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for HomogeneousDB.java.
 *
 * Activity 9d-Test
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class HomogeneousDBTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test for getCostFactor. **/
   @Test public void getCostFactorTest() {
      double expectedOutput = 1.2;
      double methodOutput = 0;
      HomogeneousDB db1 =
         new HomogeneousDB("DB One", 2000.00, 7.50, 100, 14.0);
      methodOutput = db1.getCostFactor();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for monthlyCost. **/
   @Test public void monthlyCostTest() {
      double expectedOutput = 3680.0;
      double methodOutput = 0;
      HomogeneousDB db1 =
         new HomogeneousDB("DB One", 2000.00, 7.50, 100, 14.0);
      methodOutput = db1.monthlyCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }
}
