package HotTop100;

public class FineMedium {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int medium = total / 2;
        boolean two = false;
        if (total % 2 == 0) {
            two = true;
            medium--;
        }
        int left1 = 0;
        int left2 = 0;
        int cnt = 0;

        int first = 0;
        int second = 0;
        while (cnt <= medium) {
            int num1 = left1 >= nums1.length ? Integer.MAX_VALUE : nums1[left1];
            int num2 = left2 >= nums2.length ? Integer.MAX_VALUE : nums2[left2];
            if (num1 < num2) {
                left1++;
            } else {
                left2++;
            }
            if (cnt == medium) {
                first = Math.min(num1, num2);
                if (two) {
                    int n1 = left1 >= nums1.length ? Integer.MAX_VALUE : nums1[left1];
                    int n2 = left2 >= nums2.length ? Integer.MAX_VALUE : nums2[left2];
                    second = Math.min(n1, n2);
                } else {
                    second = first;
                }
            }
            cnt++;
        }
        return (first + second) / 2.0;
    }

    public static void main(String[] args) {
        FineMedium fm = new FineMedium();
        int[] nums1 = {};
        int[] nums2 = {1};
        double res = fm.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
