package org.example.ctci.arrays_and_strings;

import java.util.Hashtable;

public class palindrome_permutation {
    boolean solve(String input) {
        String str = input.toLowerCase().replaceAll(" ", "");
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for (char c : str.toCharArray()) {
            if (ht.containsKey(c)) {
                ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
        }
        int oddCount = 0;
        for (char c : ht.keySet()) {
            if (ht.get(c) % 2 != 0) {
                oddCount += 1;
            }
        }
        return oddCount <= 1;
    }

    int getNumericValue(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int cVal = Character.getNumericValue(c);
        if (cVal >= a && cVal <= z) return cVal - a; // starts with 0
        return -1;
    }

    boolean isPalindrome(int[] memo) {
        int oddCount = 0;
        for (int el : memo) {
            if (el % 2 != 0) {
                oddCount += 1;
            }
            if (oddCount > 1) return false;
        }
        return true;
    }

    boolean palindromePermutation_Solution_1(String input) {
        int[] memo = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = getNumericValue(c);
            if (index != -1) {
                memo[index] += 1;
            }
        }
        return isPalindrome(memo);
    }

    boolean palindromePermutation_Solution_2(String input) {
        int[] memo = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int oddCount = 0;
        for (int i = 0; i < input.length(); i++) {
            int index = getNumericValue(input.charAt(i));
            if (index != -1) {
                memo[index] += 1;
                if (memo[index] % 2 != 0) {
                    oddCount += 1;
                } else {
                    oddCount -= 1;
                }
            }
        }
        return oddCount <= 1;
    }

    void main() {
        String[] inputs = new String[]{
                "Tact Coa",
                "abc"
        };
        for (String input : inputs) {
            System.out.println(palindromePermutation_Solution_2(input));
        }
    }
}
