package org.example.neetcode;

import java.util.HashMap;

public class decode_ways {
    HashMap<Integer, Integer> h;
    // t: O(n)
    // s: O(n)
    public int numDecodingsUtil(String s, int i) {
        if(h.containsKey(i)) {
            return h.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int res = numDecodingsUtil(s, i + 1);
        // until there is still 2 elements from the end
        if(i < s.length() - 1) {
            int x = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if(x >= 10 && x <= 26) {
                res += numDecodingsUtil(s, i + 2);
            }
        }
        h.put(i, res);
        return res;
    }

    public int numDecodings(String s) {
        h = new HashMap<>();
        h.put(s.length(), 1);
        return numDecodingsUtil(s, 0);
    }

    void main() {
        int res = numDecodings("27"); // 2
        res = numDecodings("01"); // 0
        res = numDecodings("12"); // 2
        res = numDecodings("1110"); // 2
    }
}
