/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class InsertionSortOnLinkedList {
    public ListNode insertionSortList(ListNode a) {
        ListNode unsorted = a;
        ListNode sorted = new ListNode(-1);
        ListNode ans = sorted;
        while (unsorted != null) {
            int min = Integer.MAX_VALUE;
            ListNode minNode = null;
            ListNode l = unsorted;
            ListNode prev = null;
            while (l != null) {
                if (l.val < min) {
                    minNode = prev;
                    min = l.val;
                }
                prev = l;
                l = l.next;
            }
            if(minNode == null){
                sorted.next = unsorted;
                sorted = sorted.next;
                ListNode temp = unsorted;
                unsorted = unsorted.next;
                temp.next = null;
            }else {
                sorted.next = minNode.next;
                minNode.next = minNode.next.next;
                sorted.next.next = null;
                sorted = sorted.next;
            }
        }
        return ans.next;

    }
}
