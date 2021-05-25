package Trick;

public class FastPower {
    //快速幂
    public static int pow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0) result *= a;
            a *= a;
            b >>= 1;
            System.out.println(b);
        }
        return result;
    }


    public static int[][] multiply(int[][] num1, int[][] num2) {
        int[][] res = new int[num1.length][num2[0].length];
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2[0].length; j++) {
                for (int k = 0; k < num1[0].length; k++) {
                    res[i][j] += num1[i][k] * num2[k][j];
                }
            }
        }
        return res;
    }

    public static int[][] quick(int[][] num1, int n) {
        //构造单位矩阵
        int[][] num2 = new int[num1[0].length][num1[0].length];
        for (int i = 0; i < num1.length; i++) {
            num1[i][i] = 1;
        }

        int[][] res = new int[num1.length][num1[0].length];
        while (n > 0) {
            if ((n & 1) == 1) res = multiply(num1, num2);
            num1 = multiply(num1, num1);
            n >>= 1;
        }
        return res;
    }
}
