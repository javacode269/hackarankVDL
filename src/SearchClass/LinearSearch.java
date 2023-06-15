package SearchClass;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Trả về chỉ số của phần tử được tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
}
