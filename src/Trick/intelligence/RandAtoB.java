package Trick.intelligence;

public class RandAtoB {
    /**
     * 已知randA(), 利用randA()给出RandB()
     * (例：已知rand5，求出等概率的rand7)
     * 基于这样一个事实 (randX() - 1) * Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
     */
    public int rand5() {
        return (int) (1 + Math.random() * 5);
    }

    public int rand25() {
        return 5 * (rand5() - 1) + rand5();
    }

    public int rand7() {
        int x = 22;
        while (x > 21) {
            x = rand25();
        }
        return x % 7 + 1;
    }
}
