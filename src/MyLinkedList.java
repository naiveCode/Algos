import java.util.HashMap;

/**
 * Created by naiveCode on 4/1/16.
 */
public class MyLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = (ptrA != null) ? ptrA.next : headB;
            ptrB = (ptrB != null) ? ptrB.next : headA;
        }
        return ptrA;

    }
}
