package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
    int VISITED_VAL = 101;

    boolean isValid(int[][] matrix, int rowCount, int colCount, int r, int c) {
        return r >= 0 && r < rowCount && c >= 0 && c < colCount && matrix[r][c] != VISITED_VAL;
    }

    public List<Integer> spiralOrder_Solution2(int[][] matrix) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        List<Integer> res = new ArrayList<>();
        int r = 0;
        int c = 0;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int d = 0;
        int i = 0;
        while (i < rowCount * colCount) {
            res.add(matrix[r][c]);
            matrix[r][c] = VISITED_VAL;
            if (!isValid(matrix, rowCount, colCount, r + dir[d][0], c + dir[d][1])) {
                d = (d + 1) % 4;
            }
            r += dir[d][0];
            c += dir[d][1];
            i++;
        }
        return res;
    }

    // t: O()
    // s: O()
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    void main() {
//        int[][] mat = {{1,2}, {3,4}};
//        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> res = spiralOrder(mat);
    }
}
