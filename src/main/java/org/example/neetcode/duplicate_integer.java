package org.example.neetcode;

import java.util.HashSet;
import java.util.Set;

public class duplicate_integer {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) {
                return true;
            }
            s.add(num);
        }
        return false;
    }

    void main() {
//        var x = hasDuplicate(new int[]{1, 2, 3, 3}); // true
        var x = hasDuplicate(new int[]{1, 2, 3, 4}); // false
    }
}
