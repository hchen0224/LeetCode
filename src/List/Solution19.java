package List;

import java.util.HashMap;
import java.util.Map;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Solution19 {
    /**
     * 解法1：O(3n)时间复杂度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode reversedHead = reverseList(head);
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = reversedHead;
        ListNode preDelete = dummyNode;
        for(int i = 0; i < n-1; ++i){
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return reverseList(dummyNode.next);
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 解法2，O(n)时间复杂度，O(n)空间复杂度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        int count = 0;
        while (cur != null) {
            map.put(index, cur);
            cur = cur.next;
            ++count;
            ++index;
        }

        int indexToDelete = count - n;

        ListNode nodeToDelete = map.get(indexToDelete);
        ListNode pre = map.get(indexToDelete - 1);


        if (pre == null) {
            return nodeToDelete.next;
        } else {
            pre.next = map.get(indexToDelete + 1);
        }

        return head;

    }

    /**
     * 解法3：最优解法，双指针，O(n)时间复杂度，O(1)空间复杂度
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null ) {
            return null;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        //fast 先走 n 步
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        //slow跟着fast同步走，直到 fast 走到末尾节点
        // 此时：
        // 1.fast在倒数第 1 个位置
        // 2.fast 比 slow 多走 n 步，
        // 得出：3.slow 在整个链表的倒数第 n+1 个（即被删除节点的前一个）
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }

}
