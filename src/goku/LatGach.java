package goku;

import java.util.Arrays;

public class LatGach {
    /**
     * Một hành lang có kích thước 3xn
     * n=7, hành lang được biểu diễn như hình vẽ dưới đây:
     * Yêu cầu: Hãy đếm số cách lát các viên gạch có kích thước 4x4
     * 2×1 sao cho lát kín được hành lang?
     */
    public static void latgach(){
        int n= 2;

        //k[i] lưu số cách lát gạch đến cột thứ i
        int[] k = new int[n+1];
        k[1]=0;
        k[2]=1;
        for(int i = 3;i<n;i++){
            k[i] = k[i-2] + k[i-1];
        }
        System.out.println(k[n-1]);
    }

    public static void daicontangdainhat(){


        int[] arr = {2,3,3,4,5,4}; //mảng đầu vào
        int n = arr.length; //số phần tử

        /**
         * k[i] lưu dãy con tăng dài nhất tại vị trí i
         */
        int[] k = new int[n];
        Arrays.fill(k,1);

        int max =0;

        for(int i = 0 ; i < n; i ++){
            for(int j=0;j<i;j++){
                if(arr[i]> arr[j] && k[j] >= k[i]){
                    k[i] = k[j]+1;
                    max = k[i];
                }
            }
        }
        System.out.println(max);
        System.out.println(arr[max]);
        for(int i=max;i>0;i--){
            if(k[i]==k[i-1]+1){
                System.out.println(arr[i-1]);
            }
        }



    }

    public static int knapsackRec(int[] w, int[] v, int n, int W) {
        if (n <= 0) {
            return 0;
        } else if (w[n - 1] > W) {
            return knapsackRec(w, v, n - 1, W);
        } else {
            return Math.max(knapsackRec(w, v, n - 1, W), v[n - 1]
                    + knapsackRec(w, v, n - 1, W - w[n - 1]));
        }
    }
    public static void caitui(){
        /**
         * Cho n đồ vật khác nhau, đồ vật thứ i có trọng lượng w và giá trị v
         * Bạn mang theo một chiếc túi có tải trọng tối đa là W
         * Nhiệm vụ của bạn là chọn ra các đồ vật để cho vào túi sao cho tổng giá trị của các đồ vật lấy được là lớn nhất có thể?
         */
        int val[] = new int[] { 60, 100, 120 ,100,90};
        int wt[] = new int[] { 10, 20, 30 , 40,50};
        int W = 50;
        int n = val.length;

        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) { //w là tải trọng còn lại
                if (i == 0 || w == 0) //nếu tải trọng  = 0 thì ko lấy thêm
                    K[i][w] = 0;
                else if (wt[i - 1] <= w) //Nếu vật i thỏa mãn trọng lượng
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        System.out.println(K[n][W]);
        int res = K[n][W];
        System.out.println(res);

        int w = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {

                // This item is included.
                System.out.print(wt[i - 1] + " ");

                // Since this weight is included its
                // value is deducted
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }
    public static void caitui2(){
        int W = 60;
        int[] wt = {1,24,6,3};
        int[] val = {2,3,5,3};
        int n= wt.length;
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w)
                    dp[w]
                            = Math.max(dp[w], dp[w - wt[i - 1]]
                            + val[i - 1]);
            }
        }

        System.out.println(dp[28]);
    }

    static int unboundedKnapsack(int W, int wt[], int val[],
                                 int idx)
    {
        // Base Case
        // if we are at idx 0.
        if (idx == 0) {
            return (W / wt[0]) * val[0];
        }
        // There are two cases either take element or not
        // take. If not take then
        int notTake
                = 0 + unboundedKnapsack(W, wt, val, idx - 1);
        // if take then weight = W-wt[idx] and index will
        // remain same.
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W) {
            take = val[idx]
                    + unboundedKnapsack(W - wt[idx], wt, val,
                    idx);
        }
        return max(take, notTake);
    }
    static int max(int a, int b) { return (a > b) ? a : b; }
    public static void caitui3(){
        //chọn nhiều lần item
        int W = 100;
        int val[] = { 10, 30, 20 };
        int wt[] = { 5, 10, 15 };
        int n = val.length;
        System.out.println(
                unboundedKnapsack(W, wt, val, n - 1));
    }
    public static void main(String[] a){
        //caitui3();
        new GFG().x();
    }
    // Java implementation of the above approach

    static class GFG
    {
        public void x(){
            // Input array
            int arr[] = { 8,1, 3 };
            // Initializing the array with -1
            for (int i = 0; i < maxN ; i++)
                for (int j = 0; j < maxW ; j++)
                    for (int k = 0; k < maxW ; k++)
                        dp[i][j][k] = -1;

            // Number of elements in the array
            int n = arr.length;

            // Capacity of knapsacks
            int w1 = 10, w2 = 3;

            // Function to be called
            System.out.println(maxWeight(arr, n, w1, w2, 0));
        }
        int maxN = 31;
        int maxW = 31;

        // 3D array to store
        // states of DP
        int dp [][][] = new int[maxN][maxW][maxW];

        // w1_r represents remaining capacity of 1st knapsack
        // w2_r represents remaining capacity of 2nd knapsack
        // i represents index of the array arr we are working on
        int maxWeight(int arr [] , int n, int w1_r, int w2_r, int i)
        {
            // Base case
            if (i == n)
                return 0;
            if (dp[i][w1_r][w2_r] != -1)
                return dp[i][w1_r][w2_r];

            // Variables to store the result of three
            // parts of recurrence relation
            int fill_w1 = 0, fill_w2 = 0, fill_none = 0;

            if (w1_r >= arr[i])
                fill_w1 = arr[i] +
                        maxWeight(arr, n, w1_r - arr[i], w2_r, i + 1);

            if (w2_r >= arr[i])
                fill_w2 = arr[i] +
                        maxWeight(arr, n, w1_r, w2_r - arr[i], i + 1);

            fill_none = maxWeight(arr, n, w1_r, w2_r, i + 1);

            // Store the state in the 3D array
            dp[i][w1_r][w2_r] = Math.max(fill_none, Math.max(fill_w1, fill_w2));

            return dp[i][w1_r][w2_r];
        }
    }

// This code is contributed by ihritik

}
