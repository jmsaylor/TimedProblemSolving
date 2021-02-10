package com.johnsaylor.codesignal;

public class TwoHugeNumbers {
     class ListNode<T> {
        public ListNode(T x) {
        value = x;
        }
        T value;
        ListNode<T> next;
    }

    public void test(){
         ListNode<Integer> a = new ListNode<>(9876);
         a.next = new ListNode<>(5432);
         a.next.next = new ListNode<>(1999);

         ListNode<Integer> b = new ListNode<>(1);
         b.next = new ListNode<>(8001);
         b.next.next = new ListNode<>(7432);
         b.next.next.next = new ListNode<>(4889);

        addTwoHugeNumbers(a, b);
    }

    public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        StringBuilder aString = new StringBuilder();
        StringBuilder bString = new StringBuilder();

        // convert huge numbers into strings
        while (a != null) {
            if (aString.length() == 0) aString.append(a.value);
            else {
                StringBuilder temp = new StringBuilder(String.valueOf(a.value));
                int zeros = 4 - temp.length();
                for (int i = 0; i < zeros; i++) temp.insert(0, "0");
                aString.append(temp.toString());
            }
            a = a.next;
        }

        while (b != null) {
            if (bString.length() == 0) bString.append(b.value);
            else {
                StringBuilder temp = new StringBuilder(String.valueOf(b.value));
                int zeros = 4 - temp.length();
                for (int i = 0; i < zeros; i++) temp.insert(0, "0");
                bString.append(temp.toString());
            }
            b = b.next;
        }


        // add them up (as strings)
        StringBuilder result = new StringBuilder();

        int remainder = 0;

        aString = aString.reverse();
        bString = bString.reverse();

        for (int index = 0; index < Math.max(aString.length(), bString.length()); index++) {
            int aNum = index < aString.length() ? Integer.parseInt(String.valueOf(aString.charAt(index))) : 0;
            int bNum = index < bString.length() ? Integer.parseInt(String.valueOf(bString.charAt(index))) : 0;

            String sum = String.valueOf(aNum + bNum + remainder);
            System.out.println(aNum + " + " + bNum + " = " + sum);

            if (sum.length() == 1) {
                result.append(sum);
                remainder = 0;
            } else {
                result.append(String.valueOf(sum.charAt(1)));
                remainder = Integer.parseInt(sum.substring(0,1));
            }
        }

        //package result into nodes

        result = result.reverse();

        int offset = result.length() % 4;

        ListNode<Integer> resultNodes;
        ListNode<Integer> head;

        if (offset != 0) {
            resultNodes = new ListNode<>(Integer.parseInt(result.substring(0, offset)));
        } else {
            resultNodes = new ListNode<>(0001);
        }

        head = resultNodes;


        for (int i = offset; i < (result.length() / 4); i++) {
            resultNodes.next = new ListNode<>(Integer.parseInt(result.substring(i * 4, (i * 4) + 4)));
            resultNodes = resultNodes.next;
        }

        if (offset == 0) head = head.next;

        System.out.println("------------------------");

        System.out.println(aString.toString());
        System.out.println(bString.toString());

        System.out.println(result.toString());

        print(head);

        return null;
    }

    void print(ListNode head) {
         if (head == null) return;
        System.out.println(head.value);
        print(head.next);
    }
}
