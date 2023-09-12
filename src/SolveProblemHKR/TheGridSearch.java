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

class Result1 {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public  static  String gridSearch (List<String> G, List<String> P){

        int rowG = G.size();
        int rowP = P.size();
        boolean isMatchAllLine = true;


        for (int i =0; i <=rowG-rowP; i++){
//            System.out.println("=====================");
//            System.out.println("Dong thu " + i);
            isMatchAllLine = true;
            //Voi tung dong trong G
            //Tim cac vi tri match duoc vs P
            int startIndex = 0;
            boolean isContinuePerLine =true;
            String firstLineP = P.get(0);
            String firstLineG = G.get(i);


            while(isContinuePerLine)
            {
//                System.out.println("Dang so khop dong dau tien cua P va dong i cua G");
                String tmpFirstLineG = firstLineG.substring(startIndex);
                int startIndexSubString = tmpFirstLineG.indexOf(firstLineP);

                if (startIndexSubString!=-1) {
//                    System.out.println("Tim duoc pattern P trong dong I cua G");
                    isContinuePerLine = true;
                } else {
//                    System.out.println("Khong tim duoc pattern P trong dong I cua G");
                    isContinuePerLine = false;
                    break;
                }

                //Lay vi tri cua dong tren G match vs dong dau tien tren P
                startIndex = startIndex+ (startIndexSubString==0?1:startIndexSubString);
//                System.out.println("vi tri khop la " + startIndex);


                //Duyet qua tat ca N-1 dong con lai xem co match khong
                //Vi dong dau tien da match nen khong match tiep nua
                for (int j =1; j < rowP; j++){
                    String LineJthOfG = G.get(i+j);
                    System.out.println("Line J of G: " + G.get(i+j));
                    System.out.println("Line J of P: " +P.get(j));
                    boolean isMatchJthLine = LineJthOfG.substring(startIndex, startIndex+firstLineP.length()).equals(P.get(j));
                    if (!isMatchJthLine) {
                        isMatchAllLine = false;
                        break;
                    }
                }
                if (isMatchAllLine){
//                    System.out.println("return YES");
                    return "YES";
                }
            }
        }
        return "NO";
    }

}


public class TheGridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result1.gridSearch(G, P);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
