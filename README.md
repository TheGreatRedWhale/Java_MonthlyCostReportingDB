# Java_MonthlyCostReportingDB

Java Representation of monthly cost and reporting for database systems. This is the final upload for one of my earlier classes at Auburn University; this final upload/submission focuses on handling exceptions that are thrown as a result of erroneous input from the command line or the data file.

In the DBPart3 class, the main method, which reads in the file name as a command line argument, handles FileNotFoundException(s) that may result from attempting to open the file (e.g., if the file does not exist). Also, the readFile method in DBList handles exceptions that occur while processing the data file, including a new exception called InvalidCategoryException. The aforementioned InvalidCategoryException was described in the course materials via UML diagrams.

For more information on the project, its constraints, and deliverables, please see "Project_11.pdf" in the root directory
