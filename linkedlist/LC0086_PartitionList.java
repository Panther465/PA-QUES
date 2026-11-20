package linkedlist;

public class LC0086_PartitionList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode big = bigDummy;

        while (head != null) {
            if (head.data < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}
