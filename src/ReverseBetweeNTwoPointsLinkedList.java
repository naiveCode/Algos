/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class ReverseBetweeNTwoPointsLinkedList {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(m==n){
            return a;
        }
        ListNode start = a;
        int end = n - m ;
        if (m == 1) {
            a = reverse(a, end);
        } else {
            while (m-- > 2) {
                start = start.next;
            }
            start.next = reverse(start.next, end);
        }
        return a;
    }

    private ListNode reverse(ListNode newHead, int n) {
        ListNode t1 = null;
        ListNode t2 = newHead;

        ListNode t3 = newHead.next;
        while (n-- >= 0) {
            t2.next = t1;
            t1 = t2;
            t2 = t3;
            if (t2 == null) {
                return t1;

            }
            t3 = t3.next;
        }

        newHead.next = t2;
        return t1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int []arr = {2,3,};
        for (int i=0;i<arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ReverseBetweeNTwoPointsLinkedList s = new ReverseBetweeNTwoPointsLinkedList();
        head = s.reverseBetween(head,1,2);
        while (head!=null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }

    }
}
