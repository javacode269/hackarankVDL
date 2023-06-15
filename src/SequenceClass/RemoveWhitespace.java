package SequenceClass;

public class RemoveWhitespace {
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        String s = "  Hello,   World!  ";

        String stringWithoutWhitespace = removeWhitespace(s);

        System.out.println("String without whitespace: " + stringWithoutWhitespace);
    }
}
