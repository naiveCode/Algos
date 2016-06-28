/**
 * Created by naiveCode on 8/1/16.
 */
public class PalLinkList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedList = reverseLinkedList(slow);
        while (reversedList != null) {
            if (reversedList.val != head.val) {
                return false;
            }
            reversedList = reversedList.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode currentNode) {
// For first node, previousNode will be null
        ListNode previousNode = null;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            // reversing the link
            currentNode.next = previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

}
