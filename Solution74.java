// Leetcode 74: Search a 2D Matrix
import java.util.*;

public class Solution74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,   3,  5,  7}, {10, 11, 16, 20},{23, 30, 34, 50}};
        int target = 13;

        Solution74 sol = new Solution74();
        boolean res = sol.searchMatrix(matrix, target);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // TC:O(m + n), SC:O(1)
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        //     return false;
        // }

        // int row = matrix.length, col = matrix[0].length;
        // int currow = 0, curcol = 0;
        // while (currow < row && curcol < col) {
        //     if (matrix[currow][curcol] == target) {
        //         return true;
        //     } else if (currow < row - 1 && matrix[currow + 1][curcol] > target) {
        //         curcol++;
        //     } else if (currow < row - 1 && matrix[currow + 1][curcol] <= target) {
        //         currow++;
        //     } else {
        //         curcol++;
        //     }
        // }
        // return false;

        // Binary search: TC:O(log(m*n)), SC:O(1)
        if (matrix.length == 0)  return false;
        int M = matrix.length, N = matrix[0].length;
        int l = 0, r = M*N-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            int m_row = m/N, m_col = m%N;
            if (matrix[m_row][m_col] == target) {
                return true;
            } else if (matrix[m_row][m_col] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}