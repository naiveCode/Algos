/**
 * Created by naiveCode on 17/1/16.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tRef = head.next;
        ListNode evenHead = head.next;
        ListNode oddHead = head;
        while (evenHead.next!=null || oddHead.next!=null){
            oddHead.next = evenHead.next;
            evenHead.next = oddHead.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = tRef;

        return head;
    }

    public static void main(String[] args) {

    }
}
