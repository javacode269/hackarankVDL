package goku;

import java.util.Arrays;

public class subsets {
    static int maxN = 20;
    static int maxSum = 50;
    static int minSum = 50;
    static int base = 50;

    // To store the states of DP
    static int [][]dp = new int[maxN][maxSum + minSum];
    static boolean [][]v = new boolean[maxN][maxSum + minSum];

    // Function to return the required count
    static int findCnt(int []arr, int i,
                       int required_sum, int n)
    {
        // Base case
        if (i == n)
        {
            if (required_sum == 0)
                return 1;
            else
                return 0;
        }

        // If the state has been solved before
        // return the value of the state
        if (v[i][required_sum + base])
            return dp[i][required_sum + base];

        // Setting the state as solved
        v[i][required_sum + base] = true;

        // Recurrence relation
        dp[i][required_sum + base] =
                findCnt(arr, i + 1, required_sum, n) +
                        findCnt(arr, i + 1, required_sum - arr[i], n);
        return dp[i][required_sum + base];
    }

    static int power(int x, int a)
    {
        int res = 1;
        while (a > 0) {
            if ((a & 1) > 0)
                res = res * x;
            x = x * x;
            a >>= 1;
        }
        return res;
    }

    // Method returns maximum product obtained by
    // breaking N
    static int breakInteger(int N)
    {
        // base case 2 = 1 + 1
        if (N == 2)
            return 1;

        // base case 3 = 2 + 1
        if (N == 3)
            return 2;

        int maxProduct = -1;

        // breaking based on mod with 3
        switch (N % 3) {
            // If divides evenly, then break into all 3
            case 0:
                maxProduct = power(3, N / 3);
                break;

            // If division gives mod as 1, then break as
            // 4 + power of 3 for remaining part
            case 1:
                maxProduct = 2 * 2 * power(3, (N / 3) - 1);
                break;

            // If division gives mod as 2, then break as
            // 2 + power of 3 for remaining part
            case 2:
                maxProduct = 2 * power(3, N / 3);
                break;
        }
        return maxProduct;
    }

    static int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
    static long countWays(int coins[], int n, int sum)
    {
        // Time complexity of this function: O(n*sum)
        // Space Complexity of this function: O(sum)

        // table[i] will be storing the number of solutions
        // for value i. We need sum+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (sum = 0)
        long[] table = new long[sum + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];

        return table[sum];
    }
    // Driver code
    public static void main(String []args)
    {
        int arr[] = { 1, 2, 3,5 };
        int n = arr.length;
        int x = 6;
        //Số dãy con có tổng bằng 6
        System.out.println(findCnt(arr, 0, x, n));

        //Given a number n, the task is to break n in such a way that multiplication of its parts is maximized.
        int maxProduct = breakInteger(10);
        System.out.println(maxProduct);


        //Cho trước một giá trị V , tính số lượng item tối thiểu để tổng bẳng v
        int coins[] =  {1,2,3};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
        System.out.println("Số cách lấy coins để tổng bằng V: "+ countWays(coins, m, V) );
    }
}
