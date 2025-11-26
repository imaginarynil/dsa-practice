package org.example.ctci.arrays_and_strings;

import java.util.Hashtable;
import java.util.Set;

public class is_unique {
    public boolean solve(String input) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (ht.containsKey(c)) {
                ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
        }
        Set<Character> keySet = ht.keySet();
        for (Character c : keySet) {
            if (ht.get(c) > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnique_Solution(String input) {
        boolean[] arr = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            if (arr[input.charAt(i)]) {
                return false;
            }
            arr[input.charAt(i)] = true;
        }
        return true;
    }

    void main() {
        String input = "abcdea";
        System.out.println(isUnique_Solution(input));
    }
}
