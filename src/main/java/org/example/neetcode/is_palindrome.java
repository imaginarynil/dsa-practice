package org.example.neetcode;

public class is_palindrome {
    public int getCharVal(char c) {
        if (Character.getNumericValue(c) >= Character.getNumericValue('0') && Character.getNumericValue(c) <= Character.getNumericValue('9')) {
            return Character.getNumericValue(c) - Character.getNumericValue('0') + '0';
        }
        if (Character.getNumericValue(c) >= Character.getNumericValue('a') && Character.getNumericValue(c) <= Character.getNumericValue('z')) {
            return Character.getNumericValue(c) - Character.getNumericValue('a') + 'a';
        }
        return -1;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int x = getCharVal(s.charAt(i));
            if (x != -1) {
                sb.append((char) x);
            }
        }
        String str = sb.toString();
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    void main() {
//        String in = "Was it a car or a cat I saw?";
//        String in = "tab a cat";
//        String in = "012";
        String in = "";
        var x = isPalindrome(in);
    }
}
