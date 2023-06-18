package Arithmatic;

import java.math.BigDecimal;

public class PiValue {
    public static BigDecimal calculatePi(int decimalPlaces) {
        BigDecimal pi = BigDecimal.valueOf(0);
        BigDecimal term;
        BigDecimal numerator = BigDecimal.valueOf(4);
        BigDecimal denominator = BigDecimal.valueOf(1);
        int sign = 1;

        for (int i = 0; i < decimalPlaces; i++) {
            term = numerator.divide(denominator, decimalPlaces, BigDecimal.ROUND_HALF_UP);
            pi = pi.add(term.multiply(BigDecimal.valueOf(sign)));

            denominator = denominator.add(BigDecimal.valueOf(2));
            sign *= -1;
        }

        return pi;
    }

    public static void main(String[] args) {
        int decimalPlaces = 10;
        BigDecimal pi = calculatePi(decimalPlaces);
        System.out.println("Pi value with " + decimalPlaces + " decimal places: " + pi);
    }
}
