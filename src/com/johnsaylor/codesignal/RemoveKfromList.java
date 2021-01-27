package com.johnsaylor.codesignal;

class ListNode<T> {
    T value;
    ListNode<T> next;
}

public class RemoveKfromList {
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        if (l == null) return null;
        ListNode<Integer> head = l;
        while (l.value == k) {
            if (l.next == null) return null;
            head = l.next;
            l = l.next;
        }

        ListNode<Integer> prev = head;

        while(l.next != null) {
            l = l.next;
            if (l.value == k) {
                prev.next = l.next;

            } else {
                prev = l;
            }
        }

        return head;
    }
}
