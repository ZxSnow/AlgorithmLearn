package Trick;

import java.util.PriorityQueue;

/**
 * 用PriorityQueue实现最大最小堆: 剑指offer(41) 数据流中的中位数
 * https://www.cnblogs.com/yongh/p/9945539.html
 */
public class StreamMedian {
    //小顶堆，默认容量为11
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    //大顶堆，容量11
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);

    public void insert(Integer num) {
        //偶数时,下个数字加入小顶堆
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {//奇数时，下一个数字放入大顶堆
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double getMedian() {
        if ((minHeap.size() + maxHeap.size()) == 0)
            throw new RuntimeException();
        double median;
        if ((minHeap.size() + maxHeap.size() & 1) == 0) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            median = minHeap.peek();
        }
        return median;
    }



    public static void main(String[] args) {
        StreamMedian sm = new StreamMedian();
        int[] nums = {12, 23, 34, 25, 451, 13};
        for (int i : nums) {
            sm.insert(i);
        }
    }
}