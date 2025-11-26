package org.example.leet_code;

public class ransom_note {
    public int[] getCharMap(char[] str) {
        int[] map = new int[26];
        for(char c: str) {
            map[c - 'a'] += 1;
        }
        return map;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomStr = ransomNote.toCharArray();
        char[] magazineStr = magazine.toCharArray();
        int[] ransomMap = getCharMap(ransomStr);
        int[] magazineMap = getCharMap(magazineStr);
        for(int i = 0; i < ransomMap.length; i++) {
            if(ransomMap[i] > magazineMap[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct_Alternative(String ransomNote, String magazine) {
        char[] ransomStr = ransomNote.toCharArray();
        char[] magazineStr = magazine.toCharArray();
        int[] map = new int[26];
        for(int i = 0; i < magazineStr.length; i++) {
            map[magazineStr[i] - 'a'] += 1;
        }
        for(int i = 0; i < ransomStr.length; i++) {
            map[ransomStr[i] - 'a'] -= 1;
            if(map[ransomStr[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    void main() {
        boolean x;
        x = canConstruct_Alternative("a", "b");
        x = canConstruct_Alternative("aa", "ab");
        x = canConstruct_Alternative("aa", "aab");
    }
}
