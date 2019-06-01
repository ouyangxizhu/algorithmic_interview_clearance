package _07_09_stack_queue;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _08TwoZero {
    private HashMap<Character, Character> mappings;

    public _08TwoZero() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != this.mappings.get(c)) return false;
            }else
                stack.push(c);

        }
        return stack.isEmpty();

    }
}
