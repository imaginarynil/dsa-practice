package org.example.neetcode;

public class count_number_of_islands {
    void fill(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        fill(grid, r + 1, c);
        fill(grid, r, c + 1);
        fill(grid, r - 1, c);
        fill(grid, r, c - 1);
    }

    // t: O()
    // s: O()
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if 1, ans++
                if (grid[i][j] == '1') {
                    ans++;
                }
                // fill 1
                fill(grid, i, j);
            }
        }
        return ans;
    }

    void main() {
        char[][] g = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int ans = numIslands(g);
    }
}
