package Trick;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRU {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRU(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        //先删除，再放到双链表队尾
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(Node x) {
        cache.addLast(x);
        map.put(x.key, x);
    }

    private void delete(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void deleteLeastRecently() {
        Node deleteNode = cache.removeFirst();
        map.remove(deleteNode.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int k, int val) {
        if (map.containsKey(k)) {
            //存在要进行替换
            Node x = map.get(k);
            x.val = val;
            map.put(k, x);
            makeRecently(k);
            //也可以先删除，再插入
//            delete(k);
//            addRecently(x);
        } else {
            Node x = new Node(k, val);
            //不存在需要插入，在插入之前判断容量
            if (cache.size() >= cap) {
                //容量不允许，删除最久未使用的
                deleteLeastRecently();
            }
            //添加到队尾
            addRecently(x);
        }
    }

}

class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}