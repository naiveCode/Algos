/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class ReorderLinkedList {
    public ListNode reorderList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode slow = a;
        ListNode fast = a.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode t = slow.next;
        slow.next = null;
        ListNode revHead = reverse(t);
        ListNode head = a;
        while (head!=null){
            ListNode t1 = head.next;
            if(revHead == null){
                head.next = revHead;
                return a;
            }
            ListNode t2 = revHead.next;
            head.next = revHead;
            revHead.next = t1;
            head = t1;
            revHead = t2;
        }
        return a;


    }

    private ListNode reverse(ListNode newHead) {
        ListNode t1 = null;
        ListNode t2 = newHead;
        ListNode t3 = newHead.next;
        while (t3 != null) {
            t2.next = t1;
            t1 = t2;
            t2 = t3;
            t3 = t3.next;
        }
        t2.next = t1;
        return t2;
    }
}
