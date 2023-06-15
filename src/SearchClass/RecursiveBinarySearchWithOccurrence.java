package SearchClass;

public class RecursiveBinarySearchWithOccurrence {
    public static int firstOccurrence(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1, true);
    }

    public static int lastOccurrence(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1, false);
    }

    private static int binarySearch(int[] arr, int target, int left, int right, boolean isFirst) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (isFirst) {
                    if (mid == left || arr[mid - 1] != target) {
                        return mid; // Trả về chỉ số đầu tiên của phần tử được tìm thấy
                    }
                    return binarySearch(arr, target, left, mid - 1, true);
                } else {
                    if (mid == right || arr[mid + 1] != target) {
                        return mid; // Trả về chỉ số cuối cùng của phần tử được tìm thấy
                    }
                    return binarySearch(arr, target, mid + 1, right, false);
                }
            }
            if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right, isFirst);
            } else {
                return binarySearch(arr, target, left, mid - 1, isFirst);
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
}
