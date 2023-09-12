package SolveProblemHKR;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class ResultPlusMinus {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveNumber =0;
        int negativeNumber =0;
        int zeroNumber =0;
        int size = arr.size();
        for (int i=0; i <arr.size(); i++){
            if (arr.get(i)>0) {
                positiveNumber=positiveNumber+1;
            } else if(arr.get(i)<0){
                negativeNumber=negativeNumber+1;
            } else {
                zeroNumber=zeroNumber+ 1;
            }
        }
        System.out.println(positiveNumber +" "+ negativeNumber +" " +zeroNumber);
        System.out.println(String.format("%.4f", (double) positiveNumber/size));
        System.out.println(String.format("%.4f", (double) negativeNumber/size));
        System.out.println(String.format("%.4f", (double) zeroNumber/size));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}