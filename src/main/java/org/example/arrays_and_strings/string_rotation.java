package org.example.arrays_and_strings;

public class string_rotation {
    static boolean compareTwoStrings(String str1, String str2) {
        for(int j = 0; j < str1.length(); j++) {
            if(str1.charAt(j) != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean isSubstring(String str, String needle) {
        // abcxxx
        // uuu+++
        // waterbottlewaterbottle
        for(int i = 0; i < str.length() - (needle.length() - 1); i++) {
            String strToCompare = str.substring(i, i + needle.length());
            if(compareTwoStrings(needle, strToCompare)) {
                return true;
            }
        }
        return false;
    }

    static boolean solve(String substring, String original){
        String haystack = original + original;
        return isSubstring(haystack, substring);
    }

    static void main(){
        String substring = "waterbottle";
        String original = "erbottlewat";
        System.out.println(solve(substring, original));
    }
}
