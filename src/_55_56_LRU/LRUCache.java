package _55_56_LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    Map<Integer, Integer> map;
    Stack<Integer> stack;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>(capacity);
        stack = new Stack<Integer>();
        size = capacity;

    }

    public int get(int key) {
        if (stack.contains(key)) {
            stack.remove(Integer.valueOf(key));
            stack.push(key);
            return map.get(key);
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (stack.contains(key)) {
            stack.remove(Integer.valueOf(key));
        }else {
            if (stack.size()==size) {
                stack.remove(0);
                map.remove(key);
            }
        }
        stack.push(Integer.valueOf(key));
        map.put(key, value);
    }
}
