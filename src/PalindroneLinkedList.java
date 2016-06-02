/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class PalindroneLinkedList {
    public int lPalin(ListNode A) {
        if(A==null||A.next==null){
            return 1;
        }
        ListNode slow = A;
        ListNode fast = A.next;
        ListNode mid = slow;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;

            fast = fast.next.next;
        }
        ListNode newHead = null;
        if(fast==null){
            mid.next = null;
            newHead = slow.next;
            slow.next=null;

        }else {
            newHead = slow.next;
            slow.next = null;
        }
        ListNode reversed = reverse(newHead);
        while (reversed!=null && reversed.val==A.val){
            reversed = reversed.next;
            A=A.next;
        }
        if(reversed == null){
            return 1;
        }
        else {
            return 0;
        }

    }

    private ListNode reverse(ListNode newHead) {
        ListNode t1 = null;
        ListNode t2 = newHead;
        ListNode t3 = newHead.next;
        while (t3!=null){
            t2.next = t1;
            t1 = t2;t2 = t3;t3 = t3.next;
        }
        t2.next = t1;
        return t2;
    }
}
