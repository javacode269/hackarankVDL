package SequenceClass;

public class LongestPalindromicSubstring {
    public static int longestSubstringLength(String s) {
        int n = s.length();

        if (n <= 1) {
            return n;
        }

        int maxLength = 1;
        int start = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }

        return maxLength;
    }
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);       // Trường hợp chuỗi có độ dài lẻ
            int len2 = expandAroundCenter(s, i, i + 1);   // Trường hợp chuỗi có độ dài chẵn
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int n = s.length();

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "abcdeffedcbassssssxxssssss";

        int length = longestSubstringLength(s);

        System.out.println("Length of longest palindromic substring: " + length);

        String longestPalindrome = longestPalindromicSubstring(s);

        System.out.println("Longest Palindromic Substring: " + longestPalindrome);

        System.out.println(longestPalindrome.length());

    }
}
