package Arithmatic;

import java.math.BigDecimal;

public class EValue {
    public static BigDecimal calculateE(int decimalPlaces) {
        BigDecimal e = BigDecimal.valueOf(1);
        BigDecimal term = BigDecimal.valueOf(1);

        for (int i = 1; i <= decimalPlaces; i++) {
            term = term.divide(BigDecimal.valueOf(i), decimalPlaces, BigDecimal.ROUND_HALF_UP);
            e = e.add(term);
        }

        return e;
    }

    public static void main(String[] args) {
        int decimalPlaces = 10;
        BigDecimal e = calculateE(decimalPlaces);
        System.out.println("e value with " + decimalPlaces + " decimal places: " + e);
    }
}
