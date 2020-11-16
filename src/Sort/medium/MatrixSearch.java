package Sort.medium;

public class MatrixSearch {
    /**
     * 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvc64r/
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        if (m < 0) {
            return false;
        }
        int n = matrix[0].length - 1;
        if (n < 0) {
            return false;
        }
        return help(matrix, target, new int[]{0, 0}, new int[]{m, n});
    }

    public boolean help(int[][] matrix, int target, int[] start, int[] end) {
        //越界
        if (start[0] >= matrix.length || start[1] >= matrix[0].length) {
            return false;
        }
        if (start == end) {
            return matrix[start[0]][start[1]] == target;
        }
        int[] check = new int[end[1] - start[1] + 1];
        int j = 0;
        for (int i = start[1]; i <= end[1]; i++) {
            check[j++] = matrix[start[0]][i];
        }
        boolean res = search(check, target);

        check = new int[end[0] - start[0] + 1];
        j = 0;
        for (int i = start[0]; i <= end[0]; i++) {
            check[j++] = matrix[i][start[1]];
        }
        boolean res1 = search(check, target);

        if (res || res1) {
            return true;
        }
        start[0]++;
        start[1]++;
        return help(matrix, target, start, end);
    }

    public boolean search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 从下向上搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                //向上
                row--;
            } else if (matrix[row][col] < target) {
                //向右
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MatrixSearch ms = new MatrixSearch();
        int[][] m = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}};
        boolean res = ms.searchMatrix(new int[][]{}, 0);
        System.out.println(res);
    }
}
