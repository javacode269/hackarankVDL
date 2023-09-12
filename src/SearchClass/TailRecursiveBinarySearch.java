package SearchClass;

import java.util.Arrays;
import java.util.Scanner;

public class TailRecursiveBinarySearch {
    public static int tailRecursiveBinarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Trả về -1 nếu không tìm thấy
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid; // Trả về chỉ số của phần tử được tìm thấy
        }
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return binarySearch(arr, target, left, mid - 1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao mang: ");

        String line = scanner.nextLine();
        int[] items  = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
