package Inorder;

public class No134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int sum = 0, minSum = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];

            if (sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0)
            return -1;
        return start == n ? 0 : start;
    }

    public static void main(String[] args) {
        No134 no = new No134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int res = no.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
