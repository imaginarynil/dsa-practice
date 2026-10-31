package org.example.neetcode;

public class is_anagram {
    /*
     * n = length of s
     * m = length of t
     * O(n) + O(m) = O(n + m) = O(n)*/
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int x : freq) {
            if (x > 0) {
                return false;
            }
        }
        return true;
    }

    void main() {
//        var x = isAnagram("racecar", "carrace");
        var x = isAnagram("jar", "jam");
    }
}
