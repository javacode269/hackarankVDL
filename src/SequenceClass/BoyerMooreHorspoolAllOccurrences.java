package SequenceClass;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreHorspoolAllOccurrences {
    private static final int NO_OF_CHARS = 256;

    public static List<Integer> boyerMooreHorspoolSearchAllOccurrences(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] badChar = new int[NO_OF_CHARS];

        preprocessBadChar(pattern, badChar);

        List<Integer> occurrences = new ArrayList<>();
        int shift = 0; // Số lượng ký tự dịch chuyển

        while (shift <= n - m) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                occurrences.add(shift);
            }

            shift += Math.max(1, j - badChar[text.charAt(shift + m - 1)]);
        }

        return occurrences;
    }

    private static void preprocessBadChar(String pattern, int[] badChar) {
        int m = pattern.length();

        for (int i = 0; i < NO_OF_CHARS; i++) {
            badChar[i] = m;
        }

        for (int i = 0; i < m - 1; i++) {
            badChar[pattern.charAt(i)] = m - 1 - i;
        }
    }

    public static void main(String[] args) {
        String text = "ABABABABA";
        String pattern = "ABA";

        List<Integer> occurrences = boyerMooreHorspoolSearchAllOccurrences(text, pattern);

        if (!occurrences.isEmpty()) {
            System.out.println("Pattern found at indexes:");
            for (int index : occurrences) {
                System.out.println(index);
            }
        } else {
            System.out.println("Pattern not found");
        }
    }
}



