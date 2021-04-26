package HotTop100;

public class MyPow {
    public double myPow1(double x, int n) {
        boolean sign = false;
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            sign = true;
            n = -n;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        if (sign) {
            res = 1 / res;
        }
        return res;
    }

    public double myPow(double x, int n) {
        long tn = n;
        return n >= 0 ? quickPow(x, tn) : 1.0 / quickPow(x, -tn);
    }

    public double quickPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double tmp = quickPow(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }

    public static void main(String[] args) {
        MyPow mp = new MyPow();
//        double res = mp.myPow(2,-2);
//        System.out.println(res);
    }
}
