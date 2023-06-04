//this page for connection database 
// database name smartquiz (admin tabile for email and password store)
package smartquiz;


import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    
     public static Connection connect(){
         //url user password of database 
         String url = "jdbc:mysql://localhost/smartquiz";
         String user = "root";
         String password ="";
        
         try {      
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
             
           
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }    
}