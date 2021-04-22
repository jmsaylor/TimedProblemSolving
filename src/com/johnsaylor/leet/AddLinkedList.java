package com.johnsaylor.leet;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class AddLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode first = head;


        ListNode left = l1;
        ListNode right = l2;

        int remainder = 0;

        while (left != null || right != null || remainder > 0) {
            int leftVal = left == null ? 0 : left.val;
            int rightVal = right == null ? 0 : right.val;
            int value = leftVal + rightVal + remainder;
            if ( value > 9) {
                head.next = new ListNode(value % 10);
                remainder = value / 10;
            } else {
                head.next = new ListNode(value);
                remainder = 0;
            }
            head = head.next;
            left = left == null ? null : left.next;
            right = right == null ? null : right.next;
        }

        return first.next;

    }
}
