package SequenceClass;

public class KMP {
    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        int i = 0; // Vị trí duyệt qua chuỗi text
        int j = 0; // Vị trí duyệt qua chuỗi pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - j; // Trả về vị trí tìm thấy
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1; // Không tìm thấy
    }

    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABABABA";
        String pattern = "ABA";

        int index = kmpSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}

