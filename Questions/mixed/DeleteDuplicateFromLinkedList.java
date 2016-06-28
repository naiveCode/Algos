/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode nextSmaller;
 *     ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class DeleteDuplicateFromLinkedList {
    public ListNode deleteDuplicates(ListNode a) {
        ListNode head = a;
        ListNode temp = head;
        while (head!=null){
            if(temp.val==head.val){
                head=head.next;
            }else {
                temp.next = head;
                temp=head;
                head=head.next;
            }
        }
        if(temp!=null)
        temp.next = null;
        return a;
    }
}
