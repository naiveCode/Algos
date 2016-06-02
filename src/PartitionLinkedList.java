/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode a, int b) {
        ListNode head = a;
        ListNode insertIndexPointer = null;
        ListNode prevHead = head;
        while (head!=null && head.val<b){
            insertIndexPointer = head;
            prevHead = head;
            head = head.next;
        }
        if(head == null){
            return a;
        }
        while (head != null) {
            if (head.val < b) {
                if (insertIndexPointer != null) {
                    ListNode temp = insertIndexPointer.next;
                    prevHead.next = prevHead.next.next;
                    insertIndexPointer.next = head;
                    head.next = temp;
                    insertIndexPointer = insertIndexPointer.next;


                } else {
                    insertIndexPointer = prevHead.next;
                    prevHead.next = prevHead.next.next;
                    insertIndexPointer.next = a;
                    a = insertIndexPointer;
//                    insertIndexPointer = insertIndexPointer.nextSmaller;
                }
                head = prevHead.next;
            } else {
                prevHead = head;
                head = head.next;
            }
        }
        return a;
    }
}
