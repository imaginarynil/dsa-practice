package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class anagram_groups {
    public int[] getFreq(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        return freq;
    }

    public boolean isAnagram(int[] freq1, int[] freq2) {
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public int getIndexInFreqs(ArrayList<int[]> freqs, int[] freq) {
        for (int i = 0; i < freqs.size(); i++) {
            if (isAnagram(freqs.get(i), freq)) {
                return i;
            }
        }
        return -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 1) {
            ArrayList<String> newGroup = new ArrayList<>();
            newGroup.add(strs[0]);
            res.add(newGroup);
            return res;
        }
        ArrayList<int[]> freqs = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] currFreq = getFreq(strs[i]);
            int idx = getIndexInFreqs(freqs, currFreq);
            // if new freq table, add table to freqs, add str to a new group, index as id
            if (idx == -1) {
                freqs.add(currFreq);
                ArrayList<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                res.add(newGroup);
            }
            // is an anagram, add to the existing group
            else {
                res.get(idx).add(strs[i]);
            }
        }
        return res;
    }

    void main() {
        String[] in = {"act", "pots", "tops", "cat", "stop", "hat"};
//        String[] in = {"x"};
//        String[] in = {};
        var x = groupAnagrams(in);
    }
}
