/**
 * Created by kaizh on 1/18/2017.
 */
public class ReverseSecondHalf {
     static  class ListNode{
        int val;
        ListNode next;
        ListNode(int val ){
            this.val = val;
        }
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
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
                return head;
        ListNode fast = head, slow = head, pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        while(slow != null){
            fast = slow.next;
            slow.next = pre.next;
            pre.next = slow;
            slow = fast;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,8,6,3,4,2};
        ListNode head = buildList(nums);
        head = reverse(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
