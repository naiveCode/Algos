/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class DeleteDuplicateFroLinkedList {
    public ListNode deleteDuplicates(ListNode a) {
        ListNode d = new ListNode(a.val + 1);
        ListNode start = d;
        ListNode head = a;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int value = head.val;
                while (head != null && head.val == value) {
                    head = head.next;
                }
            } else {
                start.next = head;
                start = head;
                head = head.next;
            }
        }
        start.next = null;
        return d.next;


    }
}
