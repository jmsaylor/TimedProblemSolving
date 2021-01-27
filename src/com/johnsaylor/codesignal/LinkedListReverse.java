package com.johnsaylor.codesignal;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}

public class LinkedListReverse {

    public void test() {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(1);
        isListPalindrome(head);
    }

    boolean isListPalindrome(Node<Integer> l) {
        Node<Integer> prev = null;
        Node<Integer> curr = l;
        Node<Integer> next = l;


        return true;
    }
}
