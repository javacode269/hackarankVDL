package SequenceClass;
import java.util.HashMap;
import java.util.Map;

public class Sunday {
    public static int sundaySearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (n < m) {
            return -1; // Không tìm thấy
        }

        Map<Character, Integer> shiftTable = createShiftTable(pattern);

        int i = 0; // Vị trí duyệt qua chuỗi text

        while (i <= n - m) {
            int j = 0; // Vị trí duyệt qua chuỗi pattern

            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i; // Trả về vị trí tìm thấy
            }

            if (i + m >= n) {
                return -1; // Không tìm thấy
            }

            char nextChar = text.charAt(i + m);

            if (shiftTable.containsKey(nextChar)) {
                i += shiftTable.get(nextChar);
            } else {
                i += m + 1;
            }
        }

        return -1; // Không tìm thấy
    }

    private static Map<Character, Integer> createShiftTable(String pattern) {
        Map<Character, Integer> shiftTable = new HashMap<>();

        int m = pattern.length();

        for (int i = 0; i < m; i++) {
            shiftTable.put(pattern.charAt(i), m - i);
        }

        return shiftTable;
    }

    public static void main(String[] args) {
        String text = "Image, World!";
        String pattern = "World";

        int index = sundaySearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}


