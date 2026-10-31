package org.example.usaco;

import java.util.ArrayList;
import java.util.Scanner;

public class milk_pails {
    int ans = 0;

    int getSum(ArrayList<Integer> arr) {
        int n = 0;
        for (int i : arr) {
            n += i;
        }
        return n;
    }

    void solve(ArrayList<Integer> arr, int x, int y, int m) {
        if (m < 0) {
            // pop last
            ArrayList<Integer> arr2 = new ArrayList<>(arr);
            arr2.removeLast();
            ans = Math.max(ans, getSum(arr2));
            return;
        }
        if (m == 0) {
            ans = Math.max(ans, getSum(arr));
            return;
        }
        arr.add(x);
        solve(arr, x, y, m - x);
        arr.removeLast();
        arr.add(y);
        solve(arr, x, y, m - y);
        arr.removeLast();
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int x, y, m;
        x = sc.nextInt();
        y = sc.nextInt();
        m = sc.nextInt();
        int ans = 0;
        for (int first = 0; first <= m; first++) {
            for (int second = 0; second <= m; second++) {
                int n = x * first + y * second;
                if (n > m) {
                    break;
                }
                ans = Math.max(ans, n);
            }
        }
        System.out.println(ans);
    }
}
