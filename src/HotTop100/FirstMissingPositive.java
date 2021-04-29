package HotTop100;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 1 || nums[nums.length - 1] < 0) {
            return 1;
        }
        int tmp = 1;
        boolean first = false;
        for (int i : nums) {
            if (i <= 0) {
                continue;
            }
            if (!first) {
                first = true;
                if (i > 1) {
                    return 1;
                }
                tmp = i + 1;
                continue;
            }
            if (i > tmp) {
                return tmp;
            } else {
                tmp = i + 1;
            }
        }
        return tmp;
    }

    /**
     * 官方解答，原地哈希，利用符号标记，对下标进行hash
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //通过符号进行标记
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = {3, 4, 5};
        int res = fmp.firstMissingPositive1(nums);
        System.out.println(res);
    }
}
