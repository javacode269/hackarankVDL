package SequenceClass;

import java.math.BigInteger;

public class RabinKarp {
    private static final int PRIME = 101;

    public static int rabinKarpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (n < m) {
            return -1; // Không tìm thấy
        }

        long patternHash = calculateHash(pattern, m);
        long textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, i, pattern, 0, m)) {
                return i; // Trả về vị trí tìm thấy
            }

            if (i < n - m) {
                textHash = recalculateHash(text, i, textHash, m);
            }
        }

        return -1; // Không tìm thấy
    }

    private static long calculateHash(String str, int length) {
        long hash = 0;

        for (int i = 0; i < length; i++) {
            hash += (str.charAt(i) * BigInteger.valueOf(PRIME).pow(i).longValue());
        }

        return hash;
    }

    private static long recalculateHash(String str, int oldIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash / PRIME;
        newHash += (str.charAt(oldIndex + patternLength) * BigInteger.valueOf(PRIME).pow(patternLength - 1).longValue());
        return newHash;
    }

    private static boolean checkEqual(String str1, int start1, String str2, int start2, int length) {
        for (int i = 0; i < length; i++) {
            if (str1.charAt(start1 + i) != str2.charAt(start2 + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        String pattern = "World";

        int index = rabinKarpSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}


