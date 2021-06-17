package HotTop100;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
//        help(new ArrayList<>(), target, candidates);
        improve(new ArrayList<>(), target, candidates, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    Map<String, String> memo = new HashMap<>();

    public void help(List<Integer> path, int left, int[] choices) {
        if (left == 0) {
            List<Integer> list = new ArrayList<>(path);
            list.sort((n1, n2) -> n1 - n2);
//            list.sort(Comparator.comparingInt(a -> a));
            if (!memo.containsKey(list.toString())) {
                memo.put(list.toString(), "");
                res.add(list);
            }
            return;
        }

        for (int ch : choices) {
            if (ch > left) {
                continue;
            }
            path.add(ch);
            int idx = path.size();

            help(path, left - ch, choices);

            path.remove(idx - 1);
        }
    }

    public void improve(List<Integer> path, int left, int[] choices, int begin) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < choices.length; i++) {
            int cur = choices[i];
            if (cur > left) {
                return;
            }
            path.add(cur);
            int idx = path.size();

            improve(path, left - cur, choices, i);

            path.remove(idx - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(new ArrayList<>(), target, candidates, 0);
        return res;
    }

    public void help(List<Integer> path, int left, int[] choices, int begin) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        Integer last = -1;
        for (int i = begin; i < choices.length; i++) {
            if (last == choices[i] || choices[i] > left) {
                continue;
            }
            path.add(choices[i]);
            int idx = path.size();

            help(path, left - choices[i], choices, i + 1);

            last = path.remove(idx - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> re = cs.combinationSum2(nums, 8);
        System.out.println(re);
    }
}
