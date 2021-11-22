
package libraryFunctions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class databaseManagement {
    public static void executeUpdateQuery(String query){
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     public static ResultSet executeQuery(String query){
         try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = statement.executeQuery(query);
            
            return rs;
         } catch (Exception e) {
             System.out.println(e);
             return null;
         }
      
     }
}
