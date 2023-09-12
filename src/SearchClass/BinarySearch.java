package SearchClass;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Trả về chỉ số của phần tử được tìm thấy
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }


    public static int binarySearchTienNV65(int[] arr, int target) {
        //Check array > 0
        if (arr.length < 1){
            System.out.println("Error: Mang bi rong");
            return -1;
        }

        //Kiem tra tinh tang cua day dau vao
        for(int i = 1; i < arr.length; i ++ ) {
            if (arr[i] <= arr[i - 1]) {
                System.out.println("Error: Day dau vao khong dam bao la day tang!");
                return -1;
            }
        }

        //Binary search.
        int left = 0;
        int right = arr.length;

        while (left <= right)
        {
            int mid = (left + right)/2;
            if (arr[mid] == target){
                //Neu chuoi khong tang tuyet doi thi phai loop tuong tuư
                //System.out.println("arr[mid] == target");
                return mid;
            }
            if ( arr[mid] > target){
                //System.out.println("arr[mid] > target");
                right = mid + 1;
                //right khong đổi
            } else {
                //arr[mid] < target
                left = mid;
                //System.out.println("arr[mid] < target");
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao mang khong gian tim kiem: ");
        String line = scanner.nextLine();
        System.out.println(line);
        int[] items = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Nhap vao value can tim kiem: ");
        int item = scanner.nextInt();

        if (binarySearch(items, item)!=-1){
            System.out.println("Item " + item + " Tồn tại trong mảng");
        }
        else {
            System.out.println("Không tìm thấy item ");
        }

//        if (binarySearchTienNV65(items, item)!=-1){
//            System.out.println("Item " + item + " Tồn tại trong mảng");
//        }
//        else {
//            System.out.println("Không tìm thấy item ");
//        }

    }
}
