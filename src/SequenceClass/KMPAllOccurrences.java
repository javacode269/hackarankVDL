package SequenceClass;

import java.util.ArrayList;
import java.util.List;

public class KMPAllOccurrences {
    public static List<Integer> kmpSearchAllOccurrences(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        List<Integer> occurrences = new ArrayList<>();
        int i = 0; // Vị trí duyệt qua chuỗi text
        int j = 0; // Vị trí duyệt qua chuỗi pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    occurrences.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return occurrences;
    }

    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABABABA";
        String pattern = "ABA";

        List<Integer> occurrences = kmpSearchAllOccurrences(text, pattern);

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

