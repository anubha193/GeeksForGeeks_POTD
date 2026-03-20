
import java.util.*;

public class subMatrixofkXkWithMinimumDiff {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                ArrayList<Integer> arr = new ArrayList<>();

                // collect k x k submatrix
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        arr.add(grid[x][y]);
                    }
                }

                Collections.sort(arr);

                int min = Integer.MAX_VALUE;

                // find minimum absolute difference
                for (int t = 1; t < arr.size(); t++) {
                    if (!arr.get(t).equals(arr.get(t - 1))) {
                        min = Math.min(min, arr.get(t) - arr.get(t - 1));
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    ans[i][j] = min;
                }
            }
        }

        return ans;
    }

    // Driver code for testing
    public static void main(String[] args) {
        subMatrixofkXkWithMinimumDiff sol = new subMatrixofkXkWithMinimumDiff();

        int[][] grid = {
            {1, -2, 3},
            {2, 3, 5}
        };
        int k = 2;

        int[][] result = sol.minAbsDiff(grid, k);

        // print result
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
