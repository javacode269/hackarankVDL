package SequenceClass;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static int firstUniqueChar(String s) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (charCountMap.get(c) == 1) {
                return i; // Trả về vị trí ký tự đầu tiên không lặp
            }
        }

        return -1; // Không tìm thấy
    }

    public static void main(String[] args) {
        String s = "leetcode";

        int index = firstUniqueChar(s);

        if (index != -1) {
            System.out.println("First Unique Character found at index " + index);
        } else {
            System.out.println("No First Unique Character found");
        }
    }
}
