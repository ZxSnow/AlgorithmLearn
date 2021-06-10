package HotTop100;

public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = help(res);
            System.out.println(res);
        }
        return res;
    }

    public String help(String s) {
        String res = "";
        int i = 0;
        while (i < s.length()) {
            int cnt = 0;
            char keep = s.charAt(i);
            while (i < s.length() && s.charAt(i) == keep) {
                i++;
                cnt++;
            }
            res += cnt + "" + keep;
        }
        return res;
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();

        String res = cas.countAndSay(4);
        System.out.println(res);
    }
}
