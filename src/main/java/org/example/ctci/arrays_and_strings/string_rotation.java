package org.example.ctci.arrays_and_strings;

public class string_rotation {
    boolean compareTwoStrings(String str1, String str2) {
        for (int j = 0; j < str1.length(); j++) {
            if (str1.charAt(j) != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    boolean isSubstring(String str, String needle) {
        // abcxxx
        // uuu+++
        // waterbottlewaterbottle
        for (int i = 0; i < str.length() - (needle.length() - 1); i++) {
            String strToCompare = str.substring(i, i + needle.length());
            if (compareTwoStrings(needle, strToCompare)) {
                return true;
            }
        }
        return false;
    }

    boolean solve(String substring, String original) {
        String haystack = original + original;
        return isSubstring(haystack, substring);
    }

    void main() {
        String substring = "waterbottle";
        String original = "erbottlewat";
        System.out.println(solve(substring, original));
    }
}
