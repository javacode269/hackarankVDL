package Arithmatic;

public class Fibonacci {
    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        int fibonacci = calculateFibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci);
    }
}

