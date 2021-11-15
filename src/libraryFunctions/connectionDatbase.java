
package libraryFunctions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Objects.*;



public class connectionDatbase {
    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\ProjectManagment.accdb";
    private static Connection con;
    private static userDetailsObject currentUser;
   public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return null;
    }


}
