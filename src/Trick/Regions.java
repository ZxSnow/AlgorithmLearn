package Trick;

import java.util.Arrays;

public class Regions {
    /**
     * 删除被覆盖区间
     *
     * @param intvs
     * @return 返回剩余区间数目（总长度 - 被覆盖区间个数）
     */
    int removeCoveredIntervals(int[][] intvs) {
        //左区间升序，右区间降序
        Arrays.sort(intvs, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intvs[0][0];
        int right = intvs[0][1];
        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            int[] cur = intvs[i];
            if (left <= cur[0] && cur[1] <= right) {
                //区间覆盖,情况1：  --------
                //                  ----
                res++;
            }
            if (right >= cur[0] && cur[1] >= right) {
                //区间合并,情况2：  ------
                //                   ------
                right = cur[1];
            }
            if (right < cur[0]) {
                //完全不想交,情况3：  ------
                //                          ------
                left = cur[0];
                right = cur[1];
            }
        }
        return intvs.length - res;

    }
}
