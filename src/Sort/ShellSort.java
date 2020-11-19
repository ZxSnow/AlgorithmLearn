package Sort;

public class ShellSort {
    public void shellSort(int[] nums) {
        int len = nums.length;
        //此时选用了固定分组的方式，第一次为每两个一组，然后是4个...最后是所有
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                //对每个分组进行插入排序
                int j = i - gap;
                int cur = nums[i];
                while (j >= 0 && cur < nums[j]) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = cur;
            }
        }
    }
}
