import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    class DoubleLinkedNode {
        int k, v;
        DoubleLinkedNode prev, next;

        DoubleLinkedNode(int key, int value) {
            k = key;
            v = value;
            prev = next = null;
        }
    }

    private HashMap<Integer, DoubleLinkedNode> map;
    private DoubleLinkedNode head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<Integer, DoubleLinkedNode>(capacity);
        head = tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode n = map.get(key);
            moveToEnd(n);
            return n.v;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (head == null) {
            DoubleLinkedNode n = new DoubleLinkedNode(key, value);
            head = tail = n;
            map.put(key, n);
            size++;
        } else if (map.containsKey(key)) {
            DoubleLinkedNode n = map.get(key);
            n.v = value;
            map.put(key, n);
            moveToEnd(n);
        } else {
            DoubleLinkedNode n = new DoubleLinkedNode(key, value);
            if (size >= capacity) {
                //remove least recent accessed item which is the first
                if (size == 1) {
                    head = tail = n;
                    map.clear();
                    map.put(key, n);
                    return;
                } else {
                    map.remove(Integer.valueOf(head.k));
                    head = head.next;
                    head.prev = null;
                    size--;
                }
            }
            //append new node to last
            tail.next = n;
            n.prev = tail;
            tail = n;
            map.put(key, n);
            size++;
        }
    }

    private void moveToEnd(DoubleLinkedNode node) {
        if (node != null && node.next != null) {
            if (node == head) {
                head = head.next;
                head.prev = null;
                tail.next = node;
                node.prev = tail;
                tail = node;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        }
    }
}
