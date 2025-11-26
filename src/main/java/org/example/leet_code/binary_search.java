package org.example.leet_code;

public class binary_search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        // base case, nums.length == 1
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    void main() {
        int[] arr = new int[]{-1,0,3,5,9,12};
        int x;
        x = search(arr, 9);
    }
}
