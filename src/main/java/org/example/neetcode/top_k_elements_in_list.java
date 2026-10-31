package org.example.neetcode;

import java.util.*;

public class top_k_elements_in_list {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else {
                m.put(num, m.get(num) + 1);
            }
        }
        ArrayList<ArrayList<Integer>> f = new ArrayList<>();
        for (Integer n : m.keySet()) {
            f.add(new ArrayList<>(Arrays.asList(m.get(n), n)));
        }
        Collections.sort(f, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
                return Integer.compare(arr2.get(0), arr1.get(0));
            }
        });
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < k && i < f.size(); i++) {
            tmp.add(f.get(i).get(1));
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    void main() {
//        var x = topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2); // [2,3]
        var x = topKFrequent(new int[]{7, 7}, 1); // [7]
    }
}
