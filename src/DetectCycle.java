import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a.next;
        while (slow != null && fast != null && fast.next != null) {
            if(slow==fast){
                ListNode ans = a;
                while (slow!=ans){
                    slow = slow.next;
                    ans = ans.next;
                }
                return ans;

            }else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return null;
    }
}
