package Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class QuickSort {
    public static void sort(int[] a, int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) {
            // 从表的两端交替向中间扫描
            //从右向左查找，找到第一个比index小的交换
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录

            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }

    public static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /* 快速排序主函数 */
    void quickSortBetter(int[] nums) {
        // 一般要在这用洗牌算法将 nums 数组打乱，
        // 以保证较高的效率，我们暂时省略这个细节
        sortBetter(nums, 0, nums.length - 1);
    }

    /* 快速排序核心逻辑 */
    void sortBetter(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        // 通过交换元素构建分界点索引 p
        int p = partition(nums, lo, hi);
        // 现在 nums[lo..p-1] 都小于 nums[p]，
        // 且 nums[p+1..hi] 都大于 nums[p]
        sortBetter(nums, lo, p - 1);
        sortBetter(nums, p + 1, hi);
    }

    int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }

    // 交换数组中的两个元素
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 常用版本
     *
     * @param nums
     */
    public void quickSortA(int[] nums) {
        sortA(nums, 0, nums.length - 1);
    }

    public void sortA(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int p = random(nums, left, right);

        sortA(nums, left, p - 1);
        sortA(nums, p + 1, right);
    }

    Random rdm = new Random();

    public int random(int[] nums, int l, int r) {
        int i = rdm.nextInt(r - l + 1) + l;
        swap(nums, l, i);
        return partitionA(nums, l, r);
    }

    public int partitionA(int[] nums, int left, int right) {
        int pivot = nums[left];
        int cnt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++cnt, i);
            }
        }
        swap(nums, left, cnt);
        return cnt;
    }

    /**
     * 非递归版本
     *
     * @param nums
     * @return
     */
    public int[] quickSortUnRecur(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(nums.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();

            if (left < right) {
                int pivotIdx = partition(nums, left, right);
                stack.push(pivotIdx - 1);
                stack.push(left);
                stack.push(right);
                stack.push(pivotIdx + 1);
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};
//        quickSort(a);
//        System.out.println(Arrays.toString(a));
        QuickSort quick = new QuickSort();
        quick.quickSortUnRecur(a);
        System.out.println(Arrays.toString(a));
    }
}
