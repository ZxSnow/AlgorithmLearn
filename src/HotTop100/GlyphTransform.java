package HotTop100;

import java.util.ArrayList;
import java.util.List;

public class GlyphTransform {
    public String convert(String s, int numRows) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        //为true 从0 -> numRows false numRows -> 0
        boolean flag = true;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(cnt).add(s.substring(i, i + 1));
            if (flag) {
                cnt++;
                if (cnt == numRows) {
                    flag = false;
                    cnt = Math.max(cnt - 2, 0);
                }
            } else {
                cnt--;
                if (cnt == -1) {
                    flag = true;
                    cnt = Math.min(cnt + 2, numRows - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> li : list) {
            for (String ss : li) {
                sb.append(ss);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GlyphTransform gt = new GlyphTransform();
        String ss = "abc";
        String res = gt.convert(ss, 1);
        System.out.println(res);
    }
}
