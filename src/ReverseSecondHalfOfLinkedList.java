/**
 * Created by Tory on 1/12/17.
 */
public class ReverseSecondHalfOfLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val ){
            this.val = val;
        }
    }

    public static ListNode reverseHalf(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head,fast = head,pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reverse(slow);
        pre.next = newHead;
        return head;
    }

    public static ListNode reverse(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//        ListNode newHead = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;

        //iterative way
        ListNode pre = null,current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static ListNode buildList(int[] nums){
        ListNode dummy = new ListNode(0),tail = dummy;
        for(int num : nums){
            ListNode temp = new ListNode(num);
            tail.next = temp;
            tail = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,8,6,3,4,2};
        ListNode head = buildList(nums);
        head = reverseHalf(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
