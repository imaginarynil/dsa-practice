package org.example.neetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class string_encode_and_decode {
    static char SEPARATOR = '_';

    /*
     * n = str count in the list
     * m = length of each str
     * O(n) * O(m) * O(1) = O(nm)*/
    public String encode(List<String> strs) {
        var it = strs.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String str = it.next();
            sb.append(str.length()); // O(1) for append characters
            sb.append(SEPARATOR);
            sb.append(str);
        }
        return sb.toString();
    }

    /*
     * n = char count in the str
     * O(n) because touches every char once */
    public List<String> decode(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> strs = new LinkedList<>();
        while (i < str.length()) {
            while (str.charAt(i) != SEPARATOR) {
                sb.append(str.charAt(i));
                i++;
            }
            i++; // i is at the separator, skip the separator
            int length = Integer.parseInt(sb.toString());
            sb.setLength(0); // reset strbuilder
            int stopIdx = i + length;
            while (i < stopIdx) {
                sb.append(str.charAt(i));
                i++;
            }
            strs.add(sb.toString()); // add decoded str to result
            sb.setLength(0); // reset strbuilder
        }
        return strs;
    }

    void main() {
        LinkedList<String> input = new LinkedList<>(Arrays.asList("Hello", "World"));
        var x = encode(input);
        var y = decode(x);
    }
}
