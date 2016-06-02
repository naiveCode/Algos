/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode nextSmaller;
 *     ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class RotateLinkedList {
    public ListNode rotateRight(ListNode a, int b) {
        ListNode head1 = a;
        while (b--!=0){
            if(head1 ==null){
                head1 = a;
            }
            head1 = head1.next;
        }
        if(head1==null){
            return a;
        }
        ListNode head2 = a;
        while (head1.next!=null){
            head2 = head2.next;
            head1=head1.next;
        }
        ListNode newHead;
        if (head2.next==null){
            newHead =a;
        }else {
            newHead = head2.next;
        }

        head2.next = null;
        head1.next =a;
        return newHead;
    }
}
