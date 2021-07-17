package Trick;

public class SearchTreePT {
    /**
     * 判断一个数组是否是二叉搜索树的后序遍历
     * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     */
    public boolean verifySequenceBST(int[] nums, int low, int high) {
        if (high - low < 0) {
            return false;
        }
        if (high == low)
            return true;
        int root = nums[high];
        int i = low;

        while (nums[i] < root)
            i++;

        for (int j = i; j < high; j++) {
            if (nums[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = verifySequenceBST(nums, 0, i - 1);
        }

        boolean right = true;
        if (i < high)
            right = verifySequenceBST(nums, i, high - 1);

        return (left && right);
    }

    public static void main(String[] args) {
        SearchTreePT st = new SearchTreePT();
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        boolean flag = st.verifySequenceBST(arr, 0, arr.length - 1);
        System.out.println(flag);
    }
}
