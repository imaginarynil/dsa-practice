package org.example.neetcode;

public class longest_increasing_subsequence {
    // t: O()
    // s: O()
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int len = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(cur < nums[j]) {
                    len++;
                    cur = nums[j];
                }
            }
            res = Math.max(res, len);
        }
        return res;
    }

    void main() {
        int[] arr = {9,1,4,2,3,3,7};
        int res = lengthOfLIS(arr);
    }
}
