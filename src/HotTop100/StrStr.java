package HotTop100;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int res = -1;
        int idx = 0;
        while (idx < haystack.length()) {
            idx = search(haystack, needle.charAt(0), idx);
            if (idx > haystack.length() - 1) {
                return -1;
            }
            int tmp = idx;
            boolean flag = false;
            for (int i = 1; i < needle.length(); i++) {
                idx++;
                if (idx >= haystack.length()) {
                    return -1;
                }
                if (needle.charAt(i) == haystack.charAt(idx)) {
                    continue;
                }
                flag = true;
                break;
            }
            if (!flag) {
                return tmp;
            }
            idx = tmp + 1;
        }
        return res;
    }

    public int search(String s, char c, int idx) {
        int cnt = idx;
        while (cnt < s.length()) {
            if (s.charAt(cnt) != c) {
                cnt++;
                continue;
            }
            return cnt;
        }
        return cnt;
    }

    public int strStr1(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        int hk = 0;
        while (hk < len1) {
            if (haystack.charAt(hk) == needle.charAt(0)) {
                if (len1 - hk < len2) {
                    return -1;
                }
                String sub = haystack.substring(hk, hk + len2);
                if (sub.equals(needle)) {
                    return hk;
                }
            }
            hk++;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        //构建KMP数组
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "mississippi";
        String n = "issip";
        StrStr ss = new StrStr();
        int res = ss.strStr2(h, n);
        System.out.println(res);
    }
}
