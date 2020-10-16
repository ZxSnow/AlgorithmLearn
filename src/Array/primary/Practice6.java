package Array.primary;

import java.util.Arrays;

public class Practice6 {
    /**
     * 题目：两个数组的交集（二）
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例：
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * <p>
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 先排序，后比较，设定i,temp为两个数组的位置指针，通过下移指针的方式，比较数组的值。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        int i;
        int temp = 0;
        for (i = 0; i < nums1.length; i++) {
            for (int j = temp; j < nums2.length; j++) {
                if (nums2[j] < nums1[i]) {
                    temp++;
                } else if (nums1[i] == nums2[j]) {
                    result[count++] = nums1[i];
                    temp++;
                    break;
                } else {
                    break;
                }
            }
        }
        int[] rs = new int[count];
        System.arraycopy(result, 0, rs, 0, count);
        return rs;
    }
}
