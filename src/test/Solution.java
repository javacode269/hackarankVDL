package test;

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



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> totals = new ArrayList<>();
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];

                int total = dna(genes,health,first,last,d);
                totals.add(total);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        System.out.println(Collections.min(totals)+" "+Collections.max(totals));
    }
    public static int dna(List<String> gens,List<Integer> health,int first, int last, String d){
        List<String> nGens = gens.subList(first,last+1);
        List<Integer> nHealth = health.subList(first,last+1);
        int total = 0 ;
        for(int i = 0 ; i < nGens.size();i ++){
            String g  = nGens.get(i);
            int j = d.indexOf(g);
            while(j>-1){
                total+=nHealth.get(i);
                j = d.indexOf(g,j+1);
            }
        }
        return total;
    }
}
