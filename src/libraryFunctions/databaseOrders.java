/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryFunctions;

import Objects.*;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class databaseOrders {

    private static userDetailsObject currentUser;
    private static ticketDetailsObject currentTicket;

    public static boolean userLogIn(String email, String password) {
        boolean validUser = false;
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM usertable where email = '" + email + "' AND password = '" + password + "'";
            ResultSet rs = databaseManagement.executeQuery(sql);

            if (rs.next()) {
                currentUser = new userDetailsObject(rs.getString("USERID"), rs.getString("email"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("dateOfBirth"));
                validUser = true;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return validUser;
    }

    public static void addUser(String userID, String email, String password, String firstName, String lastName, String dateOfBirth) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO USERTABLE (userID, email, password, firstname, lastname, dateofbirth) VALUES (" + userID + ", " + email + ", " + password + ", " + firstName + ", " + lastName + ", " + dateOfBirth + ")";
            ResultSet rs = databaseManagement.executeQuery(sql);

            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
    

    public static void addBooking(String bookingID, LocalDate dateBooked) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "INSERT INTO BOOKINGTABLE (bookingId, userId, ticketID, datebooked) VALUES ("+bookingID+", "+currentUser.getUserID()+", "+currentTicket.getTicketID()+", "+dateBooked+")";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
    
    public static void addTicket(){
         try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "INSERT INTO ";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
      
    }
    public static void seatsBooked(){
        ArrayList<String> seatsBooked = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystem", "Noah", "1234");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "SELECT TICKETTABLE.seatID FROM ticketTABLE WHERE EXISTS (SELECT SEATTABLE.seatID FROM SEATTABLE WHERE stand = "+1+") AND TICKETID.EVENTID ="+2;
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}