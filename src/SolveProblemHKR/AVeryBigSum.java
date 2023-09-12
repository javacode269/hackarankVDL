package SolveProblemHKR;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Description
 * link:https://www.hackerrank.com/challenges/a-very-big-sum/problem?isFullScreen=true
 *In this challenge, you are required to calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
 *
 * Function Description
 *
 * Complete the aVeryBigSum function in the editor below. It must return the sum of all array elements.
 *
 * aVeryBigSum has the following parameter(s):
 *
 * int ar[n]: an array of integers .
 * Return
 *
 * long: the sum of all array elements
 * Input Format
 *
 * The first line of the input consists of an integer .
 * The next line contains  space-separated integers contained in the array.
 *
 * Output Format
 *
 * Return the integer sum of the elements in the array.
 *
 * Constraints
 *
 *
 * Sample Input
 *
 * 5
 * 1000000001 1000000002 1000000003 1000000004 1000000005
 * Output
 *
 * 5000000015
 * Note:
 *
 * The range of the 32-bit integer is .
 * When we add several integer values, the resulting sum might exceed the above range. You might need to use long int C/C++/Java to store such sums.
 **/


public class AVeryBigSum {
    static class Result {

        /*
         * Complete the 'aVeryBigSum' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER_ARRAY ar as parameter.
         */
        public static String addBigInteger(String number1, String number2){
            System.out.println();
            System.out.println();
            System.out.println("----Starting function addBigInteger---");
            System.out.println(number1);
            System.out.println(number2);
            String result = "";

            //ensure that number1 > number2
            String temp = "";
            if (number1.length()<number2.length()){
                temp=number1;
                number1=number2;
                number2=temp;
            }
            //split number to array
            String[] number1AsArr = number1.split("");
            String[] number2AsArr = number2.split("");
            int remVar = 0;
            int deltaNumChar = number1AsArr.length - number2AsArr.length;

            for (int i = number1AsArr.length - 1 ; i >=0; i --){
                int j = i -deltaNumChar;
                int tong= 0;
                if (j >= 0) {
                    tong =Integer.parseInt(number1AsArr[i])  + Integer.parseInt(number2AsArr[j]) + remVar;
                } else
                {
                    tong =Integer.parseInt(number1AsArr[i])  + remVar;
                }
                int dv = tong%10;
                remVar= tong/10;
                result = dv + result;
            }
            System.out.println(result);
            if (remVar>0) {
                result = remVar+result;
            }
            return  result;
        }

        public static long aVeryBigSum(List<Long> ar) {

            String result = "0";
            for (int i = 0;i < ar.size(); i ++){
                result = Result.addBigInteger(result, ar.get(i).toString());
            }
            return Long.parseLong(result);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

//        System.out.println(Result.addBigInteger("345123545454", "12312318989812312312"));

        long result = Result.aVeryBigSum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
