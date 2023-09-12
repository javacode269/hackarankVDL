package Arithmatic;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithRepetition {
    public static List<List<Integer>> calculatePermutationsWithRepetition(int[] nums, int k) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrackPermutationsWithRepetition(permutations, new ArrayList<>(), nums, k);
        return permutations;
    }

    private static void backtrackPermutationsWithRepetition(List<List<Integer>> permutations, List<Integer> currentPermutation, int[] nums, int k) {
        if (currentPermutation.size() == k) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            currentPermutation.add(nums[i]);
            backtrackPermutationsWithRepetition(permutations, currentPermutation, nums, k);
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        List<List<Integer>> permutations = calculatePermutationsWithRepetition(nums, k);
        System.out.println("Permutations with repetition of " + nums.length + " elements and length " + k + ": ");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
