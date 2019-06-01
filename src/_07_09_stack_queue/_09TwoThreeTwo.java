package _07_09_stack_queue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _09TwoThreeTwo {
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public _09TwoThreeTwo() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    public void trans(){
        while (!input.isEmpty()) output.push(input.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.isEmpty()){
            trans();
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.isEmpty()){
            trans();
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
