/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode head1 = a;
        ListNode head2 = b;
        if(head1==null || head2==null){
            return null;
        }
        while (head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1==null && head2==null){
            head1 = a;
            head2 = b;
            while (head1!=head2){
                head1=head1.next;
                head2=head2.next;
            }
            return head1;
        }else if(head1==null){
            head1=b;
            while (head2!=null){
                head1=head1.next;
                head2 = head2.next;
            }
            head2 = a;
            while (head1!=head2){
                head1=head1.next;
                head2=head2.next;
            }
            return head1;
        }else {
            head2=a;
            while (head1!=null){
                head1=head1.next;
                head2 = head2.next;
            }
            head1 = b;
            while (head1!=head2){
                head1=head1.next;
                head2=head2.next;
            }
            return head1;

        }
    }
}
