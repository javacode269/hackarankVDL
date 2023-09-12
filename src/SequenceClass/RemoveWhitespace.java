package SequenceClass;

public class RemoveWhitespace {
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        String s = "  Image,   World!  ";

        String stringWithoutWhitespace = removeWhitespace(s);

        System.out.println("String without whitespace: " + stringWithoutWhitespace);
    }
}
