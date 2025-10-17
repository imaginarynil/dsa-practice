package org.example.arrays_and_strings;
import java.util.*;

public class is_unique {
    public static boolean solve(String input) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for(int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if(ht.containsKey(c)) {
                ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
        }
        Set<Character> keySet = ht.keySet();
        for(Character c: keySet) {
            if(ht.get(c) > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean book_solution(String input) {
        boolean[] arr = new boolean[128];
        for(int i = 0; i < input.length(); i++){
            if(arr[input.charAt(i)]){
                return false;
            }
            arr[input.charAt(i)] = true;
        }
        return true;
    }

    static void main() {
        String input = "abcdea";
        System.out.println(book_solution(input));
    }
}
