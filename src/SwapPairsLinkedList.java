/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode nextSmaller;
 *     ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class SwapPairsLinkedList {
    public ListNode swapPairs(ListNode a) {
        if(a==null || a.next==null){
            return a;
        }
        ListNode first = a;
        ListNode second = first.next;
        ListNode prev = first;
        ListNode ans = first.next;
        while ( second!=null && second.next!=null){
            ListNode temp = second.next;
            second.next = first;
            prev = first;
            first.next = temp.next;
            first = temp;
            second = first.next;
        }

        if(second==null){
            prev.next = first;
        }else {
            prev.next = second;
            second.next = first;
            first.next = null;
        }


        return ans;
    }
}
