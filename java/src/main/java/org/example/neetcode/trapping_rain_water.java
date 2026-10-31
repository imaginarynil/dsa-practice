package org.example.neetcode;

public class trapping_rain_water {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

    public int trap_Stack(int[] height) {

        return 0;
    }

    public int trap_TwoPointers(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    void main() {
//        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1}; // 9
//        int[] height = {0}; // 0
//        int[] height = {1, 0, 1}; // 1
//        int[] height = {0, 1, 0}; // 0
        int[] height = {0, 2, 0, 3, 1, 2}; // 3
        var x = trap_TwoPointers(height);
    }
}
