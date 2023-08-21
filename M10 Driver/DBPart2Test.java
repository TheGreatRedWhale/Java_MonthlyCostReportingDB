// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for DBPart2.java.
 *
 * Activity 10z-Test
 * 
 * @author Jared Whaley
 * @version 11-13-2020
 */
public class DBPart2Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
    * A test for when there are no arguments provided at the command line.
    * 
    * @throws FileNotFoundException - Thrown when the supplied filepath
    *     points to a non-existent file.
    */
   @Test public void argsTest1() throws FileNotFoundException {
      String[] args1 = {};
      DBPart2 db1 = new DBPart2();
      db1.main(args1);
      Assert.assertEquals(DistributedDB.COST_FACTOR, 1.1, 0.001);
   }
   
   /**
    * A test for when there is a valid filepath provided at the command line.
    * 
    * @throws FileNotFoundException - Thrown when the supplied filepath
    *     points to a non-existent file.
    */
   @Test public void argsTest2() throws FileNotFoundException {
      String[] args1 = {"database_data_1.csv"};
      DBPart2 db1 = new DBPart2();
      db1.main(args1);
      Assert.assertEquals(DistributedDB.COST_FACTOR, 1.1, 0.001);
   }
   
   /**
    * A test for getCount.
    * 
    * @throws FileNotFoundException - Thrown when the supplied filepath
    *     points to a non-existent file.
    */
   @Test public void getCountTest() throws FileNotFoundException {
      String[] args1 = {"database_data_1.csv"};
      int expectedOutput = 4;
      int methodOutput = 0;
      DBPart2 db1 = new DBPart2();
      DB.resetCount();
      db1.main(args1);
      methodOutput = DB.getCount();
      Assert.assertEquals("DB count should be 4. ",
            expectedOutput, methodOutput);
   }
}
