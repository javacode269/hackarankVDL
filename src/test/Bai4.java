package test;
import java.awt.geom.Point2D;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Bai4 {

    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        List<Integer> r = new ArrayList<>();
        int[] arr = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> mapValue = new HashMap<>();
        for(int i = 1; i < n+1 ;i++){
            arr[i] = i;
            List<Integer> l = new ArrayList<>();
            if(i+k < n && mapValue.get(i+k) ==null) l.add(i+k);
            if(i>k&& mapValue.get(i-k) ==null) l.add(i-k);
            if(l.size()==0){
                r.add(-1);
                return r;
            }
            if(l.size()==1){
                if(mapValue.get(l.get(0))!=null){
                    r.add(-1);
                    return r;
                }else{
                    mapValue.put(l.get(0),i);
                }
            }
        }

        return null;
    }

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<Integer[]> v = new ArrayList<>();
        List<Integer> tmp = matrix.get(0);

        int x = Math.min(tmp.size(),matrix.size());
        int[][] arr = new int[matrix.size()][tmp.size()];
        for(int i = 0 ; i < matrix.size();i++){
            tmp = matrix.get(i);
            for(int j=0;j<tmp.size();j++){
                arr[i][j]= tmp.get(j);
            }
        }
        for(int i =0 ; i < x/2;i++){
            arr[i][i]=1;
        }


    }
    public static int dna(List<String> gens,List<Integer> health,int first, int last, String d){
        List<String> nGens = gens.subList(first,last);
        List<Integer> nHealth = health.subList(first,last);
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
    public static String gridSearch(List<String> G, List<String> P) {
        // Write your code here
        int nP =P.size();
        int nG= G.size();
        boolean a = false;
        for(int i=0;i<nG-nP;i++){
            int j =G.get(i).indexOf(P.get(0));
            if(j>0){
                a=true;
                for(int k = 1;k<nP;k++){
                    if(G.get(i+k).indexOf(P.get(k),j) != j){
                        a=false;
                        break;
                    }
                }
                if(a){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static String timeConversion(String x) {

        // Write your code here
        String[] k = x.replace("PM","").replace("AM","").split(":");
        String newHString="";
        int newH=0;
        if(x.contains("PM")){
            newH = Integer.valueOf(k[0]) + 12;
            if(newH == 24) newH = 12;
        }else{
            newH = Integer.valueOf(k[0]);
            if(newH==12) newH=0;
        }
        if(newH<10) newHString = "0"+newH;
        else newHString=newH+"";
        return newHString+":"+k[1]+":"+k[2];
    }
    public static void plusMinus(List<Integer> arr) {
        float x=0f;
        float y=0f;
        float z=0f;
        for(int i:arr){
            if(i>0) x++;
            else if(x<0) y++;
            else z++;
        }
        DecimalFormat s = new DecimalFormat("0.000000");
        System.out.println(s.format(x/arr.size()));
        System.out.println(s.format(y/arr.size()));
        System.out.println(s.format(z/arr.size()));
        // Write your code here

    }
}
class SolutionX {
    public static void main(String[] args) throws IOException {
        System.out.println();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        Bai4.plusMinus(arr);
//
//        bufferedReader.close();
    }
}
