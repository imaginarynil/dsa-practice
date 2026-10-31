package org.example.neetcode;

import java.util.HashMap;

public class jump_game {
    HashMap<Integer, Boolean> m = new HashMap<>();

    // t: O()
    // s: O()
    public boolean canJump(int[] nums) {
        m = new HashMap<>();
        return dfs(nums, 0);
    }

    boolean dfs(int[] nums, int i) {
        if(m.containsKey(i)) {
            return m.get(i);
        }
        if(i == nums.length - 1) {
            return true;
        }
        if(nums[i] == 0) {
            return false;
        }
        int end = Math.min(i + nums[i], nums.length - 1);
        for(int j = i + 1; j <= end; j++) {
            if(dfs(nums, j)) {
                m.put(i, true);
                return true;
            }
        }
        m.put(i, false);
        return false;
    }

    void main() {
        boolean res = canJump(new int[]{2,3,1,1,4});
        res = canJump(new int[]{1,2,1,0,1});
    }
}
