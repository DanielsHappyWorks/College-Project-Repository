
package databasejdbc;
import java.sql.*;
public class DatabaseJDBC {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/animeorganiser";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
       conn = DriverManager.getConnection(DB_URL,USER,PASS);
   }
   catch(SQLException e){
       for(Throwable t : e)
       {
           t.printStackTrace();
       }
   }
   System.out.println("Goodbye!");
}}
