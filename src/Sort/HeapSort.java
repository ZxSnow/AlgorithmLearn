package Sort;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] nums) {
        //将待排序的序列构建成一个大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = nums.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(nums, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(nums, 0, i);
        }
    }

    /**
     * 堆构建
     *
     * @param nums
     * @param i    需要构建堆的根节点idx
     * @param n    数组的长度
     */
    public void heapAdjust(int[] nums, int i, int n) {
        int child;
        int father;
        for (father = nums[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            //如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && nums[child] < nums[child + 1]) {
                child++;
            }
            //如果父节点小于孩子节点，需要交换
            if (father < nums[child]) {
                nums[i] = nums[child];
            } else {
                //大顶堆结构未被破坏
                break;
            }
        }
        nums[i] = father;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }


    public int leftChild(int i) {
        return 2 * i + 1;
    }


    public void build(int[] nums) {
        int last = nums.length - 1;
        int father = (last - 1) / 2;
        while (father >= 0) {
            treeify(nums, father--, last + 1);
        }
    }

    public void treeify(int[] nums, int i, int size) {
        if (i >= size) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;
        if (left < size && nums[left] > nums[max])
            max = left;
        if (right < size && nums[right] > nums[max])
            max = right;
        if (max != i) {
            swap(nums, i, max);
            treeify(nums, max, size);
        }
    }

    public void heapSort2(int[] nums) {
        build(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            treeify(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        HeapSort hs = new HeapSort();
        // 堆排序
        hs.heapSort2(arr);
        System.out.println(Arrays.toString(arr));

    }
}
