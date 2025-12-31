package org.example.leet_code;

import java.util.Arrays;

public class climbing_stairs {
    public int _climbStairs(int[] memo, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] == -1) {
            memo[n] = _climbStairs(memo, n - 1) + _climbStairs(memo, n - 2);
        }
        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return _climbStairs(memo, n);
    }

    /*
     * https://www.youtube.com/watch?v=Y0lT9Fck7qI
     * to reach from n to n, there is 1 way
     * from n - 1 to n there is 1 way
     * from n - 2 to n there are count(n) + count(n - 1)
     * fibonacci
     * */
    public int climbStairs_Solution(int n) {
        int one = 1, two = 1;
        int tmp;
        // n = 5, 2 first positions are used, n - 2 = 3 iterations
        for (int i = 0; i < n - 1; i++) {
            tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }

    void main() {
        var x = climbStairs_Solution(2);
        x = climbStairs_Solution(3);
        x = climbStairs_Solution(5);
    }
}
