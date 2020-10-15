package Design;

import java.util.Random;

public class Practice1 {
    private int[] nums;

    public Practice1(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();

        return nums;
    }
}
