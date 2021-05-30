package HotTop100;

public class Divide {

    public int divide(int dividend, int divisor) {
        boolean same = true;
        int sign = 1 << 31;
        boolean set = false;
        if ((divisor & sign) != 0) {
            same = false;
            //特殊情况判断，如果除数已经是最小，那么他的绝对值2^31一定是最大的
            //此时存在两种情况：1.被除数是正的，直接返回0 2.被除数是负的，如果相等返回1;如果不等返回0
            if (divisor == Integer.MIN_VALUE) {
                if (dividend == Integer.MIN_VALUE) {
                    return 1;
                }
                return 0;
            } else {
                divisor = -divisor;
            }
        }
        if ((dividend & sign) != 0) {
            same = !same;
            if (dividend == Integer.MIN_VALUE) {
                dividend = Integer.MAX_VALUE;
                set = true;
            } else {
                dividend = -dividend;
            }
        }
        int cnt = 0;
        while (dividend >= divisor) {
            int mul = 1;
            int tmp = divisor;
            while (tmp < (1 << 30) && (tmp << 1) <= dividend) {
                mul <<= 1;
                tmp <<= 1;
            }
            dividend -= tmp;
            cnt += mul;
            //正数溢出了
            if (cnt < 0) {
                if (same) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            //之前进行被除数变号的时候
            if (set) {
                dividend++;
                set = false;
            }
        }
        return same ? cnt : -cnt;
    }

    public int divide1(int dividend, int divisor) {
        boolean same = true;
        int sign = 1 << 31;
        //将正数变成负数
        if ((dividend & sign) == 0) {
            same = false;
            dividend = -dividend;
        }
        if ((divisor & sign) == 0) {
            same = !same;
            divisor = -divisor;
        }
        int cnt = 0;
        while (dividend <= divisor) {
            int mul = 1;
            int tmp = divisor;
            while (tmp > (-1 << 30) && (tmp << 1) >= dividend) {
                tmp <<= 1;
                mul <<= 1;
            }
            dividend -= tmp;
            cnt -= mul;
            //发生溢出
            if (cnt >= 0) {
                return same ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        if (same && cnt == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return same ? -cnt : cnt;
    }


    public static void main(String[] args) {
        Divide divide = new Divide();
        int div1 = Integer.MIN_VALUE;
        int div2 = -1;

        int res = divide.divide1(div1, div2);
        System.out.println(res);
    }
}
