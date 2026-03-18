public class CountSubmatricesWithSumLessThanOrEqualToK {

    static class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int n = grid.length;
            int m = grid[0].length;

            int[][] prefixSum = new int[n][m];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    prefixSum[i][j] = grid[i][j];

                    if (i > 0) prefixSum[i][j] += prefixSum[i - 1][j];
                    if (j > 0) prefixSum[i][j] += prefixSum[i][j - 1];
                    if (i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i - 1][j - 1];

                    if (prefixSum[i][j] <= k) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
            {7, 6, 3},
            {6, 6, 1}
        };

        int k = 18;

        Solution sol = new Solution();
        int result = sol.countSubmatrices(grid, k);

        System.out.println("Number of valid submatrices: " + result);
    }
}

/*
Problem: 3070. Count Submatrices with Top-Left Element and Sum Less Than k

Description:
Given a 0-indexed integer matrix `grid` and an integer `k`, the task is to count 
the number of submatrices that include the top-left element (0,0) and whose sum 
of elements is less than or equal to `k`.

Approach:
Since every valid submatrix must start from the top-left corner (0,0), each 
submatrix can be represented by its bottom-right corner (i, j).

We compute a 2D prefix sum where:
prefixSum[i][j] represents the sum of all elements in the rectangle 
from (0,0) to (i,j).

Formula used:
prefixSum[i][j] = grid[i][j]
                + prefixSum[i-1][j]
                + prefixSum[i][j-1]
                - prefixSum[i-1][j-1]

For each cell (i, j), if prefixSum[i][j] <= k, it means the submatrix 
from (0,0) to (i,j) satisfies the condition, so we increment the count.

Time Complexity: O(n * m)
Space Complexity: O(n * m)

Author: Anubha Rajput
*/
