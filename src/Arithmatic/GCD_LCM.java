package Arithmatic;

public class GCD_LCM {
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 36;

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}
