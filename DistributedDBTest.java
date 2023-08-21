// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for DistributedDB.java.
 *
 * Activity 9c-Test
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class DistributedDBTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test for getNumberOfUsers. **/
   @Test public void getNumberOfUsersTest() {
      int expectedOutput = 100;
      int methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.getNumberOfUsers();
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for setNumberOfUsers. **/
   @Test public void setNumberOfUsersTest() {
      int expectedOutput = 100;
      int methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 50, 12.0);
      db1.setNumberOfUsers(100);
      methodOutput = db1.getNumberOfUsers();
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for getCostPerUser. **/
   @Test public void getCostPerUserTest() {
      double expectedOutput = 12.0;
      double methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.getCostPerUser();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for setCostPerUser. **/
   @Test public void setCostPerUserTest() {
      double expectedOutput = 12.0;
      double methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 1.0);
      db1.setCostPerUser(12.0);
      methodOutput = db1.getCostPerUser();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for userCost. **/
   @Test public void userCostTest() {
      double expectedOutput = 1200.0;
      double methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.userCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for getCostFactor. **/
   @Test public void getCostFactorTest() {
      double expectedOutput = 1.1;
      double methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.getCostFactor();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for monthlyCost. **/
   @Test public void monthlyCostTest() {
      double expectedOutput = 3320.0;
      double methodOutput = 0;
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.monthlyCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for toString. **/
   @Test public void toStringTest() {
      String expectedOutput = ""
         + "DB One (class DistributedDB) Monthly Cost: $3,320.00\n"
         + "Storage: 7.500 TB\n"
         + "Base Cost: $2,000.00\n"
         + "Number of Users: 100\n"
         + "Cost per User: $12.00\n"
         + "User Cost: $1,200.00\n"
         + "Cost Factor: 1.1";
      String methodOutput = "";
      DistributedDB db1 =
         new DistributedDB("DB One", 2000.00, 7.50, 100, 12.0);
      methodOutput = db1.toString();
      Assert.assertEquals(expectedOutput, methodOutput);
   }
}
