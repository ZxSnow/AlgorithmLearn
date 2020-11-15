package Sort.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegionMerge {
    /**
     * 合并区间
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv11yj/
     */
    public int[][] merge(int[][] intervals) {
//        int[][] sort = new int[intervals.length][2];
        List<int[]> result = new ArrayList<>();

        //对区间左端点进行排序 插入排序
        for (int i = 1; i < intervals.length; i++) {
            int j = i - 1;
            int[] temp = intervals[i];
            while (j >= 0 && temp[0] < intervals[j][0]) {
                intervals[j + 1] = intervals[j];
                j--;
            }
            intervals[j + 1] = temp;
        }
        int j = -1;
        //排序方式不正确
        for (int i = j+ 1; i < intervals.length; i++) {
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
                } else {
                    result.add(intervals[i]);
                    break;
                }
            }
        }
        int[][] res = new int[result.size()][2];
        int cnt = 0;
        for (int[] rt : result) {
            res[cnt++] = rt;
        }
        return res;
    }

    public static void main(String[] args) {
        RegionMerge rm = new RegionMerge();
        int[][] nums = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] res = rm.merge(nums);
        System.out.println(Arrays.deepToString(res));
    }
}
