package linkedlist;

public class LC1721_SwappingNodesInLinkedList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        for (int i = 1; i < len - k + 1; i++) {
            second = second.next;
        }

        int t = first.data;
        first.data = second.data;
        second.data = t;

        return head;
    }
}
