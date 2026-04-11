package org.example.neetcode;

import java.util.*;

public class longest_consecutive_sequence {
    /*
     * 2,3,4,4,5,10,20
     * 0,1,1,2,3,4,5,6
     * time: O(n * log(n))
     * space: O(1) or O(n) depending on the sorting algo */
    public int longestConsecutive(int[] nums) {
        // O(n * log(n))
        Arrays.sort(nums);
        int max = 0;
        if (nums.length == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // sequence of next = prev + 1
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else if (nums[i] - nums[i - 1] != 0) {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public int longestConsecutive_Solution_HashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }

    public int longestConsecutive_Solution_HashMap(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (!m.containsKey(num)) {

            }
        }
        return res;
    }

    void main() {
//        int[] in = new int[]{2, 20, 4, 10, 3, 4, 5};
        int[] in = new int[]{0, 3, 2, 5, 4, 6, 1, 1};
//        var x = longestConsecutive(in);
//        var x = longestConsecutive_Solution_HashSet(in);
    }
}

/* Hash Map Solution

Idea:
- only need to process unique elements, so !m.containsKey(n), else produce inaccurate result because count "n" > 1
- m[n] is the longest seq length including "n". m[n] = m[n - 1] + m[n + 1] + 1. m[n - 1] is max length for a sequence ending at n - 1 and m[n + 1] is max length of a sequence starting at n + 1
- m[n - m[n - 1]] this is to find the starting number of a sequence ending at n and updates the max length for the sequence
- m[n + m[n + 1]] is to find the ending number of the longest sequence starting at n + 1 and updates the max length
    - let k be the ending number
    - updates the maximum length for the sequence ..., n, n+1, ..., k-1, k
- m[n] combines the max length of max length of ..., n-2, n-1 and n and max length of n+1, n+2, ...

in: 2,3,4,5,10,20

mp
2 4
3 2
4 3
5 4
10 1
20 1

length = mp[num - 1] + mp[num + 1] + 1
mp[num] = length
mp[num - mp[num - 1]] = length
mp[num - mp[num + 1]] = length

2
mp[2] = 0 + 0 + 1
mp[2 - mp[1]] = mp[2] = 1
mp[2 + mp[3]] = mp[2] = 1

3
mp[3] = mp[2] + mp[4] + 1 = 1 + 0 + 1 = 2
mp[3 - mp[2]] = mp[3 - 1] = mp[2] = 2
mp[3 + mp[3 + 1]] = mp[3 + 0] = 2

4
mp[4] = mp[3] + mp[5] + 1 = 2 + 0 + 1 = 3
mp[4 - mp[3]] = mp[4 - 2] = mp[2] = 3
mp[4 + mp[5]] = mp[4] = 3

5
mp[5] = mp[4] + mp[6] + 1 = 3 + 0 + 1 = 4
mp[5 - mp[4]] = mp[5 - 3] = mp[2] = 4
mp[5 + mp[6]] = mp[5] = 4

10
mp[10] = mp[9] + mp[11] + 1 = 0 + 0 + 1 = 1
mp[10 - mp[9]] = mp[10 - 0] = 1
mp[10 + mp[11]] = mp[10] = 1

20
mp[20] = mp[19] + mp[21] + 1 = 0 + 0 + 1 = 1
mp[20 - mp[19]] = mp[20] = 1
mp[20 + mp[21]] = mp[20] = 1

in: 2,20,4,10,3,5

m
2 4
3 3
4 3
5 4
10 1
20 1

res 4

2
m[2] = m[1] + m[3] + 1 = 0 + 0 + 1 = 1
m[2 - m[1]] = m[2] = 1
m[2 + m[3]] = m[2] = 1

20
m[20] = m[19] + m[21] + 1 = 1
m[20 - m[19]] = m[20] = 1
m[20 + m[21]] = m[20] = 1

4
m[4] = m[3] + m[5] + 1 = 0 + 0 + 1 = 1
m[4 - m[3]] = m[4] = 1
m[4 + m[5]] = m[4] = 1

10
m[10] = m[9] + m[11] + 1 = 1
m[10 - m[9]] = m[10] = 1
m[10 + m[11]] = m[10] = 1

3
m[3] = m[2] + m[4] + 1 = 1 + 1 + 1 = 3
m[3 - m[2]] = m[3 - 1] = m[2] = 3
m[3 + m[4]] = m[3 + 1] = m[4] = 3

5
m[5] = m[4] + m[6] + 1 = 3 + 0 + 1 = 4
m[5 - m[4]] = m[5 - 3] = m[2] = 4
m[5 + m[6]] = m[5] = 4
*/
