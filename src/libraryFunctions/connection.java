
package libraryFunctions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class connection {
    
    public static ResultSet executeQuery(Connection con, String query){
       
        try{
           
           Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           String sql = "Select * From USERTABLE";
           ResultSet rs = statement.executeQuery(sql);
           return rs;
           
        } catch (Exception e){
            System.out.println(e);;
            return null;
        }
    }
     public static void updateQuery(Connection con, String query) {
        try { 
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(query);
        }
          catch(Exception e){
          System.out.println(e);
        }
}
}
