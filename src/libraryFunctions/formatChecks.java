package libraryFunctions;

import java.lang.Object;

public class formatChecks {

    public static boolean validEmail() {
// need to use method to check for high level domain
        String email = "sgjsdkgsj@kjgdf.com";
        boolean valid = false;
        if (email.length() <= 64) {
            if (email.contains("@")) {
                valid = true;
                return valid;
            }
        }
        return valid;
    }

    public static boolean validPassword() {
        String password = "sfsdfa";
        String passwordSecondEntry = "dhbasdg";
        boolean valid = true;

        valid = passwordEqual(valid, password, passwordSecondEntry);
        if (valid == false) {
            return valid;
        }
        if (password.length() <= 20 && valid == true) {
           
        } else {
            valid = false;
            return valid;
        }
        valid = passwordContainUpperCase(valid, password);
        if (valid == false) {
            return valid;
        }
        valid = passwordContainSymbol(valid, password);
        if (valid == false) {
            return valid;
        }

        return valid;
    }

    public static boolean passwordEqual(Boolean valid, String password, String passwordSecondEntry) {

       
        if (password.equals(passwordSecondEntry)&&(valid == true)) {          
            return valid;
        }
        else{
            valid = false;
        }
        return valid;
    }

    public static boolean passwordContainUpperCase(boolean valid, String password) {
        String passwordToLowerCase = password.toLowerCase();
        if (password.equals(passwordToLowerCase)) {
            valid = false;
        } 
        return valid;
    }

    public static boolean passwordContainSymbol(boolean valid, String password) {
        char[] characters = password.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            int asciiValue = (int) character;
            if ((asciiValue >= 33 && asciiValue <= 47) || (asciiValue >= 58 && asciiValue <= 64)
                    || (asciiValue >= 91 && asciiValue <= 96) || (asciiValue >= 123 && asciiValue <= 126)) {
                valid = true;
                return valid;
            } else {
                valid = false;
            }
        }
        return valid;
    }
}
