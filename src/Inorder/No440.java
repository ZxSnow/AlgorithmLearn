package Inorder;

public class No440 {
    /**
     * 字典序的第K小数字
     * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        //第一字典序小的(就是1)
        int cur = 1;
        // 前缀从1开始
        int prefix = 1;
        while (cur < k) {
            int cnt = count(n, prefix); //当前prefix峰的值
            if (cnt + cur > k) {// 找到了
                prefix *= 10; //往下层遍历
                cur++;//一直遍历到第K个推出循环
            } else {
                prefix++;//去下个峰头(前缀)遍历
                cur += cnt;//跨过了一个峰(前缀)
            }
        }//退出循环时 cur==k 正好找到
        return prefix;
    }

    private int count(int n, int prefix) {
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        long cur = prefix;
        //下一个前缀峰头
        long next = cur + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;//下一峰头减去此峰头
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            cur *= 10;
            next *= 10; //往下层走
        }
        return count;
    }

    public static void main(String[] args) {
        No440 no = new No440();
        int res = no.findKthNumber(13, 2);
        System.out.println(res);
    }
}
