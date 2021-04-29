package HotTop100;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            while (low < nums.length && nums[low] != val) {
                low++;
            }
            while (high >= 0 && nums[high] == val) {
                high--;
            }
            //发生交换
            if (low < nums.length && high >= 0 && low < high) {
                nums[low] = nums[high];
                nums[high] = val;
                low++;
                high--;
            } else {
                //越界
                break;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int res = re.removeElement(nums, 2);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
