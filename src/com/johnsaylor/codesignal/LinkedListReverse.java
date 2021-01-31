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
        Node<Integer> head = new Node<>(3);
        head.next = new Node<>(5);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(5);
        head.next.next.next.next = new Node<>(1000000000);
//        head.next.next.next.next.next = new Node<>(1);

        System.out.println(isListPalindromeCS(head));
    }

    boolean isListPalindromeCS(Node<Integer> l) {
        if (l == null) return true;
        Node<Integer> fast = l;
        Node<Integer> slow = l;

        Node<Integer> prev = null;
        Node<Integer> curr = slow;
        Node<Integer> foll = slow;

        boolean isEven = false;

        while(fast.next != null) {
//            System.out.println(fast.value);
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                isEven = true;
                fast = fast.next;
            }

            slow = slow.next;
            //reverse
            foll = foll.next;
            curr.next = prev;
            prev = curr;
            curr = foll;
        }

        Node<Integer> second = isEven ? slow : slow.next;
        Node<Integer> first = prev;

        print(first);
        System.out.println();
        print(second);
        System.out.println();

        while (first != null && second != null) {
            System.out.println(first.value + " " + second.value);
            if (!first.value.equals(second.value)) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    boolean isListPalindrome(Node<Integer> l) {
        Node<Integer> first = l;
        Node<Integer> second = reverse(findHalf(l));

        while (first != null && second != null) {
            System.out.println(first.value + " - " + second.value);
            if (first.value != second.value) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public Node<Integer> findHalf(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != null) {
            if (fast.next.next != null) {
                // fast jumps two, slow one
                fast = fast.next.next;
                slow = slow.next;
            } else {
                // fast jumps one, slow stop
                fast = fast.next;
            }
//            System.out.println(slow.value + " " + fast.value);
        }

        Node<Integer> halfHead = slow.next;
        slow.next = null;

        return halfHead;
    }

    public Node<Integer> reverse(Node<Integer> l) {
        Node<Integer> previous = null;
        Node<Integer> current = l;
        Node<Integer> following = l;

        while (current != null) {
            following = following.next;
            current.next = previous;
            previous = current;
            current = following;
        }

        return previous;
    }

    public void print(Node<Integer> head) {
        if (head == null) return;
        System.out.print(head.value + "  ");
        print(head.next);
    }

}

