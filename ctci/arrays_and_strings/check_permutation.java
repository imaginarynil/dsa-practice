package org.example.ctci.arrays_and_strings;

import java.util.Arrays;

public class check_permutation {
    String sortString(String str) {
        char[] sortedString = str.toCharArray();
        Arrays.sort(sortedString);
        return new String(sortedString);
    }

    boolean solve(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String sortedStr1 = sortString(str1);
        String sortedStr2 = sortString(str2);
        return sortedStr1.equals(sortedStr2);
    }

    boolean checkPermutation_Solution_1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCount = new int[128];
        for (int i = 0; i < charCount.length; i++) {
            charCount[i] = 0;
        }
        for (char c : str1.toCharArray()) {
            charCount[c] += 1;
        }
        for (char c : str2.toCharArray()) {
            charCount[c] -= 1;
            if (charCount[c] < 0) {
                return false;
            }
        }
        return true;
    }

    void main() {
        String[][] inputs = {
                {"abc", "cab"},
                {"abc", "cbd"}
        };
        for (String[] input : inputs) {
            System.out.println(checkPermutation_Solution_1(input[0], input[1]));
        }
    }
}
