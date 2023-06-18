package Arithmatic;

public class CatalanNumber {
    public static int calculateCatalan(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += calculateCatalan(i) * calculateCatalan(n - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int catalan = calculateCatalan(n);
        System.out.println("Catalan number at position " + n + " is: " + catalan);
    }
}
