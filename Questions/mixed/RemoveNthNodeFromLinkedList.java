/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class RemoveNthNodeFromLinkedList {
    public ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode head = a;
        while (b-- != 0 && head != null) {
            head = head.next;
        }
        if (head == null) {
            return a.next;
        }
        ListNode head2 = a;
        ListNode prev = null;
        while (head.next != null) {
            prev = head2;
            head2 = head2.next;
            head = head.next;
        }
        if(head2.next == null){
            prev.next = null;
        }else{
            head2.next = head2.next.next;
        }

        return a;
    }
}
