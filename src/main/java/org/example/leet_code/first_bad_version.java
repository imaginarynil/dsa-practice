package org.example.leet_code;

public class first_bad_version {
    int firstBad = 4;

    boolean isBadVersion(int x) {
        return x >= firstBad;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int result = -1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                result = mid;
                end = mid;
            }
            if(!isBadVersion(mid)) {
                start = mid + 1;
            }
        }
        return result;
    }

    public int firstBadVersion_Optimal(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    void main() {
        int x;

//        firstBad = 4;
//        x = firstBadVersion(5);

        firstBad = 1;
        x = firstBadVersion(5);
    }
}
