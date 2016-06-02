/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode nextSmaller;
 * ListNode(int x) { val = x; nextSmaller = null; }
 * }
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        if(p1 != null)
            p.next = p1;
        if(p2 != null)
            p.next = p2;

        return fakeHead.next;
    }

    public static void main(String[] args) {
        int[] list1 = {12, 22, 27, 29, 38, 41, 45, 75, 75, 87, 99, 109, 113, 142, 177, 188, 191, 204, 205, 228, 271, 284, 286, 291, 300, 308, 310, 326, 327, 337, 352, 364, 372, 382, 384, 389, 405, 427, 465, 483, 496, 505, 508, 508, 515, 519, 524, 532, 536, 555, 561, 588, 588, 626, 635, 662, 671, 671, 674, 692, 696, 698, 706, 717, 732, 741, 744, 753, 759, 779, 786, 792, 804, 811, 819, 821, 835, 848, 860, 860, 864, 864, 868, 872, 874, 880, 909, 913, 915, 929, 929, 958, 990};
        int[] list2 = {7, 12, 46, 66, 84, 86, 93, 116, 131, 132, 179, 222, 230, 238, 246, 253, 254, 256, 290, 301, 357, 372, 375, 391, 395, 396, 402, 424, 439, 494, 508, 535, 554, 592, 593, 612, 629, 711, 719, 721, 731, 738, 746, 758, 768, 769, 780, 782, 831, 835, 837, 873, 874, 882, 907, 936, 960, 970, 982, 987, 990};
        ListNode head1 = new ListNode(list1[0]);
        ListNode head2 = new ListNode(list2[0]);
        ListNode temp = head1;
        for (int i=1;i<list1.length;i++){
            temp.next = new ListNode(list1[i]);
            temp = temp.next;
        }
        temp = head2;
        for (int i=1;i<list2.length;i++){
            temp.next = new ListNode(list2[i]);
            temp = temp.next;
        }
        MergeTwoSortedLinkedLists s = new MergeTwoSortedLinkedLists();
        System.out.println(s.mergeTwoLists(head1,head2));
    }
}
