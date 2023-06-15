package SequenceClass;

public class IsSubstringPalindrome {
    public static boolean isSubstringPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean hasPalindromeSubstring(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isSubstringPalindrome(s, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abbca";

        boolean hasPalindromeSubstring = hasPalindromeSubstring(s);

        if (hasPalindromeSubstring) {
            System.out.println("The string has a palindrome substring.");
        } else {
            System.out.println("The string does not have a palindrome substring.");
        }
    }
}

