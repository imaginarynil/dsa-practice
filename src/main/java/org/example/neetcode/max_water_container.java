package org.example.neetcode;

/*
 * time: O(n)
 * */
public class max_water_container {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(heights[i], heights[j]));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    void main() {
//        int[] heights = {1,7,2,5,4,7,3,6}; // 36
//        int[] heights = {2,2,2}; // 4
        int[] heights = {1, 500, 500, 1}; // 500
        var x = maxArea(heights);
    }
}
