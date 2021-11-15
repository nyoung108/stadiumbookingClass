
package libraryFunctions;

import java.text.DecimalFormat;

public class ticketPriceGenerator {
    public static double ticketPrice() {
        double rowPrice = rowPrice(); 
        double standPrice = standPrice(); 
        double eventPrice = eventPrice(); 
        
        double ticketPrice = rowPrice+standPrice+eventPrice;
        new DecimalFormat("##.##").format(ticketPrice);
        System.out.println(ticketPrice);
        return ticketPrice;
    }
    public static double rowPrice(){
       
        double rowNumber = 4.54;  //get seat row from database
        double rowPrice = (15-rowNumber)/4;
        return rowPrice;
    }
    public static double standPrice(){
        double standPrice = 5.23; //get stand price from database
        return standPrice;
    }
    public static double eventPrice(){
        double eventPrice = 5.78; //get event price from database
        return eventPrice;
    }
}
