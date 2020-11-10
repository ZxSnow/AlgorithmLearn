package Array.medium;

public class IncreaseTriplet {

    /**
     * 找两个较小的值
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        IncreaseTriplet it = new IncreaseTriplet();
//        int[] nums = {1, 1, -2, 6};
//        boolean res = it.increasingTriplet(nums);
//        System.out.println(res);
        int a = -3;
        int b = 2;
        System.out.println(a|b);
    }
}
