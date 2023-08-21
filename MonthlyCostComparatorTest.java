// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for MonthlyCostComparator.java.
 *
 * Activity 10b-Test
 * 
 * @author Jared Whaley
 * @version 11-13-2020
 */
public class MonthlyCostComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test for compare when the supplied DBs have equal monthly costs. **/
   @Test public void compareTest1() {
      int methodOutput;
      MonthlyCostComparator comparator = new MonthlyCostComparator();
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB Two", 1200.0, 5.00, 1500.0);
      methodOutput = comparator.compare(db1, db2);
      Assert.assertTrue(methodOutput == 0);
   }

   /**
    * A test for compare when the first supplied DB has a greater monthly cost
    *     than the second.
    */
   @Test public void compareTest2() {
      int methodOutput;
      MonthlyCostComparator comparator = new MonthlyCostComparator();
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB Two", 120.0, 5.00, 1500.0);
      methodOutput = comparator.compare(db1, db2);
      Assert.assertTrue(methodOutput < 0);
   }

   /**
    * A test for compare when the first supplied DB has a lower monthly cost
    *     than the second.
    */
   @Test public void compareTest3() {
      int methodOutput;
      MonthlyCostComparator comparator = new MonthlyCostComparator();
      CentralizedDB db1 =
         new CentralizedDB("DB One", 120.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB Two", 1200.0, 5.00, 1500.0);
      methodOutput = comparator.compare(db1, db2);
      Assert.assertTrue(methodOutput > 0);
   }
}