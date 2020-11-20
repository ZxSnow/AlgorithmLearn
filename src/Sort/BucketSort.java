package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int item : nums) {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }
        //桶数
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        //创建这么多个桶
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        //将元素放到桶里
        for (int value : nums) {
            int num = (value - min) / nums.length;
            buckets.get(num).add(value);
        }
        for (List<Integer> bucket : buckets) {
            //对每个桶进行排序
            // TODO 可以使用其他排序算法
            Collections.sort(bucket);
        }
    }
}
