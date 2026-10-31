package org.example.leet_code;

import java.util.HashMap;
import java.util.Map;

public class valid_palindrome {
    public int getNumericValue(char c) {
        int val = Character.getNumericValue(c);
        if (
                val >= Character.getNumericValue('a') && val <= Character.getNumericValue('z') ||
                        val >= Character.getNumericValue('0') && val <= Character.getNumericValue('9')
        ) {
            return val;
        }
        return -1;
    }

    public boolean isPalindrome(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            int val = getNumericValue(c);
            if (val == -1) {
                continue;
            }
            sb.append((char) val);
        }
        char[] cleanedStr = sb.toString().toCharArray();
        for (int i = 0; i < cleanedStr.length / 2; i++) {
            if (cleanedStr[i] != cleanedStr[cleanedStr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_Optimal(String s) {
        StringBuilder sb = new StringBuilder();
//        s = s.toLowerCase(); // alternative
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String str = sb.toString();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    void main() {
        boolean b;
        b = isPalindrome_Optimal("A man, a plan, a canal: Panama");
        b = isPalindrome_Optimal("race a car");
        b = isPalindrome_Optimal(" ");
        b = isPalindrome_Optimal("0P");
    }
}
