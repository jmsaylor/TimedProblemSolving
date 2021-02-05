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

        addTwoHugeNumbers(a, b);
    }

    public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        StringBuilder aString = new StringBuilder();
        StringBuilder bString = new StringBuilder();

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

        StringBuilder result = new StringBuilder();

        int remainder = 0;

        int run = Math.min(aString.length(), bString.length());

        aString = aString.reverse();
        bString = bString.reverse();

        int index = 0;

        System.out.println(aString.charAt(index));
        System.out.println(bString.charAt(0));

        while (index <= run) {
            int aNum = index < aString.length() ? aString.charAt(index) : 0;
            int bNum = index < bString.length() ? bString.charAt(index) : 0;
            String temp = String.valueOf(aNum + bNum + remainder);

            System.out.print(aNum + " " + bNum + " " + temp + " ");

            if (temp.length() == 1) {
                result.append(temp);
            } else {
                result.append(temp.charAt(1));
                remainder = temp.charAt(0);
            }

            index++;
        }
        System.out.println("------------------------");

        System.out.println(aString.toString());
        System.out.println(bString.toString());

        System.out.println(result.toString());
        return null;
    }
}
