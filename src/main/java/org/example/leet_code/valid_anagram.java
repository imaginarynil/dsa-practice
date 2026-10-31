package org.example.leet_code;

import java.util.HashMap;
import java.util.Map;

public class valid_anagram {
    Map<Integer, Integer> buildCharMap(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int codePoint = s.charAt(i);
            if (map.containsKey(codePoint)) {
                map.put(codePoint, map.get(codePoint) + 1);
            } else {
                map.put(codePoint, 1);
            }
        }
        return map;
    }

    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> mapS = buildCharMap(s);
        Map<Integer, Integer> mapT = buildCharMap(t);
        if (mapS.size() != mapT.size()) {
            return false;
        }
        for (int codePoint : mapS.keySet()) {
            if (!mapT.containsKey(codePoint) || (int) mapT.get(codePoint) != mapS.get(codePoint)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram_Optimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a'] -= 1;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    void main() {
        boolean x;
        x = isAnagram_Optimal("anagram", "nagaram");
        x = isAnagram_Optimal("rat", "car");
    }
}
