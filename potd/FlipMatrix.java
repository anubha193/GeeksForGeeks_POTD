
import java.util.*;

class FlipMatrix {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = x; i < x + k / 2; i++) {
            for (int j = y; j < y + k; j++) {
                flipValue(grid, i, j, x + k - 1 - (i - x), j);
            }
        }
        return grid;
    }

    static void flipValue(int[][] grid, int i, int j, int x, int y) {
        int temp = grid[i][j];
        grid[i][j] = grid[x][y];
        grid[x][y] = temp;
    }

    // Helper function to print matrix
    static void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FlipMatrix sol = new FlipMatrix();

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int x = 0, y = 0, k = 3;

        System.out.println("Before:");
        printMatrix(grid);

        sol.reverseSubmatrix(grid, x, y, k);

        System.out.println("\nAfter Vertical Flip:");
        printMatrix(grid);
    }
}