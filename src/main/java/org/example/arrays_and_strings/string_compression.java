package org.example.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.TreeMap;

class Pair {
    public char character;
    public int count;

    Pair(char character, int count) {
        this.character = character;
        this.count = count;
    }
}

public class string_compression {
    static String solve(String input) {
        String result = input;
        ArrayList<Pair> data = new ArrayList<>();
        char currChar = input.charAt(0);
        int currCount = 1;
        for (int i = 1; i < input.length(); i++) {
            if (currChar != input.charAt(i)) {
                data.add(new Pair(currChar, currCount));
                currChar = input.charAt(i);
                currCount = 1;
            } else {
                currCount += 1;
            }
        }
        data.add(new Pair(currChar, currCount)); // add last series
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            strBuilder.append(data.get(i).character + "" + data.get(i).count);
        }
        if (input.length() > strBuilder.toString().length()) {
            result = strBuilder.toString();
        }
        return result;
    }

    static String book_solution(String input) {
        StringBuilder strBuilder = new StringBuilder();
        int currCount = 0;
        for(int i = 0; i < input.length(); i++) {
            currCount += 1;
            if(i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                strBuilder.append(input.charAt(i));
                strBuilder.append(currCount);
                currCount = 0;
            }
        }
        String result = input;
        String compressed = strBuilder.toString();
        if(compressed.length() < input.length()) {
            result = compressed;
        }
        return result;
    }

    static void main() {
        String input = "aabcccccaaa";
        System.out.println(solve(input));
    }
}
