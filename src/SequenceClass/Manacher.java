package SequenceClass;

public class Manacher {
    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String processedString = preprocessString(s);
        int n = processedString.length();
        int[] p = new int[n];
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (processedString.charAt(i + (1 + p[i])) == processedString.charAt(i - (1 + p[i]))) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLength) / 2;
        int endIndex = startIndex + maxLength;

        return s.substring(startIndex, endIndex);
    }

    private static String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "babad";

        String longestPalindrome = findLongestPalindrome(s);

        System.out.println("Longest Palindrome: " + longestPalindrome);
    }
}

