package SequenceClass;

public class ReverseString {
    public static String reverseString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        int i = 0;
        int j = n - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Hello, World!";

        String reversedString = reverseString(s);

        System.out.println("Reversed String: " + reversedString);
    }
}
