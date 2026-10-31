package org.example.neetcode;

public class search_2d_matrix {
    // time: O(log(m * n)), space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int low = 0;
        int high = rowCount * colCount - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / colCount;
            int col = mid % colCount;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    void main() {
//        int[][] mat = {
//                {1,2,4,8},
//                {10,11,12,13},
//                {14,20,30,40}
//        };
        int[][] mat = {
                {1, 3, 6},
                {9, 12, 15},
                {18, 21, 24}
        };
        var x = searchMatrix(mat, 12);
    }
}
