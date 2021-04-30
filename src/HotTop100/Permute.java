package HotTop100;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        back(new ArrayList<>(), nums);
        return res;
    }

    List<List<Integer>> res;

    public void back(List<Integer> path, int[] choice) {
        if (path.size() == choice.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int value : choice) {
            if (path.contains(value)) {
                continue;
            }
            path.add(value);
            int len = path.size();
            back(path, choice);
            path.remove(len - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permute p = new Permute();
        List<List<Integer>> res = p.permute(nums);

        System.out.println(res);
    }
}
