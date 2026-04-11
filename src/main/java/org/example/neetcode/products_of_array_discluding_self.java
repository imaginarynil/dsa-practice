package org.example.neetcode;

public class products_of_array_discluding_self {
    /*
     * time: O(n)
     * space: O(n) for res, prefix, suffix */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        // O(n)
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        // O(n)
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            int prevProduct = i > 0 ? prefix[i - 1] : 1;
            int nextProduct = i < nums.length - 1 ? suffix[i + 1] : 1;
            res[i] = prevProduct * nextProduct;
        }
        return res;
    }

    /*
     * time: O(n)
     * space: O(n) (res, suffix) and O(1) (n)*/
    public int[] productExceptSelf_Solution_PrefixSuffix_Optimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // suffix[i] stores the product of elements at [i + 1, n - 1]
        // suffix[n - 1] = 1 because after that there are no elements. 1 is an identity, if an identity is multiplied by a number, the result is the number
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        // O(n)
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int prefix = 1;
        // O(n)
        for (int i = 0; i < n; i++) {
            res[i] = prefix * suffix[i];
            prefix *= nums[i];
        }
        return res;
    }

    void main() {
//        int[] in = new int[]{1, 2, 4, 6};
        int[] in = new int[]{-1, 0, 1, 2, 3};
        var x = productExceptSelf_Solution_PrefixSuffix_Optimal(in);
    }
}
