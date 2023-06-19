package SearchClass;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Trả về chỉ số của phần tử được tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao mang khong gian tim kiem: ");
        String line = scanner.nextLine();
        int[] items = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Nhap vao value can tim kiem: ");
        int item = scanner.nextInt();

        int vitri = linearSearch(items, item);
        if (vitri==-1){
            System.out.println("Item khong co trong mang");
        }{
            System.out.println("Item nam o vi tri " + vitri + " cua mang");
        }
    }
}
