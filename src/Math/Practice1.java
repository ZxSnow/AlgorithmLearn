package Math;

import java.util.ArrayList;
import java.util.List;

public class Practice1 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String res = "";
            if (i % 3 == 0) {
                res += "Fizz";
            }
            if (i % 5 == 0) {
                res += "Buzz";
            }
            if ("".equals(res)) {
                res += i;
            }
            list.add(res);
        }

        return list;
    }

    public static void main(String[] args) {
        Practice1 p = new Practice1();
        p.fizzBuzz(3);
    }
}
