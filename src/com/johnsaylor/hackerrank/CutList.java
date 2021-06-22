package com.johnsaylor.hackerrank;

public class CutList {

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);

        Node trav = head;

        for (int i = 0; i < 1000; i++) {
            trav.next = new Node(i);
            trav = trav.next;
        }

        //-------------------

        long start = System.nanoTime();

        Node removed = removeDuplicatesIterative(head);

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start));

        //-------------------

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static Node removeDuplicates2Pointers(Node head) {
        Node pointer1 = head;
        Node pointer2 = head.next;

        while (pointer2 != null) {
            if (pointer1.value != pointer2.value) {
                pointer1.next = pointer2;
                pointer1 = pointer2;
            }
            pointer2 = pointer2.next;
        }

        pointer1.next = null;

        return head;
    }

    public static Node removeDuplicatesRecursive(Node head) {
        if (head.next == null) return head;

        if (head.value == head.next.value) {
            head.next = head.next.next;
            removeDuplicatesRecursive(head);
        } else {
            removeDuplicatesRecursive(head.next);
        }

        return head;
    }

    public static Node removeDuplicatesIterative(Node head) {

        Node marker = head;

        while (head.next != null) {
            if (head.value == head.next.value) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        head.next = null;

        return marker;
    }

}
