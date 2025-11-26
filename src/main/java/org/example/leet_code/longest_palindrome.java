package org.example.leet_code;

import java.util.HashMap;
import java.util.Map;

public class longest_palindrome {
    int getCodePoint(char c) {
        if (c >= Character.getNumericValue('a') || c <= Character.getNumericValue('z')) {
            return c;
        }
        if (c >= Character.getNumericValue('A') || c <= Character.getNumericValue('Z')) {
            return c;
        }
        return -1;
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int codePoint = getCodePoint(c);
            if (codePoint != -1) {
                char ch = (char) codePoint;
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }
        int oddCount = 0;
        int oddSum = 0;
        int evenSum = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                oddCount += 1;
                oddSum += map.get(c);
            } else {
                evenSum += map.get(c);
            }
        }
        if (oddCount > 1) {
            return evenSum + (oddSum - (oddCount - 1));
        }
        return evenSum + oddSum;
    }

    public int longestPalindrome_Optimal(String s) {
        int[] map = new int[123]; // A: 65, Z: 90, a: 97, z: 122
        for (char c : s.toCharArray()) {
            map[c] += 1;
        }
        int halfSum = 0;
        boolean hasOdd = false;
        for (int x : map) {
            halfSum += x / 2;
            if (x % 2 != 0) {
                hasOdd = true;
            }
        }
        return halfSum * 2 + (hasOdd ? 1 : 0);
    }

    void main() {
        int x;
        x = longestPalindrome_Optimal("abccccdd");
        x = longestPalindrome_Optimal("a");
        x = longestPalindrome_Optimal("ccc");
    }
}
