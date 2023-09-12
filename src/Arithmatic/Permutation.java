package Arithmatic;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> calculatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrackPermutations(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    private static void backtrackPermutations(List<List<Integer>> permutations, List<Integer> currentPermutation, int[] nums) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentPermutation.contains(nums[i])) {
                continue;
            }
            currentPermutation.add(nums[i]);
            backtrackPermutations(permutations, currentPermutation, nums);
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = calculatePermutations(nums);
        System.out.println("Permutations of " + nums.length + " elements: ");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

