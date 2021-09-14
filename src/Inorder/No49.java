package Inorder;


import java.util.*;

public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = Arrays.toString(c);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> ll = new ArrayList<>();
                ll.add(s);
                map.put(key, ll);
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        No49 no = new No49();
        String[] ss = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = no.groupAnagrams(ss);
        System.out.println(res);
    }
}
