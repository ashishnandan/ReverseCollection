package com.sigmoid;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseByIndex {

    private LinkedList<Integer> linkedList;

    public ReverseByIndex(LinkedList<Integer> linkedList) {
        this.linkedList = linkedList;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public LinkedList<Integer> getSubList(int m, int n) {
        if (ReverseByIndexValidator.validate(m, n, linkedList))
            return new LinkedList<>(linkedList.subList(m, n + 1));
        throw new RuntimeException("Either Input is invalid or list is empty");
    }

    public LinkedList<Integer> reverseListByIndex(int m, int n){
        LinkedList<Integer> subList = getSubList(m, n);
        Stack<Integer> stack = new Stack<>();
        for (int val : subList){
            stack.push(val);
        }

        LinkedList<Integer> reverseList = new LinkedList<>();

        while (!stack.empty()){
            reverseList.add(stack.pop());
        }

        return reverseList;
    }

    public void reverse(int m, int n) {
        LinkedList<Integer> subList = reverseListByIndex(m, n);

        for (int i = m; i < n + 1; i++){
            linkedList.remove(i);
            linkedList.add(i, subList.get(i - m));
        }
    }
}
