package Occur;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No414 {
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>(3);
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            if (list.size() < 3) {
                list.add(num);
                continue;
            }
            int min = list.get(0);
            if (num > min) {
                list.sort(Comparator.comparingInt(o -> o));
                list.remove(0);
                list.add(num);
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list.size() == 3 ? list.get(0) : list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        No414 no = new No414();
        int[] nums = {1, 2, 2, 5, 3, 5};
        int res = no.thirdMax(nums);
        System.out.println(res);
    }


}
