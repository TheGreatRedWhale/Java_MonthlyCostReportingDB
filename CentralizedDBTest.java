// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for CentralizedDB.java.
 *
 * Project 10a-Test
 * 
 * @author Jared Whaley
 * @version 11-6-2020
 */
public class CentralizedDBTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   // SUPER CLASS METHODS______________________________________________________
   /** A test for getName. **/
   @Test public void getNameTest() {
      String expectedOutput = "DB One";
      String methodOutput = "";
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.getName();
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for setName. **/
   @Test public void setNameTest() {
      String expectedOutput = "DB One";
      String methodOutput = "";
      CentralizedDB db1 =
         new CentralizedDB("DB 1", 1200.0, 5.00, 1500.0);
      db1.setName("DB One");
      methodOutput = db1.getName();
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for getBaseCost. **/
   @Test public void getBaseCostTest() {
      double expectedOutput = 1200.0;
      double methodOutput = 0.0;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.getBaseCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for setBaseCost. **/
   @Test public void setBaseCostTest() {
      double expectedOutput = 1200.0;
      double methodOutput = 0.0;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1000.0, 5.00, 1500.0);
      db1.setBaseCost(1200.0);
      methodOutput = db1.getBaseCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for getDbStorage. **/
   @Test public void getDbStorageTest() {
      double expectedOutput = 5.00;
      double methodOutput = 0.0;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.getDbStorage();
      Assert.assertEquals(expectedOutput, methodOutput, 0.001);
   }

   /** A test for setDbStorage. **/
   @Test public void setDbStorageTest() {
      double expectedOutput = 5.00;
      double methodOutput = 0.0;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 2.00, 1500.0);
      db1.setDbStorage(5.00);
      methodOutput = db1.getDbStorage();
      Assert.assertEquals(expectedOutput, methodOutput, 0.001);
   }
   
   /** A test for compareTo when the names of the supplied DBs are equal. **/
   @Test public void compareToTest1() {
      int methodOutput;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.compareTo(db2);
      Assert.assertTrue(methodOutput == 0);
   }
   
   /** A test for compareTo when the names of the supplied DBs are unequal. **/
   @Test public void compareToTest2() {
      int methodOutput;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB Two", 2000.00, 5.00, 1500.0);
      methodOutput = db1.compareTo(db2);
      Assert.assertTrue(methodOutput < 0);
   }
   
   // CLASS METHODS____________________________________________________________
   /** A test for toString. **/
   @Test public void toStringTest() {
      String expectedOutput = ""
         + "DB One (class CentralizedDB) Monthly Cost: $2,700.00\n"
         + "Storage: 5.000 TB\n"
         + "Base Cost: $1,200.00\n"
         + "License: $1,500.00";
      String methodOutput = "";
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.toString();
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for getLicense. **/
   @Test public void getLicenseTest() {
      double expectedOutput = 1500.00;
      double methodOutput = 0.00;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.getLicense();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for setLicense. **/
   @Test public void setLicenseTest() {
      double expectedOutput = 1500.00;
      double methodOutput = 0.00;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1000.0);
      db1.setLicense(1500.00);
      methodOutput = db1.getLicense();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }

   /** A test for monthlyCost. **/
   @Test public void monthlyCostTest() {
      double expectedOutput = 2700.00;
      double methodOutput = 0.00;
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      methodOutput = db1.monthlyCost();
      Assert.assertEquals(expectedOutput, methodOutput, 0.01);
   }
}
