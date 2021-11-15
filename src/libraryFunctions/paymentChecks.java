package libraryFunctions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class paymentChecks {

    public boolean cardNumberCheck() {
        boolean valid = true;
        valid = cardNumberCheck(valid);
        valid = CVC(valid);
        valid = cardHolderName(valid);
        return valid;
    }

    public boolean cardNumberCheck(Boolean valid) {
        String dataToAscii = "fafgshfgahaaddsd";
        int[] ascii = ascii(dataToAscii);
        char[] digits = new char[ascii.length];
        
        for (int i = 0; i < ascii.length; i++) {
            int asciiValue = ascii[i];
            if (asciiValue >= 47 || asciiValue <= 58) {

            } else {
                if (digits.length < 16) {
                    digits[i] = (char) ascii[i];
                }
            }
        }
        if (digits.length != 16) {
            valid = false;
            return valid;
        }
        return valid;
    }

    public int[] ascii(String dataToAscii) {
        char[] characters = dataToAscii.toCharArray();
        int[] ascii = new int[characters.length];
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            int asciiValue = (int) character;
            ascii[i] = asciiValue;
        }
        return ascii;
    }
    
    public boolean CVC(boolean valid){
        int cvc = 345;
        if(cvc>999 || cvc<100){
            valid = false;
            return valid;
        }
        return valid;
    }
    public boolean cardHolderName(boolean valid){
        String dataToAscii = "fafgshfgahaaddsd";
        dataToAscii = dataToAscii.toLowerCase();
        int[] ascii = ascii(dataToAscii);
        int numberOfSpaces = 0;
        int numberOfHyphens = 0;
        for (int i = 0; i < ascii.length; i++) {
            if(ascii[i]<=96 || ascii[i]<=123){
                if(ascii[i]==32){
                    numberOfSpaces = numberOfSpaces+1;
                } else if(ascii[i]==45){
                    numberOfHyphens = numberOfHyphens+1;
                } else{
                    valid = false;
                }
            }
        }
        if(numberOfSpaces>1||numberOfHyphens>1){
            valid = false;
        }
        return valid;
    }
    public boolean expiryDateCheck(boolean valid){
        LocalDate expiryDate = LocalDate.of(2017, Month.MARCH, 4);
        DateTimeFormatter expiryDateFormat = DateTimeFormatter.ofPattern("MM-yy");
       // expiryDate = LocalDate.parse(expiryDate, expiryDateFormat);
       LocalDate current = LocalDate.now();
       if(expiryDate.isBefore(current)){
           valid = false;
       }
        return valid;
    }
}
