package Test;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2));
        ListNode l2 = new ListNode(3, new ListNode(8));
        System.out.println(addTwoNumbers(l1, l2).toString());
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode whole = new ListNode(0);
        ListNode tail = whole;
        int saveForNext = 0;

        while (l1 != null || l2 != null || saveForNext != 0) {
            int i1 = (l1 != null) ? l1.val : 0;
            int i2 = (l2 != null) ? l2.val : 0;

            int sum = i1 + i2 + saveForNext;
            int i3 = sum % 10;
            saveForNext = sum / 10;

            ListNode newNode = new ListNode(i3);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = whole.next;
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder strBldr = new StringBuilder();
        while (node != null) {
            strBldr.append(node.val + ", ");
            node = node.next;
        }
        return strBldr.toString();
    }
}
