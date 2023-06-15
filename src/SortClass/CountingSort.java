package SortClass;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = getMaxValue(arr);
        int[] count = new int[max + 1];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
