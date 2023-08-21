// IMPORTS_____________________________________________________________________
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

// CLASS_DOCUMENTATION_________________________________________________________
/**
 * The JUnit test file for DBList.java.
 *
 * Project 10a-Test
 * 
 * @author Jared Whaley
 * @version 11-13-2020
 */
public class DBListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test for getDBArray. **/
   @Test public void getDBArrayTest() {
      int expectedOutput = 0;
      int methodOutput;
      DBList dbList1 = new DBList();
      methodOutput = dbList1.getDBArray().length;
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for getInvalidRecordsArray. **/
   @Test public void getInvalidRecordsArrayTest() {
      int expectedOutput = 0;
      int methodOutput;
      DBList dbList1 = new DBList();
      methodOutput = dbList1.getInvalidRecordsArray().length;
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for addDB. **/
   @Test public void addDBTest() {
      int expectedOutput = 2;
      int methodOutput;
      DBList dbList1 = new DBList();
      CentralizedDB db1 =
         new CentralizedDB("DB One", 1200.0, 5.00, 1500.0);
      CentralizedDB db2 =
         new CentralizedDB("DB Two", 1500.0, 5.00, 1250.0);
      dbList1.addDB(db1);
      dbList1.addDB(db2);
      methodOutput = dbList1.getDBArray().length;
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for addInvalidRecord. **/
   @Test public void addInvalidRecordTest() {
      int expectedOutput = 2;
      int methodOutput;
      DBList dbList1 = new DBList();
      dbList1.addInvalidRecord(
         "firstLineThatCausedTheException");
      dbList1.addInvalidRecord(
         "secondLineThatCausedTheException");
      methodOutput = dbList1.getInvalidRecordsArray().length;
      Assert.assertEquals(expectedOutput, methodOutput);
   }

   /** A test for readFile when the supplied filepath does not exist. **/
   @Test public void readFileTest1() {
      boolean errorOccurred = false;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_0.csv");
      }
      catch (FileNotFoundException e) {
         errorOccurred = true;
      }
      Assert.assertTrue(errorOccurred);
   }

   /**
    * A test for readFile when the supplied filepath exists
    *     and there are no exceptions. 
    */
   @Test public void readFileTest2() {
      boolean errorOccurred = false;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_1.csv");
      }
      catch (FileNotFoundException e) {
         errorOccurred = true;
      }
      Assert.assertTrue(!errorOccurred);
   }

   /**
    * A test for readFile when the supplied filepath exists
    *     and there are exceptions thrown by the file. 
    */
   @Test public void readFileTest3() {
      boolean errorOccurred = false;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_2_exceptions.csv");
      }
      catch (FileNotFoundException e) {
         errorOccurred = true;
      }
      Assert.assertTrue(!errorOccurred);
   }
   
   /** A test for generateReport. **/
   @Test public void generateReportTest() {
      String expectedOutput1 = ""
         + "-------------------------------\n"
         + "Monthly Database Report\n"
         + "-------------------------------\n";
      String expectedOutput2 = ""
         + "Database Four (class HeterogeneousDB) Monthly Cost: $3,820.00";
      String methodOutput;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_1.csv");
      }
      catch (FileNotFoundException e) { }
      methodOutput = dbList1.generateReport();
      Assert.assertTrue(methodOutput.contains(expectedOutput1)
         && methodOutput.contains(expectedOutput2));
   }
   
   /** A test for generateReportByName. **/
   @Test public void generateReportByNameTest() {
      String expectedOutput1 = ""
         + "-----------------------------------------\n"
         + "Monthly Database Report (by Name)\n"
         + "-----------------------------------------\n";
      String expectedOutput2 = ""
         + "Database Four (class HeterogeneousDB) Monthly Cost: $3,820.00";
      String methodOutput;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_1.csv");
      }
      catch (FileNotFoundException e) { }
      methodOutput = dbList1.generateReportByName();
      Assert.assertTrue(methodOutput.contains(expectedOutput1)
         && methodOutput.contains(expectedOutput2));
   }
   
   /** A test for generateReportByMonthlyCost. **/
   @Test public void generateReportByMonthlyCostTest() {
      String expectedOutput1 = ""
         + "-------------------------------------------------\n"
         + "Monthly Database Report (by Monthly Cost)\n"
         + "-------------------------------------------------\n";
      String expectedOutput2 = ""
         + "Database Four (class HeterogeneousDB) Monthly Cost: $3,820.00";
      String methodOutput;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_1.csv");
      }
      catch (FileNotFoundException e) { }
      methodOutput = dbList1.generateReportByMonthlyCost();
      Assert.assertTrue(methodOutput.contains(expectedOutput1)
         && methodOutput.contains(expectedOutput2));
   }
   
   /** A test for generateInvalidRecordsReport. **/
   @Test public void generateInvalidRecordsReportTest() {
      String expectedOutput1 = ""
         + "----------------------\n"
         + "Invalid Records Report\n"
         + "----------------------\n";
      String expectedOutput2 = ""
         + "java.util.NoSuchElementException";
      String methodOutput;
      DBList dbList1 = new DBList();
      try {
         dbList1.readFile("database_data_2_exceptions.csv");
      }
      catch (FileNotFoundException e) { }
      methodOutput = dbList1.generateInvalidRecordsReport();
      Assert.assertTrue(methodOutput.contains(expectedOutput1)
         && methodOutput.contains(expectedOutput2));
   }
}