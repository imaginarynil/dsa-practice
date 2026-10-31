package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {
    // t: O(n^2)
    // s: O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            // take out 1
            if(i == 0) {
                tmp.add(1);
            } else if(i == 1) {
                tmp.add(1);
                tmp.add(1);
            } else {
                List<Integer> prev = ans.get(i - 1);
                tmp.add(1);
                for(int j = 1; j < prev.size(); j++) {
                    tmp.add(prev.get(j - 1) + prev.get(j));
                }
                tmp.add(1);
            }
            ans.add(tmp);
        }
        return ans;
    }

    void main() {
        List<List<Integer>> ans = generate(4);
    }
}
