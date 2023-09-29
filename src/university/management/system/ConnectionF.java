package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionF {
    
    Connection conn;
    Statement stm;
    ConnectionF(){
       
         String url = "jdbc:mysql://localhost:3306/university";
         String username = "root";
         String password = "Rahul@123";
        try{
            conn = DriverManager.getConnection(url,username,password);
           
            stm = conn.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
    }
      
}
