package SequenceClass;

public class BruteForce {
    public static int bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // Trả về vị trí tìm thấy
            }
        }

        return -1; // Không tìm thấy
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        String pattern = "World";

        int index = bruteForceSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
