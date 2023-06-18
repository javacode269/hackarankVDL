package Arithmatic;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> calculateCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrackCombinations(combinations, new ArrayList<>(), 1, n, k);
        return combinations;
    }

    private static void backtrackCombinations(List<List<Integer>> combinations, List<Integer> currentCombination, int start, int n, int k) {
        if (k == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrackCombinations(combinations, currentCombination, i + 1, n, k - 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> combinations = calculateCombinations(n, k);
        System.out.println("Combinations of " + n + " choose " + k + ": ");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
