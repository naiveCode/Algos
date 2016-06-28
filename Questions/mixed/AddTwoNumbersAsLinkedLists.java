/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class AddTwoNumbersAsLinkedLists {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int rem = 0;
        ListNode head1 = a, head2 = b;
        ListNode prev = head1;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + rem;
            if (sum > 9) {
                rem = 1;
                sum = sum % 10;
            } else {
                rem = 0;
            }
            head1.val = sum;
            prev = head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) {
            if (rem == 1) {
                prev.next = new ListNode(1);
                prev.next.next = null;
            }
            return a;
        } else if (head1 == null) {
            prev.next = head2;
            while (head2 != null && rem != 0) {
                int sum = head2.val + rem;
                if (sum > 9) {
                    rem = 1;
                    sum = sum % 10;

                } else {
                    rem = 0;
                }
                head2.val = sum;
                prev = head2;
                head2 = head2.next;
            }
            if(rem==1){
                prev.next = new ListNode(1);
            }
        }else {
            while (head1!=null && rem!=0){
                int sum = head1.val + rem;
                if(sum>9){
                    rem = 1;
                    sum = sum%10;
                }else {
                    rem = 0;
                }
                head1.val = sum;
                prev = head1;
                head1 = head1.next;
            }
            if (rem==1){
                prev.next = new ListNode(1);
            }
        }
        return a;
    }
}
