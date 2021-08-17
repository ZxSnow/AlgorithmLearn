package Trick;

import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {
    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487414&idx=1&sn=2be87c0c9279da447f8ac8b8406230fe&chksm=9bd7f1beaca078a865357f58ba2ff12b46490b0a773c0221e0a846c67950fa9c661664ad500e&scene=21#wechat_redirect
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();
    //    List<Integer> nums = new ArrayList<>();
    Integer[] nums;
    int size = 0;

    public boolean insert(int val) {
        // 若 val 已存在，不用再插入
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 若 val 不存在，插入到 nums 尾部，
        // 并记录 val 对应的索引值
        valToIndex.put(val, size);
        nums[size++] = val;
        return true;
    }

//    public boolean remove(int val) {
//        // 若 val 不存在，不用再删除
//        if (!valToIndex.containsKey(val)) {
//            return false;
//        }
//        // 先拿到 val 的索引
//        int index = valToIndex.get(val);
//        // 将最后一个元素对应的索引修改为 index
//        valToIndex.put(nums[size - 1], index);
//        // todo 交换 val 和最后一个元素
//
//        //Utils.swap(nums, index, nums.size() - 1);
//        // 在数组中删除元素 val
//        nums.remove(nums.size() - 1);
//        // 删除元素 val 对应的索引
//        valToIndex.remove(val);
//        return true;
//    }
}
