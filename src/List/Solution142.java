package List;

/**
 * 142. 环形链表 II
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        //先快慢指针，判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //有环
            if (slow == fast) {
                ListNode p = slow;
                ListNode p2 = head;
                //一个指针从 head 出发，一个从相遇点出发，两者相遇的地方就是入环节点
                while (p != p2) {
                    p = p.next;
                    p2 = p2.next;
                }
                return p;
            }
        }
        return null;
    }
}
