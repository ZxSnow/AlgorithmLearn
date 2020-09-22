package Sort;

public class Practice2 {
    /**
     * 第一个错误的版本
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/
     */
    public int firstBadVersion(int n) {
        while (n > 0) {
            if (!isBadVersion(n - 1)) {
                return n;
            }
            n--;
        }
        return 0;
    }

    public int fistBadVersionV2(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean flag = isBadVersion(mid + 1);
            if (flag) {
                right = mid - 1;
                if (mid - 1 >= 0) {
                    if (!isBadVersion(mid)) {
                        return mid + 1;
                    }
                }
            } else {
                left = mid + 1;
                if (mid + 1 < n) {
                    if (isBadVersion(mid + 2)) {
                        return mid + 2;
                    }
                }
            }
        }
        return 0;
    }

    boolean isBadVersion(int version) {
        return version == 1;
    }
}
