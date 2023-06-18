package goku;

import java.util.Arrays;

public class Knapsack {

    static class Partition {
        int isSubsetSum(int arr[], int n, int sum,
                               int[][] dp)
        {
            // Base Cases
            if (sum == 0)
                return 1;
            if (n == 0 && sum != 0)
                return 0;

            // return solved subproblem
            if (dp[n][sum] != -1) {
                return dp[n][sum];
            }

            // If last element is greater than sum, then
            // ignore it
            if (arr[n - 1] > sum)
                return isSubsetSum(arr, n - 1, sum, dp);

        /* else, check if sum can be obtained by any of
                the following
                (a) including the last element
                (b) excluding the last element
        */
            // also store the subproblem in dp matrix
            if (isSubsetSum(arr, n - 1, sum, dp) != 0
                    || isSubsetSum(arr, n - 1, sum - arr[n - 1], dp)
                    != 0)
                return dp[n][sum] = 1;
            return dp[n][sum] = 0;
            // return dp[n][sum] = isSubsetSum(arr, n - 1, sum,
            // dp) || isSubsetSum(arr, n - 1, sum - arr[n - 1],
            // dp);
        }

        // Returns true if arr[] can be partitioned in two
        // subsets of equal sum, otherwise false
        int findPartiion(int arr[], int n)
        {
            // Calculate sum of the elements in array
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += arr[i];

            // If sum is odd, there cannot be two subsets
            // with equal sum
            if (sum % 2 != 0)
                return 0;

            // To store overlapping subproblems
            int dp[][] = new int[n + 1][sum + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);

            // Find if there is subset with sum equal to
            // half of total sum
            return isSubsetSum(arr, n, sum / 2, dp);
        }

        boolean findPartitionQHD(int arr[], int n)
        {
            int sum = 0;
            int i, j;

            // Calculate sum of all elements
            for (i = 0; i < n; i++)
                sum += arr[i];

            if (sum % 2 != 0)
                return false;

            boolean part[][] = new boolean[sum / 2 + 1][n + 1];

            // initialize top row as true
            for (i = 0; i <= n; i++)
                part[0][i] = true;

            // initialize leftmost column, except part[0][0], as
            // 0
            for (i = 1; i <= sum / 2; i++)
                part[i][0] = false;

            // Fill the partition table in bottom up manner
            for (i = 1; i <= sum / 2; i++) {
                for (j = 1; j <= n; j++) {
                    part[i][j] = part[i][j - 1];
                    if (i >= arr[j - 1])
                        part[i][j]
                                = part[i][j]
                                || part[i - arr[j - 1]][j - 1];
                }
            }

        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */

            return part[sum / 2][n];
        }

        // Driver code
        public void x()
        {
            int arr[] = { 3, 1, 5, 9, 12 };
            int n = arr.length;
            // Function call
            if (findPartiion(arr, n) == 1)
                System.out.println(
                        "Can be divided into two subsets of equal sum");
            else
                System.out.println(
                        "Can not be divided into two subsets of equal sum");

            int arr2[] = { 3, 1, 5, 9, 14 };
            int n2 = arr2.length;

            if (findPartiion(arr2, n2) == 1)
                System.out.println(
                        "Can be divided into two subsets of equal sum");
            else
                System.out.println(
                        "Can not be divided into two subsets of equal sum");

            //quy hoach dong
            int arr3[] = { 3, 1, 1, 2, 2, 1 };
            int n3 = arr3.length;
            if (findPartitionQHD(arr3, n3) == true)
                System.out.println(
                        "Can be divided into two subsets of equal sum");
            else
                System.out.println(
                        "Can not be divided into two subsets of equal sum");
        }
    }
    public static void main(String[] x){
        new Partition().x();
    }
}
