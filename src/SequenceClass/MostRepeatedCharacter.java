package SequenceClass;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedCharacter {
    public static char mostRepeatedChar(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char mostRepeated = '\0';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeated = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostRepeated;
    }

    public static void main(String[] args) {
        String s = "abcaabbc";

        char mostRepeatedChar = mostRepeatedChar(s);

        System.out.println("Most Repeated Character: " + mostRepeatedChar);
    }
}


