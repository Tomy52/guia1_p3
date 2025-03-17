package Verifications;

import java.time.LocalDate;

public class Verifications {
    public static boolean verifyAmount(float amount) {
        return !(amount <= 0);
    }

    public static boolean verifyExpiryDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    public static boolean verifyCardNumber(String cardNumber) {
        boolean valid = true;

        if (cardNumber.length() != 16) valid = false;
        if (!cardNumber.matches("[0-9]+")) valid = false;

        return valid;
    }
}
