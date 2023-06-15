package SequenceClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LongestIncreasingSubsequence {
    public static int findLengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static List<Integer> findLongestIncreasingSequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // Mảng lưu độ dài của chuỗi tăng dài nhất kết thúc tại mỗi vị trí

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().getAsInt(); // Độ dài của chuỗi tăng dài nhất
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                endIndex = i;
                break;
            }
        }

        List<Integer> sequence = new ArrayList<>();
        sequence.add(arr[endIndex]);

        for (int i = endIndex; i > 0; i--) {
            if (dp[i] == dp[i - 1] + 1 && arr[i] > arr[i - 1]) {
                sequence.add(arr[i - 1]);
            }
        }

        List<Integer> reversedSequence = new ArrayList<>();

        for (int i = sequence.size() - 1; i >= 0; i--) {
            reversedSequence.add(sequence.get(i));
        }

        return reversedSequence;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int lengthOfLIS = findLengthOfLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS);


        List<Integer> result = findLongestIncreasingSequence(nums);
        System.out.println(result);
    }
}
