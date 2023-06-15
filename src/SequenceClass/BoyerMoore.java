package SequenceClass;

public class BoyerMoore {
    private static final int NO_OF_CHARS = 256;

    public static int boyerMooreSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] badChar = new int[NO_OF_CHARS];

        preprocessBadChar(pattern, badChar);

        int shift = 0; // Số lượng ký tự dịch chuyển

        while (shift <= n - m) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                return shift; // Trả về vị trí tìm thấy
            }

            shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
        }

        return -1; // Không tìm thấy
    }

    private static void preprocessBadChar(String pattern, int[] badChar) {
        int m = pattern.length();

        for (int i = 0; i < NO_OF_CHARS; i++) {
            badChar[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            badChar[pattern.charAt(i)] = i;
        }
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        String pattern = "World";

        int index = boyerMooreSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}

