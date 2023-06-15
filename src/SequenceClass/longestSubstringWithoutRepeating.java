package SequenceClass;

import java.util.*;

public class longestSubstringWithoutRepeating {
    public static String longestSubstringWithoutRepeating(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0, end = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                if (j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        String longestSubstring = longestSubstringWithoutRepeating(s);

        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring);
    }
}

