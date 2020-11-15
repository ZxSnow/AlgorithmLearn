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
        List<int[]> result = new ArrayList<>();
        //Todo  可以通过改用快排的方式提高速度
        //插入排序
        for (int i = 1; i < intervals.length; i++) {
            int j = i - 1;
            int[] temp = intervals[i];
            while (j >= 0 && temp[0] < intervals[j][0]) {
                intervals[j + 1] = intervals[j];
                j--;
            }
            intervals[j + 1] = temp;
        }
        int i = 0;
        while (i < intervals.length) {
            int j = i;
            while (j <= intervals.length) {
                if (j < intervals.length && intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
                    j++;
                } else {
                    result.add(intervals[i]);
                    i = j;
                    break;
                }
            }
            if (j >= intervals.length) {
                break;
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
        int[][] nums = {{2, 6}, {1, 3}};
        int[][] res = rm.merge(nums);
        System.out.println(Arrays.deepToString(res));
    }
}
