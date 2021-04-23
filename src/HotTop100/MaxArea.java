package HotTop100;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        for (int i = left; i < right; i++) {

        }
        return max;
    }
}
